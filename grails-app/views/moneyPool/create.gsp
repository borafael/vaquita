<%@ page import="vaquita.MoneyPoolType" %>
<%@ page import="vaquita.Currency" %>

<html>
	<head>
        <meta name="layout" content="main"/>
	</head>
	<body>
        <div class="table">
        <g:form action="save">

            <div class="row">
                <span class="cell-label">
                    Nombre:
                </span>
                <span class="cell-text">
                    <g:textField name="name"/>
                </span>
            </div>

			<div class="row">
                <span class="cell-label">
                    Tipo:
                </span>
                <span class="cell-text">
                    <g:select name="type" from="${MoneyPoolType.values()}"/>
                </span>
            </div>

            <div class="row">
                <span class="cell-label">
                    Descripci&oacute;n:
                </span>
                <span class="cell-text">
                    <g:textField name="description"/>
                </span>
            </div>

            <div class="row">
                <span class="cell-label">
                    URL:
                </span>
                <span class="cell-text">
                    <g:textField name="url"/>
                </span>
            </div>

			<div class="row">
                <span class="cell-label">
                    Monto:
                </span>
                <span class="cell-text">
                    <g:select name="amount.currency" from="${Currency.values()}"/>
                    <g:textField name="amount.amount"/>
                </span>
            </div>

			<div class="row">
                <span class="cell-label">
                    Participantes:
                </span>
                <span class="cell-text">
                    <g:textArea name="mails"/>
                </span>
            </div>


            <div align="center">
                <input type="submit" value="Crear Vaquita"/>
            </div>
        </g:form>
        </div>
    </body>
</html>
