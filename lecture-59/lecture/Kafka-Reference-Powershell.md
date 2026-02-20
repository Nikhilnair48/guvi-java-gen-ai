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

## Step 4 — Create the topic
Topic name: `guvi.events`

**Single broker local setup: replication-factor 1, partitions 1**
```powershell
.\bin\windows\kafka-topics.bat --create --topic guvi.events --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1
```

Verify:
```powershell
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list
```

(Optional) Describe:
```powershell
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --describe --topic guvi.events
```

## Step 5 — Start the consumer (prints key + value)
**Terminal 3**
```powershell
.\bin\windows\kafka-console-consumer.bat --topic guvi.events --from-beginning --bootstrap-server localhost:9092 --property "print.key=true" --property "key.separator= | "
```

Leave it running.

## Step 6 — Start the producer (type `key:value`)
**Terminal 4**
```powershell
.\bin\windows\kafka-console-producer.bat --topic guvi.events --bootstrap-server localhost:9092 --property "parse.key=true" --property "key.separator=:"
```

Now type 3 lines (press Enter after each):
```text
k1:hello
k2:enrollment-created
k3:audit-log
```

Expected output in the consumer:
- `k1 | hello`
- `k2 | enrollment-created`
- `k3 | audit-log`

---

## Stopping servers
- To stop **Kafka**: go to the Kafka terminal and press `Ctrl + C`
- To stop **ZooKeeper**: go to the ZooKeeper terminal and press `Ctrl + C`

If you restart, start ZooKeeper first, then Kafka.

---

## Common issues and fastest fixes
- **Command not found**: you’re not in the Kafka folder → `cd` into the extracted Kafka directory
- **Port in use (2181 or 9092)**: close old ZooKeeper/Kafka terminals or stop the process using that port, then restart
- **Broker not available**: Kafka may still be starting → wait ~10 seconds and retry topic/list commands
- **Consumer prints nothing**: confirm topic `guvi.events`; start consumer first, then send new messages; keep `--from-beginning`
- **Windows path issues / “input line is too long”**: move Kafka closer to root, e.g. `C:\kafka\...`
