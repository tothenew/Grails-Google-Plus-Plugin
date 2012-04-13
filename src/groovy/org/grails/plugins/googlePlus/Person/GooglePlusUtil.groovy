package org.grails.plugins.googlePlus.Person

import org.codehaus.groovy.grails.commons.ConfigurationHolder

class GooglePlusUtil {

    static String getAuthorizationUrl() {
        String clientId = ConfigurationHolder.config.grails.plugins.googlePlus.clientId
        String callbackUrl = ConfigurationHolder.config.grails.plugins.googlePlus.callBackUrl
        String scope = ConfigurationHolder.config.grails.plugins.googlePlus.scope ?: 'https://www.googleapis.com/auth/plus.me'
        return "https://accounts.google.com/o/oauth2/auth?scope=${scope}&redirect_uri=${callbackUrl}&response_type=code&client_id=${clientId}&access_type=offline"
    }
}
