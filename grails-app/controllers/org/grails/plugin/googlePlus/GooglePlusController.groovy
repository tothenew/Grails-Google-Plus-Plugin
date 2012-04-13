package org.grails.plugin.googlePlus

import org.codehaus.groovy.grails.commons.ConfigurationHolder

class GooglePlusController {

    def accessTokenService
    def googlePlusService

    def callback = {
        String accessToken = accessTokenService.generateAccessToken(params.code)
        googlePlusService.accessToken = accessToken
        String callbackAction = ConfigurationHolder.config.grails.plugins.googlePlus.callbackAction
        String callbackController = ConfigurationHolder.config.grails.plugins.googlePlus.callbackController
        redirect(controller: callbackController , action: callbackAction , params: [accessToken: accessToken])
    }
}
