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
  </sec:ifNotLoggedIn>-->
    </content>

    <div id="content" role="main">
        <section class="row colset-2-its">
            <h1>Curricula Manager</h1>

            <sec:ifNotLoggedIn>
              <!--<g:link controller='login' action='auth'>Login</g:link>-->
              <i><g:message code="general.notloggedin.label" /></i>
            </sec:ifNotLoggedIn>

            <sec:ifLoggedIn>
            <div id="controllers" role="navigation">
                <h2><g:message code="available.controllers.label" /></h2>
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
