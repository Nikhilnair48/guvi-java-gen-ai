# MongoDB Reference: Indexing, Reference vs Embedded Documents

---

## SECTION 0: DB + Collections Creation

**Commands**
```js
use studentsdb_test

db.createCollection("students")
db.createCollection("courses")
db.createCollection("enrollments")

show collections
````

**Expected**

* `show collections` prints: `students`, `courses`, `enrollments`

---

## SECTION 1: Insert Mock Data (students)

**Commands**

```js
db.students.deleteMany({})

db.students.insertMany([
  {
    name: "malini",
    email: "ma@example.com",
    active: true,
    city: "Bangalore",
    createdAt: new Date("2026-01-10T10:00:00Z"),
    address: { line1: "10 5th Main", pincode: "560043", state: "Karnataka" }
  },
  {
    name: "ashik",
    email: "as@example.com",
    active: true,
    city: "Chennai",
    createdAt: new Date("2026-01-12T10:00:00Z"),
    address: { line1: "22 Lake Road", pincode: "600001", state: "Tamil Nadu" }
  },
  {
    name: "thirumalini",
    email: "t-malini@example.com",
    active: false,
    city: "Kochi",
    createdAt: new Date("2026-01-15T10:00:00Z"),
    address: { line1: "7 Marine Drive", pincode: "682001", state: "Kerala" }
  },
  {
    name: "shalini",
    email: "sh@example.com",
    active: true,
    city: "Bangalore",
    createdAt: new Date("2026-01-18T10:00:00Z"),
    address: { line1: "44 2nd Cross", pincode: "560001", state: "Karnataka" }
  },
  {
    name: "thirumani",
    email: "th@example.com",
    active: true,
    city: "Trivandrum",
    createdAt: new Date("2026-01-20T10:00:00Z"),
    address: { line1: "9 Temple Street", pincode: "695001", state: "Kerala" }
  },
  {
    name: "yirou",
    email: "yi@example.com",
    active: false,
    city: "Bangalore",
    createdAt: new Date("2026-01-22T10:00:00Z"),
    address: { line1: "18 Market Road", pincode: "560043", state: "Karnataka" }
  },
  {
    name: "armaan",
    email: "ar@example.com",
    active: true,
    city: "Pune",
    createdAt: new Date("2026-01-25T10:00:00Z"),
    address: { line1: "31 Station Road", pincode: "411001", state: "Maharashtra" }
  },
  {
    name: "ashwin",
    email: "aw@example.com",
    active: true,
    city: "Hyderabad",
    createdAt: new Date("2026-01-27T10:00:00Z"),
    address: { line1: "55 Tech Park", pincode: "500081", state: "Telangana" }
  }
])
```

**Quick verify**

```js
db.students.countDocuments()

db.students.find(
  {},
  { name: 1, email: 1, active: 1, city: 1, "address.pincode": 1 }
)
```

**Expected**

* Count should be `8`
* Find output should show each student with the fields listed

---

## SECTION 2: Baseline (force COLLSCAN)

**Goal:** See the “slow path” first, so we can prove indexes help.

**Commands**

```js
db.students.getIndexes()
```

**Expected**

* Only one index should be present initially: `_id`

**Query to optimize**

```js
db.students.find({ city: "Bangalore", active: true })
```

**Proof using explain**

```js
db.students.find({ city: "Bangalore", active: true })
  .explain("executionStats")
```

**Expected**

* `winningPlan.stage` is often `COLLSCAN`

**What to notice (only these 4 fields)**

1. `winningPlan.stage` (COLLSCAN or IXSCAN)
2. `executionStats.nReturned`
3. `executionStats.totalDocsExamined`
4. `executionStats.totalKeysExamined`

If it is COLLSCAN, `totalDocsExamined` is usually high compared to the number of results returned.

---

## SECTION 3: Single-field index (city)

**Goal:** Improve queries that filter by city.

**Commands**

```js
db.students.createIndex({ city: 1 })
db.students.getIndexes()
```

**Explain the same query again**

```js
db.students.find({ city: "Bangalore", active: true })
  .explain("executionStats")
```

**Also test a city-only query**

```js
db.students.find({ city: "Bangalore" })
  .explain("executionStats")
```

**Expected**

* `winningPlan.stage` becomes `IXSCAN` or includes an index scan
* `totalDocsExamined` should drop compared to the baseline run

**What to notice**

* A single-field index helps, but it’s not perfectly aligned to `{ city, active }` as a pair.

---

## SECTION 4: Compound index (city + active)

**Commands**

```js
db.students.createIndex({ city: 1, active: 1 })
db.students.getIndexes()
```

**Explain common queries**

```js
db.students.find({ city: "Bangalore", active: true })
  .explain("executionStats")

db.students.find({ city: "Bangalore" })
  .explain("executionStats")

db.students.find({ active: true })
  .explain("executionStats")
```

**Expected**

* `{ city: "Bangalore", active: true }` should benefit the most
* `{ city: "Bangalore" }` should also benefit (prefix rule)
* `{ active: true }` usually does not benefit from this index (since `active` is not the prefix)

**What to notice**

* Index field order matters. `{ city: 1, active: 1 }` is designed for queries starting with `city`.

---

## SECTION 5: Unique index (email)

**Goal:** Use an index to enforce a rule: no duplicate emails.

**Commands**

```js
db.students.createIndex({ email: 1 }, { unique: true })
db.students.getIndexes()
```

**Try inserting a duplicate**

```js
db.students.insertOne({
  name: "StudentDuplicate",
  email: "ma@example.com",
  active: true,
  city: "Bangalore",
  createdAt: new Date(),
  address: { line1: "X", pincode: "560043", state: "Karnataka" }
})
```

**Expected**

* MongoDB throws a `duplicate key error`
* That error is correct and desirable

**What to notice**

* Some indexes exist for speed.
* Some indexes exist to protect data quality.
* Unique index is mainly about correctness.

---

## SECTION 6: Index an embedded field (address.pincode)

**Goal:** Show that MongoDB can index inside embedded documents.

**Commands**

```js
db.students.find({ "address.pincode": "560043" })
  .explain("executionStats")

