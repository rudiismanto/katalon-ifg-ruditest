import internal.GlobalVariable

Thread.sleep(4000)

def command = [
"/opt/homebrew/bin/kafka-console-consumer",
"--topic", "login-topic",
"--from-beginning",
"--bootstrap-server", "localhost:9092",
"--max-messages", "1"
]

Process process = new ProcessBuilder(command).start()

def outputStream = new StringBuffer()
def errorStream = new StringBuffer()

process.consumeProcessOutput(outputStream, errorStream)
process.waitFor()

//String output = outputStream.toString()

String expectedEvent = "login_success_" + GlobalVariable.randomString

println "Kafka Output:"
println expectedEvent

println "Kafka Error:"
println errorStream.toString()

assert expectedEvent.contains(expectedEvent)