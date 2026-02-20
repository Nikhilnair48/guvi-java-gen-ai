# Day 47 — Kafka + ZooKeeper Local Setup (Windows + PowerShell)

## Goal
By the end, you should be able to:
- Download Kafka (this class uses ZooKeeper mode)
- Start ZooKeeper and Kafka locally
- Create the topic `guvi.events`
- Send messages using a producer and read them using a consumer (key + value)

## Prerequisites
- Java installed and available in PATH: `java -version`
- PowerShell
- 2–4 terminals (ZooKeeper, Kafka, consumer, producer)
- Ports free: `2181` (ZooKeeper), `9092` (Kafka)

## Step 0 — Download and extract Kafka
1) Download Kafka 3.9.0
- https://kafka.apache.org/downloads
- Choose **Binary downloads** and download the **.zip** if you’re on Windows

2) Extract the zip.
After extracting, you should see:
- `bin\`
- `config\`

## Step 0.5 — Open PowerShell and `cd` into the Kafka folder
Before running any `bin\windows\...` commands, you must be inside the extracted Kafka directory.

Example:
```powershell
cd C:\kafka\kafka_2.13-3.9.0
```

Quick check:
```powershell
dir
```
You should see `bin` and `config` in the output.

---

## Step 1 — Start ZooKeeper
**Terminal 1**
```powershell
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

Success looks like: the process stays running (no exit with error).

## Step 2 — Start Kafka (broker)
**Terminal 2**
```powershell
.\bin\windows\kafka-server-start.bat .\config\server.properties
```

Success looks like: the process stays running and Kafka listens on `localhost:9092`.

## Step 3 — Quick health check (list topics)
**Any terminal**
```powershell
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list
```

If this works, Kafka is reachable.

