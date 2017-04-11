@Singleton
class ApiSystem {
  String urlBase = "https://api.github.com/"
  String token = System.getenv("GITHUB_TOKEN")
  String permanentParams = "access_token=${token}"

  def makeRequest(metodo, params=[:]){
    "${urlBase}${metodo}?${parseParams(params)}&${permanentParams}"
  }
  def parseParams(Map params){
    params.collect {k,v -> "${k}=${v}"}.join('&')
  }
}

