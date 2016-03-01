<!doctype html>
<html>
    <head>
        <meta name="layout" content="main"/>
    </head>
    <body>
        <br></br>
        <div align="center"><h1>Vaquitas</h1></div>
        <hr/>

        <table align="center">
        <g:form  controller="MoneyPool" action="create">
          <div align="center">
              <input type="submit" value="Crear"/>
          </div>
        </g:form>
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

    <g:each in="${invitations}" var="invitation">

            <tr>
                <td>
                    ${invitation.moneyPool.name}
                </td>
                <td>
                    aceptar
                  </td>
                <td>
                    cancelar
                </td>
            </tr>
        </g:each>
        </table>
    </body>
</html>
