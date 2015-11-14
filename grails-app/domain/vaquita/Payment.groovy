package vaquita

import Money

class Payment {

	Date date
	Commitment commitment

	static belongsTo = Commitment

    static constraints = {
    }
}