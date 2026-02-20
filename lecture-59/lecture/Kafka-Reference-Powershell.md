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
