package vaquita

enum Currency {
	ARS,
	USD,
	EUR
}

class Money {
	float amount
	Currency currency

	def divide(int divider) {
		return new Money(amount: (float)(amount / divider), currency: this.currency)
	}

	def changeAmount(float amount) {
		return new Money(amount: amount, currency: this.currency)
	}

	def changeCurrency(Currency currency) {
		return changeCurrency(currency, 1)
	}

	def changeCurrency(Currency currency, float rate) {
		return new Money(amount: this.amount * rate, currency: currency)
	}
}
