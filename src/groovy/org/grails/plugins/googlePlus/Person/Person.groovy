package org.grails.plugins.googlePlus.Person

class Person {


    String id
    String etag
    String displayName
    Person.Name name
    String nickname
    String tagLine
    String birthday
    String gender
    String aboutMe
    String currentLocation
    String relationshipStatus
    String url
    Person.Image image
    List<Person.Email> emails = []
    List<Url> urls = []
    List<Organization> organizations = []
    List<PlaceLived> placesLived = []
    List<Person.LanguageSpoken> languagesSpoken = []

}
