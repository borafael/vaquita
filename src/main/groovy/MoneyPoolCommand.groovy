package vaquita

import grails.validation.Validateable


class MoneyPoolCommand implements Validateable{

    String name
    String description
    String url
    Money amount
    MoneyPoolType type

    static constraints = {
        name blank: false
        amount null: false
        type null: false
    }

}
