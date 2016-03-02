<!doctype html>
<html>
    <head>
        <title>Vaquita</title>
        <asset:stylesheet src="table.css"/>
        <asset:stylesheet src="application.css"/>
        <asset:stylesheet src="table.css"/>
        <asset:javascript src="application.js"/>
    </head>
    <body>
        <div class="table">
            <div id="vaquitaLogo" role="banner"><center><asset:image src="vaquitatrasns.png" alt="Grails"/></center></div>

        <g:form controller="security" action="logIn" command= "loginCommand">
    <center>
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
                <g:actionSubmit action= "logIn"  value="Login"/>
            </div>
              </center>
        </g:form>
        </div>
    </body>
</html>
