package org.grails.plugins.googlePlus.Person

public enum ObjectType {
    PERSON('person'),
    PAGE('page')

    final String id

    ObjectType(String id) {
        this.id = id
    }

    public String getKey() {
        return name()
    }

    public String getValue() {
        return id
    }

    public String toString() {
        return id
    }

    public static List<ObjectType> list() {
        return [PERSON, PAGE]
    }
}
