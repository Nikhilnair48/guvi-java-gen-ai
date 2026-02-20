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
