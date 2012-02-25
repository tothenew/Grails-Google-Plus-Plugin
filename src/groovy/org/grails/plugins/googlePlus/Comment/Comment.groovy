package org.grails.plugins.googlePlus.Comment

import org.grails.plugins.googlePlus.Activity.Actor

class Comment {

    String kind
    String etag
    String id
    Date published
    Date updated
    Actor actor
    String verb
    CommentObject object
    String selfLink
    List<InReplyTo> inReplyTo = []
}
