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


## Step 5 — Start the Consumer (prints key + value)
**Terminal 3**
```bash
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 \
  --topic guvi.events --from-beginning \
  --property print.key=true --property key.separator=" | "
```

✅ Leave it running. It will print incoming messages.


## Step 6 — Start the Producer (type key:value)
**Terminal 4**
```bash
bin/kafka-console-producer.sh --bootstrap-server localhost:9092 \
  --topic guvi.events \
  --property "parse.key=true" --property "key.separator=:"
```

Now type 3 lines (press Enter after each):
```text
k1:hello
k2:enrollment-created
k3:audit-log
```

✅ Expected output in the consumer:
- `k1 | hello`
- `k2 | enrollment-created`
- `k3 | audit-log`


## Common issues and fastest fixes
- **Command not found:** you are not inside the Kafka folder → `cd` into the extracted Kafka directory and retry
- **Port in use (2181 or 9092):** close old Kafka/ZooKeeper terminals or stop the process using that port, then restart
- **Broker not available:** Kafka may still be starting → wait 10 seconds and retry
- **Consumer prints nothing:** confirm topic name `guvi.events`, send a new message after consumer starts, or keep `--from-beginning`
