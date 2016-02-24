<!doctype html>
<html>
    <head>
        <meta name="layout" content="main"/>
    </head>
    <body>
        <div align="center"><h1>Vaquitas</h1></div>
        <hr/>

        <table align="center">
        <g:each in="${moneyPools}" var="moneyPool">
<<<<<<< HEAD

=======
>>>>>>> 6528cc23917402c50a0d23527a2515b1ac0471c6
            <tr>
                <td>
                    <a href="/moneyPool/edit/${moneyPool.id}">${moneyPool.name}<a/><br/>
                </td>
                <td>
<<<<<<< HEAD
                  <li>  ${moneyPool.amount.amount} ${moneyPool.amount.currency}</li>
                  
=======
                    ${moneyPool.amount.amount} ${moneyPool.amount.currency}
>>>>>>> 6528cc23917402c50a0d23527a2515b1ac0471c6
                </td>
                <td>
                    ${moneyPool.type}
                </td>
            </tr>
        </g:each>
        </table>
    </body>
</html>
