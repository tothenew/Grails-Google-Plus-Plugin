package org.grails.plugins
class AccessTagLib {

    static namespace = "gp"

    def registerOnGooglePlus = {attrs ->
        String scope = attrs['googlePlusScope'] ?: "https://www.googleapis.com/auth/plus.me"
        String callbackUrl = attrs['callbackUrl']
        String clientId = attrs['clientId']
        String buttonName = attrs['buttonName'] ?: 'Connect_to_Google+'
        String authorizeUrl = "https://accounts.google.com/o/oauth2/auth?scope=${scope}&redirect_uri=${callbackUrl}&response_type=code&client_id=${clientId}&access_type=offline"
        out << "<input type='button' value=${buttonName} onclick=\"location.href='${authorizeUrl}'\">"
    }

}
