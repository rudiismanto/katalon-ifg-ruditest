import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.ResponseObject

ResponseObject response = WS.sendRequest(findTestObject('POST Create Object', [
    ('email') : username,
    ('password') : password
]))

int actualStatus = response.getStatusCode()
int expectedStatus = httpcode.toInteger()

println("Actual Status: " + actualStatus)
println("Expected Status: " + expectedStatus)

assert actualStatus == expectedStatus