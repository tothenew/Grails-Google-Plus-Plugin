package org.grails.plugins

import grails.converters.JSON
import org.grails.plugins.googlePlus.AccessTokenData
import org.grails.plugins.googlePlus.GooglePlusException
import org.grails.plugins.googlePlus.Person.GooglePlusUtil
import org.grails.plugins.googlePlus.Person.Person

class GooglePlusService {
    static transactional = false

//    private static final googleProfileUrl = "https://www.googleapis.com/oauth2/v1/userinfo"
    private static final googleProfileUrl = "https://www.googleapis.com/oauth2/v1/userinfo"
    private static final String BASE_URL = "https://www.googleapis.com/plus/"
    public String accessToken

    public AccessTokenData getAccessToken() {
        AccessTokenData accessTokenData = new AccessTokenData(accessToken: accessToken)
        return accessTokenData
    }

    public String getAuthorizationUrl() {
        GooglePlusUtil.authorizationUrl
    }

    public Person getCurrentUserProfile() {
        Person person
        try {
            URL url = new URL("https://www.googleapis.com/plus/v1/people/me?access_token=${this.accessToken}")
//            URL url = new URL(googleProfileUrl + "?access_token=${accessToken}")
            def jsonString = JSON.parse(url?.text)
            println "URL : " + url.toString()
            println "JSON : " + jsonString

            person = Person.parseJSONForPerson(jsonString)
        } catch (GooglePlusException e) {
            e.printStackTrace()
        }
        return person
    }
}
