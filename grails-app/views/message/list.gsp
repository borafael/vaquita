<!doctype html>
<html>
    <head>
        <meta name="layout" content="main"/>
    </head>
    <body>
        <div align="center">
            <g:if test="${!messages}">
            No tiene mensajes...
            </g:if>
            <g:else>
            <g:each in="${messages}" var="message">
            ${message.text}<br/>
            </g:each>
            </g:else>
        </div>
    </body>
</html>
