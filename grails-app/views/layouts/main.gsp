<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>
<body>
    <div class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/#">
		                <asset:image src="grails.svg" alt="Grails Logo"/>
                </a>
            </div>
            <div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                      <g:pageProperty name="page.nav" />
                      <sec:ifLoggedIn>
                        <form name="logout" method="POST" action="${createLink(controller:'logout') }">
                          <input type="submit" value="Logout">
                        </form>
                      </sec:ifLoggedIn>
                      <sec:ifNotLoggedIn>
                      <form name="login" action="${createLink(controller:'login') }">
                        <input type="submit" value="Login">
                      </form>
                      </sec:ifNotLoggedIn>
                    </li>
                    <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><g:message code="navbar.languages" default="Languages"/> <span class="caret"></span></a>
                      <ul class="dropdown-menu">
                          <navBar:localeDropdownListItems uri="${request.forwardURI}"/>
                      </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>

  <g:layoutBody/>

  <div class="footer" role="contentinfo"></div>

  <div id="spinner" class="spinner" style="display:none;">
      <g:message code="spinner.alt" default="Loading&hellip;"/>
  </div>

  <asset:javascript src="application.js"/>

</body>
</html>
