<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to the Curricula Manager</title>
</head>
<body>
    <content tag="nav">
      <!--<sec:ifLoggedIn>
      <form name="logout" method="POST" action="${createLink(controller:'logout') }">
        <input type="submit" value="Logout">
      </form>
    </sec:ifLoggedIn>
    <sec:ifNotLoggedIn>
      <form name="login" action="${createLink(controller:'login') }">
        <input type="submit" value="Login">
      </form>
    </sec:ifNotLoggedIn>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><g:message code="languages" default="Languages"/> <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <navBar:localeDropdownListItems uri="${request.forwardURI}"/>
        </ul>
      </li>-->
    </content>

    <div id="content" role="main">
        <section class="row colset-2-its">
            <h1><g:message code="welcome.title" /></h1>

            <sec:ifNotLoggedIn>
              <!--<g:link controller='login' action='auth'>Login</g:link>-->
              <i><g:message code="welcome.notloggedin.label" /></i>
            </sec:ifNotLoggedIn>

            <sec:ifLoggedIn>
            <div id="controllers" role="navigation">
                <h2><g:message code="welcome.available.controllers.label" /></h2>
                <p><g:message code="welcome.body" /></p>
                <ul>
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.name } }">
                        <li class="controller">
                            <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
                        </li>
                    </g:each>
                </ul>
            </div>
            </sec:ifLoggedIn>
        </section>
    </div>

</body>
</html>
