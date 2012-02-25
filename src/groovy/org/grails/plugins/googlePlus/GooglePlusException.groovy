package org.grails.plugins.googlePlus

class GooglePlusException extends Exception {

    private static final long serialVersionUID = -5070446410644711801L;


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


