package org.grails.plugins

import org.grails.plugins.googlePlus.Person.GooglePlusUtil

class AccessTagLib {

    static namespace = "gp"

    def registerOnGooglePlus = {attrs ->
        String buttonName = attrs['buttonName'] ?: 'Connect_to_Google+'
        String authorizeUrl = GooglePlusUtil.getAuthorizationUrl()
        out << "<input type='button' value=${buttonName} onclick=\"location.href='${authorizeUrl}'\">"
    }
}
