package org.grails.plugins

import grails.converters.JSON

class AccessTokenService {

    static transactional = true

    String generateAccessToken(String code) {
        StringBuilder sb = new StringBuilder("code=");
        sb.append(URLEncoder.encode(code, "UTF-8"));
        sb.append("&client_id=");
        sb.append(URLEncoder.encode("188806017778-omt5riisuev1ogqghupqgojmc7jdu25c.apps.googleusercontent.com", "UTF-8"));
        sb.append("&client_secret=");
        sb.append(URLEncoder.encode("dZb8-ccIq3WitqVhd1nSc5Up", "UTF-8"));
        sb.append("&redirect_uri=");
        sb.append(URLEncoder.encode("http://localhost:8080/SampleApp/util", "UTF-8"));
        sb.append("&grant_type=");
        sb.append(URLEncoder.encode('authorization_code', "UTF-8"));

        String URL_TO_REQUEST_TOKEN = 'https://accounts.google.com/o/oauth2/token'

        URL url = new URL(URL_TO_REQUEST_TOKEN);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        String accessToken
        try {
            connection.setRequestMethod("POST");
            connection.doOutput = true
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", "" + sb.toString().length());
            connection.setRequestProperty("Host", "accounts.google.com");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());
            outputStreamWriter.write(sb.toString());
            outputStreamWriter.flush();
            log.debug("Response code ${connection.responseCode} , Message : ${connection.responseMessage}")
            String resultData = connection.content.text
            def responseJson = JSON.parse(resultData)
            accessToken = responseJson?.access_token
        }
        catch (Exception e) {
            e.printStackTrace()
        }
        accessToken
    }
}