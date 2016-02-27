<!doctype html>
<html lang="en" class="no-js">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <asset:stylesheet src="application.css"/>
        <asset:javascript src="application.js"/>
        <asset:stylesheet src="table.css"/>

        <title><g:layoutTitle default="Vaquita"/></title>

        <g:layoutHead/>
    </head>
    <body>
        <div class="menu">
            <g:if test="${session.user}">
                <g:link controller='moneyPool' action='list'>Vaquitas</g:link>
                ${session.user.mail}
                <g:link controller='security' action='logOut'>logOut</g:link>
            </g:if>
        </div>
        <div class="body"><g:layoutBody/></div>
    </body>
</html>
