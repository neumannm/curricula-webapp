<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to the Curricula Manager</title>
</head>
<body>
  <div id="content" role="main">
      <section class="row colset-2-its">
          <h1><g:message code="welcome.title" /></h1>

          <sec:ifNotLoggedIn>
            <!--<g:link controller='login' action='auth'>Login</g:link>-->
            <i><g:message code="welcome.notloggedin.label" /></i>
          </sec:ifNotLoggedIn>

          <sec:ifLoggedIn>
            <g:message code="welcome.loggedin.label" /> !
              <sec:ifAnyGranted roles="ROLE_ADMIN">
                <ul>
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.name } }">
                      <li class="controller">
                          <g:link controller="${c.logicalPropertyName}">${c.shortName}</g:link>
                      </li>
                    </g:each>
                </ul>
              </sec:ifAnyGranted>
              <sec:ifAnyGranted roles="ROLE_USER">
              <ul>
                  <li class="controller">
                    <g:link controller="country"><g:message code="country.label" /></g:link>
                  </li>
                  <li class="controller">
                    <g:link controller="city"><g:message code="city.label" /></g:link>
                  </li>
                  <li class="controller">
                    <g:link controller="university"><g:message code="university.label" /></g:link>
                  </li>
                  <li class="controller">
                    <g:link controller="studyProgramme"><g:message code="studyProgramme.label" /></g:link>
                  </li>
                  <li class="controller">
                    <g:link controller="curriculum"><g:message code="curriculum.label" /></g:link>
                  </li>
                  <li class="controller">
                    <g:link controller="module"><g:message code="module.label" /></g:link>
                  </li>
                </ul>
              </sec:ifAnyGranted>
          </sec:ifLoggedIn>
      </section>
  </div>
</body>
</html>
