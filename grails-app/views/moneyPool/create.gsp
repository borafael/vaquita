<%@ page import="vaquita.MoneyPoolType" %>
<%@ page import="vaquita.Currency" %>

<g:form action="save">
    <g:textField name="name"/>
    <g:textField name="description"/>
    <g:textField name="url"/>

    <g:select name="amount.currency" from="${Currency.values()}"/>
    <g:textField name="amount.amount"/>

    <g:select name="type" from="${MoneyPoolType.values()}"/>

    <input type="submit"/>
</g:form>
