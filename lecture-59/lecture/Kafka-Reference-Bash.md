# Day 47 — Kafka + ZooKeeper Local Setup

## Goal
By the end, you should be able to:
- Download Kafka (includes ZooKeeper for this class setup)
- Start ZooKeeper and Kafka locally
- Create the topic `guvi.events`
- Send messages using a producer and read them using a consumer


## Step 0 — Download Kafka (including ZooKeeper)
Note:  **ZooKeeper comes bundled with Kafka** in the Apache Kafka download.

### Download link
- Apache Kafka Downloads: https://kafka.apache.org/downloads

### What to download
- Please download v3.9.0
- Download the **Binary downloads** file (recommended), for example: `kafka_2.13-<version>.tgz`

### Extract it
After extracting, you should have a folder that contains:
- `bin/`
- `config/`

> From now on, all commands below are run **inside the Kafka folder** you extracted.

## Step 0.5 — Open a terminal and `cd` into the Kafka folder
Before running any `bin/...` commands, you must be inside the extracted Kafka directory.

Example (replace with your actual path):
```bash
cd ~/Downloads/kafka_2.13-3.9.0

## Prerequisites
- Java installed: run `java -version` and confirm it works
- 2–4 terminals (ZooKeeper, Kafka, consumer, producer)
- Ports free: `2181` (ZooKeeper), `9092` (Kafka)

## Step 1 — Start ZooKeeper
**Terminal 1**
```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```

✅ Success looks like: process stays running (no exit with error)


## Step 2 — Start Kafka
**Terminal 2**
```bash
bin/kafka-server-start.sh config/server.properties
```

✅ Success looks like: process stays running and broker starts listening on `localhost:9092`


## Step 3 — Quick health check
**Any terminal**
```bash
bin/kafka-topics.sh --bootstrap-server localhost:9092 --list
```

✅ If this works, Kafka is reachable.


## Step 4 — Create the topic (locked for class)
Topic name: `guvi.events`

```bash
bin/kafka-topics.sh --bootstrap-server localhost:9092 \
  --create --topic guvi.events --partitions 1 --replication-factor 1
```

Verify:
```bash
bin/kafka-topics.sh --bootstrap-server localhost:9092 --list
```


