<!doctype html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Vaquita</title>
    </head>
    <body>
        <div class="table">
        <g:form controller="security" action="logIn">

            <div class="row">
                <span class="cell-label">
                    Mail:
                </span>
                <span class="cell-text">
                    <g:textField name="mail"/>
                </span>
            </div>

            <div class="row">
                <span class="cell-label">
                    Pass:
                </span>
                <span class="cell-text">
                    <g:passwordField name="pass"/>
                </span>
            </div>

            <div align="center">
                <input type="submit" value="Login"/>
            </div>
        </g:form>
        </div>
    </body>
</html>
