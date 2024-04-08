# Spring boot Apache Kafka publish to topic and consume message
- 1st install kakfa in your windows ( actually no installation, just download the binaries from apache site)
- Start zookeeper ( in latest versions this is depreciated)
- next start kakfa server

# Publish 
- send below request via postman or curl.
- it takes "message=<Namaste>" as request parameter

# Consumer
- open a console-consumer in your cmd prompt to consumer msg
-
kafka_2.13-3.7.0\bin\windows>.\kafka-console-consumer.bat --topic quickstart-events --bootstrap-server localhost:9092 --from-beginning
yahoo
google
lkj
"Namaste"

# Request
curl --location --request POST 'http://localhost:8080/publish?message=%22my%20message%22'


# Response
200 OK 

----------------------------

## Consumer

- To consume, make sure the consumer group id is correct in application.properties file


# Request
curl --location --request POST 'http://localhost:8080/publish?message=%225th%20message%22'

# Response

2024-04-08T12:24:23.479-03:00  INFO 4380 --- [kafka] [nio-8080-exec-3] o.a.k.clients.producer.KafkaProducer     : [Producer clientId=producer-1] Instantiated an idempotent producer.
2024-04-08T12:24:23.492-03:00  INFO 4380 --- [kafka] [nio-8080-exec-3] o.a.kafka.common.utils.AppInfoParser     : Kafka version: 3.6.1
2024-04-08T12:24:23.492-03:00  INFO 4380 --- [kafka] [nio-8080-exec-3] o.a.kafka.common.utils.AppInfoParser     : Kafka commitId: 5e3c2b738d253ff5
2024-04-08T12:24:23.492-03:00  INFO 4380 --- [kafka] [nio-8080-exec-3] o.a.kafka.common.utils.AppInfoParser     : Kafka startTimeMs: 1712589863492
2024-04-08T12:24:23.497-03:00  INFO 4380 --- [kafka] [ad | producer-1] org.apache.kafka.clients.Metadata        : [Producer clientId=producer-1] Cluster ID: jNcafmOiQuS0cCQDrCIYpQ
2024-04-08T12:24:23.498-03:00  INFO 4380 --- [kafka] [ad | producer-1] o.a.k.c.p.internals.TransactionManager   : [Producer clientId=producer-1] ProducerId set to 2001 with epoch 0
sent message
====== Message from topic :console-consumer-72574is : "4th message"
publish================= Kafka topic is quickstart-events
sendMessage ================= Kafka topic is quickstart-events
sent message
====== Message from topic :console-consumer-72574is : "5th message"