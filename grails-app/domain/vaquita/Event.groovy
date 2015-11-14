package vaquita

enum Frequency {
	NONE,
	DAILY,
	MONTHLY,
	YEARLY
}

class Event {

    String description
    Date date
    Frequency frequency

	static constraints = {
		description blank: false
		frequency null: false
    }
}
