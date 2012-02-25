package org.grails.plugins

import org.grails.plugins.googlePlus.GooglePlusData
import org.grails.plugins.googlePlus.Person.Person
import java.security.PublicKey
import org.grails.plugins.googlePlus.People

class GooglePlusService {

    static transactional = true

    public String accessToken = ''

    private static final String BASE_URL = "https://www.googleapis.com/plus/"


    GooglePlusData getAccessToken() {
        GooglePlusData googlePlusData = new GooglePlusData(accessToken: accessToken)
        return googlePlusData
    }


    public People getPersonsList() {
        People people = new People()
        return people
    }
}
