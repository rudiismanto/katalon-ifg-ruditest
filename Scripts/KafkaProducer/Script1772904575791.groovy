import org.apache.commons.lang3.RandomStringUtils
import internal.GlobalVariable

GlobalVariable.randomString = RandomStringUtils.randomAlphabetic(6)

String eventName = "login_success_" + GlobalVariable.randomString

String message = """{"event":"${eventName}","email":"risma@mailinator.com"}"""

println "Kafka Message:"
println message

def command = [
"/opt/homebrew/bin/kafka-console-producer",
"--topic","login-topic",
"--bootstrap-server","localhost:9092"
]

Process process = new ProcessBuilder(command).start()

process.outputStream.write((message + "\n").getBytes())
process.outputStream.flush()
process.outputStream.close()

process.waitFor()

println "Kafka message sent"