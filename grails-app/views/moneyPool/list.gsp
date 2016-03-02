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
                  <g:link  controller= "MoneyPool" action = "accept" id = "${invitation.id}" > Aceptar </g:link>
                  </td>
                <td>
                    <g:link  controller= "MoneyPool" action = "reject" id = "${invitation.id}" > Cancelar </g:link>
                </td>
            </tr>
        </g:each>
        </table>
    </body>
</html>
