package kafka

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.apache.kafka.clients.consumer.*
import java.time.Duration
import java.util.Properties
import java.util.Arrays

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

public class KafkaConsumerKeyword {

	static String readMessage(String topic) {

		Properties props = new Properties()
		props.put("bootstrap.servers", "localhost:9092")
		props.put("group.id", "katalon-test")
		props.put("auto.offset.reset", "earliest")
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")

//		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)
//		consumer.subscribe(Arrays.asList(topic))
//
//		ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(10))
//
//		for (ConsumerRecord record : records) {
//			println("Message: " + record.value())
//			return record.value()
//		}
//
//		consumer.close()
//		return null
		
	
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)
		consumer.subscribe(Arrays.asList(topic))
		
		long timeout = System.currentTimeMillis() + 10000
		
		while (System.currentTimeMillis() < timeout) {
		
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(500))
		
			for (ConsumerRecord<String, String> record : records) {
				println("Message: " + record.value())
				consumer.close()
				return record.value()
			}
		}
		
		consumer.close()
		return null
	}
}
