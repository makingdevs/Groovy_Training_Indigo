import groovy.json.JsonSlurper

@Singleton
class Followers {
    String apiMethod = "users/:user/followers"

    def followersOf(username){
      def users = []
      def jsonSlurper = new JsonSlurper()
      def method = apiMethod.replace(':user',username)
      def httpConnection = new URL(ApiSystem.instance.makeRequest(method))
      def s = httpConnection.text
      def queryResult = jsonSlurper.parseText(s)
      users = queryResult.collect { u -> 
        new User(username: u.login, id: u.id, screenName:u.html_url )  
      }
      users
    }
}
