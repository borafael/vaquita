<!doctype html>
<html lang="en" class="no-js">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title><g:layoutTitle default="Grails"/></title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <asset:stylesheet src="application.css"/>
        <asset:stylesheet src="table.css"/>
        <asset:javascript src="application.js"/>

        <g:layoutHead/>
    </head>
    <body>
        <div id="vaquitaLogo" role="banner"><center><asset:image src="vaquitatrasns.png" alt="Grails"/></center></div>

        <center>
            <g:link controller="message" action="list">Inicio</g:link>
            |
            <g:link controller="moneyPool" action="list">Vaquitas</g:link>
            |
            ${session.user.mail} <g:link controller="security" action="logOut">(salir)</g:link>
        </center>
        <hr/>
        <g:layoutBody/>
        <div class="footer" role="contentinfo"></div>
        <div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
    </body>
</html>
