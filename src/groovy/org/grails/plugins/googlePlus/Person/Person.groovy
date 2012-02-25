package org.grails.plugins.googlePlus.Person

class Person {

    String id
    String etag
    String displayName
    Name name
    String nickname
    String tagLine
    String birthday
    String gender
    String aboutMe
    String currentLocation
    String relationshipStatus
    String url
    String locale
    Image image
    List<Email> emails = []
    List<Url> urls = []
    List<Organization> organizations = []
    List<PlaceLived> placesLived = []
    List<LanguageSpoken> languagesSpoken = []


    static Person parseJSONForPerson(def json) {
        Person person = new Person()
        person.id = json?.id
        person.displayName = json?.displayName
        person.gender = json?.gender
        person.locale = json?.locale
        person.aboutMe = json?.aboutMe
        person.url = json?.url
        Image image = new Image()
        image.url = json?.image?.url
        person.image = image
        Name name = new Name()
        name.familyName = json?.name?.familyName
        name.givenName = json?.given_name
        name.middleName = json?.name?.givenName
        person.name = name
        return person
    }

}
