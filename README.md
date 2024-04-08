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