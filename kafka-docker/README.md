# Kafka docker
- `docker-compose -f kafka.yml up` to start kafka at Docker
- `kafka-topics.sh --list --zookeeper zookeeper:2181` to list all kafka topics

# Access kafka
Open Kafka container terminal 
- `cd opt/bitnami/kafka/bin`
- `sh kafka-topics.sh --list --bootstrap-server=localhost:9092`  
- `sh kafka-topics.sh --topic demo_topic --create --partitions 3 --replication-factor 1 --zookeeper localhost:2181`