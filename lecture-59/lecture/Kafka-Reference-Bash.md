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

