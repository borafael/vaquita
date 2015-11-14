package vaquita

enum MoneyPoolType {
}

class MoneyPool {

	String name
	String description
	String url
	MoneyPoolType type
    User creator

    static hasMany = [participants: User]
    static belongsTo = User

    static constraints = {
    	name blank: false
    	type null: false
    }
}