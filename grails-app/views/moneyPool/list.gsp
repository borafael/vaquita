<div align="center"><h1>Vaquitas</h1></div>
<hr/>

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
