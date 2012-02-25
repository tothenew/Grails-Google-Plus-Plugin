package org.grails.plugins.googlePlus

class GooglePlusException extends RuntimeException {

    private static final long serialVersionUID = -553433433711801L;

    def result

    public GooglePlusException() {
        result = [:]
    }


    public GooglePlusException(result) {
        super(result['error'] ? result['error']['message'] : result['error_msg'])
        this.result = result
    }


    public def getType() {
        return (result['error'] && result['error']['type']) ? result['error']['type'] : 'Exception'
    }


    public String toString() {
        return getType() + ': ' + getMessage()
    }
}


