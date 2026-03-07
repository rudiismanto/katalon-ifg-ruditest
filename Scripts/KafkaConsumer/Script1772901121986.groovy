import kafka.KafkaConsumerKeyword

Thread.sleep(4000)

//String message = KafkaConsumerKeyword.readMessage("login-topic")
//
//println("Kafka Message: " + message)
//
//assert message != null
//assert message.contains("login_success")

String command = """
bash -c "timeout 5 kafka-console-consumer \
--topic login-topic \
--from-beginning \
--bootstrap-server localhost:9092"
"""

Process process = command.execute()

String output = process.text

println "Kafka Output:"
println output

assert output.contains('{"event":"login_success","email":"risma@mailinator.com"}')