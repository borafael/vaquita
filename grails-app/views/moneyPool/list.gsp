<!doctype html>
<html>
    <head>
        <meta name="layout" content="main"/>
    </head>
    <body>
        <div align="center">
            <h1>Vaquitas</h1>

            <table align="center">
                <g:each in="${moneyPools}" var="moneyPool">
                <tr>
                    <td>
                        <a href="/moneyPool/edit/${moneyPool.id}">${moneyPool.name}<a/><br/>
                    </td>
                    <td>
                        ${moneyPool.amount.amount} ${moneyPool.amount.currency}
                    </td>
                    <td>
                        ${moneyPool.type}
                    </td>
                </tr>
                </g:each>
            </table>

            <table align="center">
                <g:each in="${invitations}" var="invitation">

                <tr>
                    <td>
                        ${invitation.moneyPool.name}
                    </td>
                    <td>
                      <g:link  controller= "MoneyPool" action = "accept" id = "${invitation.id}" > Aceptar </g:link>
                      </td>
                    <td>
                        <g:link  controller= "MoneyPool" action = "reject" id = "${invitation.id}" > Rechazar </g:link>
                    </td>
                </tr>
                </g:each>
            </table>
            <hr/>
            <g:link controller="MoneyPool" action="create">Crear</g:link>
        </div>
    </body>
</html>
