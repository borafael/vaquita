<%@ page import="vaquita.MoneyPoolType" %>
<%@ page import="vaquita.Currency" %>

<html>
	<head>
        <meta name="layout" content="main"/>
	</head>
	<body>
        <div class="table">
        <g:form action="update">

            <g:hiddenField name="id" value="${moneyPool.id}"/>

            <div class="row">
                <span class="cell-label">
                    Nombre:
                </span>
                <span class="cell-text">
                    <g:textField name="name" value="${moneyPool.name}"/>
                </span>
            </div>

            <div class="row">
                <span class="cell-label">
                    Descripci&oacute;n:
                </span>
                <span class="cell-text">
                    <g:textField name="description" value="${moneyPool.description}"/>
                </span>
            </div>

            <div class="row">
                <span class="cell-label">
                    URL:
                </span>
                <span class="cell-text">
                    <g:textField name="url" value="${moneyPool.url}"/>
                </span>
            </div>

            <div class="row">
                <span class="cell-label">
                    Monto:
                </span>
                <span class="cell-text">
                    <g:select name="amount.currency" from="${Currency.values()}" value="${moneyPool.amount.currency}"/>
                    <g:textField name="amount.amount" value="${moneyPool.amount.amount}"/>
                </span>
            </div>

            <div class="row">
                <span class="cell-label">
                    Tipo:
                </span>
                <span class="cell-text">
                    <g:select name="type" from="${MoneyPoolType.values()}" value="${moneyPool.type}"/>
                </span>
            </div>

            <div align="center">
                <input type="submit" value="Guardar"/>
            </div>
        </g:form>
        </div>
    </body>
</html>
