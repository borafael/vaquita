<%@ page import="vaquita.MoneyPoolType" %>
<%@ page import="vaquita.Currency" %>

<html>
	<head>
        <meta name="layout" content="main"/>
	</head>
	<body>
        <div class="table">
            <div class="row">
                <span class="cell-label">
                    Nombre:
                </span>
                <span class="cell-text">
                    ${moneyPool.name}
                </span>
            </div>

            <div class="row">
                <span class="cell-label">
                    Descripci&oacute;n:
                </span>
                <span class="cell-text">
                    ${moneyPool.description}
                </span>
            </div>

            <div class="row">
                <span class="cell-label">
                    URL:
                </span>
                <span class="cell-text">
                    ${moneyPool.url}
                </span>
            </div>

            <div class="row">
                <span class="cell-label">
                    Monto:
                </span>
                <span class="cell-text">
                    ${moneyPool.amount.currency} ${moneyPool.amount.amount}
                </span>
            </div>

            <div class="row">
                <span class="cell-label">
                    Tipo:
                </span>
                <span class="cell-text">
                    ${moneyPool.type}
                </span>
            </div>
        </div>
    </body>
</html>
