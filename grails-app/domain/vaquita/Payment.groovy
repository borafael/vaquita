package vaquita

class Payment {

	Date date
	Money amount

	static embedded = ['amount']

	static belongsTo = [commitment: Commitment]

    static constraints = {
    }
}
