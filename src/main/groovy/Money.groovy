enum Currency {
	ARS,
	USD,
	EUR
}

class Money {
	float amount
	Currency Currency

	def changeAmount(float amount) {
		return new Money(amount, this.currency)
	}

	def changeCurrency(Currency currency) {
		return changeCurrency(currency, 1)
	}

	def changeCurrency(Currency currency, float rate) {
		return new Money(this.amount * rate, currency)
	}
}