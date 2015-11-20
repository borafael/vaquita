package vaquita

class Payment {

	Date date
	Money money

	static embedded = ['money']

	static belongsTo = [commitment: Commitment]

    static constraints = {
    }
}