db.students.createIndex({ "address.pincode": 1 })
db.students.getIndexes()

db.students.find({ "address.pincode": "560043" })
  .explain("executionStats")
```

**See the matching documents**

```js
db.students.find(
  { "address.pincode": "560043" },
  { name: 1, city: 1, "address.pincode": 1 }
).limit(10)
```

**Expected**

* Before index: higher `totalDocsExamined`
* After index: `IXSCAN` is more likely and docs examined should reduce

**What to notice**

* Dot notation (`"address.pincode"`) is how you query and index nested fields.

---

## SECTION 7: Insert Courses

**Goal:** Create shared entities in a separate collection.

**Commands**

```js
db.courses.deleteMany({})
db.enrollments.deleteMany({})

db.courses.insertMany([
  { code: "JAVA101", title: "Java Foundations", level: "Beginner" },
  { code: "MDB201",  title: "MongoDB Basics",   level: "Intermediate" },
  { code: "SPR301",  title: "Spring Boot + Mongo", level: "Intermediate" }
])

db.courses.find()
```

**Expected**

* You see 3 course documents

**What to notice**

* Courses are reusable. Many students can enroll in the same course.

---

## SECTION 8: Reference model (enrollments + $lookup)

**Goal:** Model a relationship that has its own fields: `status`, `progressPct`, `enrolledAt`.

**Insert enrollments**

```js
db.enrollments.insertOne({
  studentId: db.students.findOne({ name: "malini" })._id,
  courseId: db.courses.findOne({ code: "JAVA101" })._id,
  enrolledAt: new Date(),
  status: "active",
  progressPct: 35
})

db.enrollments.insertOne({
  studentId: db.students.findOne({ name: "malini" })._id,
  courseId: db.courses.findOne({ code: "MDB201" })._id,
  enrolledAt: new Date(),
  status: "active",
  progressPct: 10
})

db.enrollments.insertOne({
  studentId: db.students.findOne({ name: "ashik" })._id,
  courseId: db.courses.findOne({ code: "JAVA101" })._id,
  enrolledAt: new Date(),
  status: "completed",
  progressPct: 100
})

db.enrollments.insertOne({
  studentId: db.students.findOne({ name: "shalini" })._id,
  courseId: db.courses.findOne({ code: "SPR301" })._id,
  enrolledAt: new Date(),
  status: "active",
  progressPct: 55
})
```

**Basic queries (reference side)**

```js
db.enrollments.find({ studentId: db.students.findOne({ name: "malini" })._id })

db.enrollments.find({ status: "active", progressPct: { $gt: 50 } })
```

**Join enrollments to courses for malini**

```js
db.enrollments.aggregate([
  { $match: { studentId: db.students.findOne({ name: "malini" })._id } },
  { $lookup: {
      from: "courses",
      localField: "courseId",
      foreignField: "_id",
      as: "course"
  }},
  { $unwind: "$course" },
  { $project: { _id: 0, status: 1, progressPct: 1, enrolledAt: 1, "course.code": 1, "course.title": 1 } }
])
```

**Expected**

* Without `$unwind`, `course` is an array (because `$lookup` always returns an array).
* With `$unwind`, `course` becomes a single object per enrollment row, which is easier to project and read.

**Optional indexes (realistic performance)**

```js
db.enrollments.createIndex({ studentId: 1 })
db.enrollments.createIndex({ courseId: 1 })
db.enrollments.getIndexes()
```

**What to notice**

* Reference model makes reporting queries easy because enrollments are their own documents.
* `$lookup` is used only when you want course details along with enrollment details.

---

## SECTION 9: Embedded model (coursesEmbedded inside student)

**Goal:** Compare the output shape and tradeoffs against the reference model.

Here we store the enrolled course info directly inside the student document.

**Update malini**

```js
db.students.updateOne(
  { name: "malini" },
  { $set: {
      coursesEmbedded: [
        { code: "JAVA101", title: "Java Foundations", enrolledAt: new Date(), status: "active" },
        { code: "MDB201",  title: "MongoDB Basics",  enrolledAt: new Date(), status: "active" }
      ]
  }}
)
```

**Read malini**

```js
db.students.findOne(
  { name: "malini" },
  { name: 1, email: 1, coursesEmbedded: 1 }
)
```

**Expected**

* You get one student document.
* Inside it, `coursesEmbedded` is an array containing the enrolled courses.

**What to notice (compare with Section 8)**

* Reference model (Section 8) gives one enrollment per row, and you join to get course details when needed.
* Embedded model (Section 9) gives everything for the student in one read.

**Practical tradeoff**

* Embedded is convenient when the embedded list is small and frequently read with the parent.
* Reference is safer when the relationship grows, changes often, or needs reporting across many students.
* If you embed shared course info, you risk duplication (course title changes would need updates in many student documents).

---

## Key Takeaways

* “COLLSCAN means Mongo scanned documents. IXSCAN means Mongo used an index.”
* “To prove it, I check stage, docs examined, keys examined, and nReturned.”
* “Compound index matches a real query pattern and field order matters.”
* “Unique index is a correctness rule.”
* “Reference vs embedded depends on access patterns and how big the relationship can grow.”