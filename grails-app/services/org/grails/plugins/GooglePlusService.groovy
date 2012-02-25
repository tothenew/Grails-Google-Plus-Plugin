package org.grails.plugins

import org.grails.plugins.googlePlus.GooglePlusData
import org.grails.plugins.googlePlus.Person.Person
import java.security.PublicKey
import org.grails.plugins.googlePlus.People
import grails.converters.JSON
import org.grails.plugins.googlePlus.Person.Image
import org.grails.plugins.googlePlus.Person.Name
import org.grails.plugins.googlePlus.GooglePlusException
import org.grails.plugins.googlePlus.Person.GooglePlusUtil

class GooglePlusService {

    static transactional = false

    public String accessToken = 'demo'

    private static final String BASE_URL = "https://www.googleapis.com/plus/"


    GooglePlusData getAccessToken() {
        GooglePlusData googlePlusData = new GooglePlusData(accessToken: accessToken)
        return googlePlusData
    }

    String getAuthorizationUrl() {
        return GooglePlusUtil.authorizationUrl
    }

    void setAccessToken(String accessToken) {
        this.accessToken = accessToken
    }


    public Person getCurrentUserProfile() {
        Person person
        try {
            URL url = new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=${accessToken}")
            def jsonString = JSON.parse(url?.text)
            person = Person.parseJSONForPerson(jsonString)
        } catch (GooglePlusException e) {
            e.printStackTrace()
        }
        return person
    }

    public People getPersonsList() {
        People people = new People()
        return people
    }
}
