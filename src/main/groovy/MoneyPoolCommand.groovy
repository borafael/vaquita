package vaquita

import grails.validation.Validateable


class MoneyPoolCommand implements Validateable{

    Long id
    String name
    String description
    String url
    Money amount
    MoneyPoolType type
    String mails

    static constraints = {
        name blank: false
        amount null: false
        type null: false
    }

}
