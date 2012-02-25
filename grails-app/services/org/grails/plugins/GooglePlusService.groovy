package org.grails.plugins

import org.grails.plugins.googlePlus.GooglePlusData
import org.grails.plugins.googlePlus.Person.Person
import java.security.PublicKey
import org.grails.plugins.googlePlus.People
import grails.converters.JSON
import org.grails.plugins.googlePlus.Person.Image
import org.grails.plugins.googlePlus.Person.Name
import org.grails.plugins.googlePlus.GooglePlusException

class GooglePlusService {

    static transactional = true

    public String accessToken = 'ya29.AHES6ZTVl8pWlBmc4WH3G77rHgiHW6pFj8zerYVDiGCiQw'

    private static final String BASE_URL = "https://www.googleapis.com/plus/"


    GooglePlusData getAccessToken() {
        GooglePlusData googlePlusData = new GooglePlusData(accessToken: accessToken)
        return googlePlusData
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

//    def apiCall(String accessToken) {
//
//
//        URL url = new URL("${BASE_URL}${url}&acce")
//    }
}
