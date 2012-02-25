package org.grails.plugins

import org.grails.plugins.googlePlus.GooglePlusData

class GooglePlusService {

    static transactional = true

    public String accessToken = ''

    GooglePlusData getAccessToken() {
        GooglePlusData googlePlusData = new GooglePlusData(accessToken: accessToken)
        return googlePlusData
    }
}
