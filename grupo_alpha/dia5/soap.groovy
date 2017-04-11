@Grab('com.github.groovy-wslite:groovy-wslite:0.8.0')
 
import wslite.soap.SOAPClient
 
def url = 'http://www.webservicex.net/ConvertSpeed.asmx?WSDL'
def client = new SOAPClient(url)
def action = "http://www.webserviceX.NET/ConvertSpeed"
def response = client.send(SOAPAction: action) {
  body {
    ConvertSpeed(xmlns: 'http://www.webserviceX.NET/') {
      speed(1)
      FromUnit('feetPersecond')
      ToUnit('centimetersPersecond')
    }
  }
}
assert response.httpResponse.statusCode == 200
println response.ConvertSpeedResponse.ConvertSpeedResult
