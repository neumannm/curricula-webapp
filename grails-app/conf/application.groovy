

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'de.th_koeln.iim.curricula.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'de.th_koeln.iim.curricula.UserRole'
grails.plugin.springsecurity.authority.className = 'de.th_koeln.iim.curricula.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/*',              access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['ROLE_ADMIN']],
	[pattern: '/assets/**',      access: ['IS_AUTHENTICATED_ANONYMOUSLY']],
	[pattern: '/**/js/**',       access: ['IS_AUTHENTICATED_ANONYMOUSLY']],
	[pattern: '/**/css/**',      access: ['IS_AUTHENTICATED_ANONYMOUSLY']],
	[pattern: '/**/images/**',   access: ['IS_AUTHENTICATED_ANONYMOUSLY']],
	[pattern: '/**/favicon.ico', access: ['IS_AUTHENTICATED_ANONYMOUSLY']],
	[pattern: '/aclClass/**',       access: ['ROLE_ADMIN']],
	[pattern: '/aclEntry/**',       access: ['ROLE_ADMIN']],
	[pattern: '/aclObjectIdentity/**',       access: ['ROLE_ADMIN']],
	[pattern: '/aclSid/**',         access: ['ROLE_ADMIN']],
	[pattern: '/register/**',       access: ['permitAll']],
	[pattern: '/registrationCode/**',       access: ['ROLE_ADMIN']],
	[pattern: '/requestmap/**',     access: ['ROLE_ADMIN']],
	[pattern: '/role/**',           access: ['ROLE_ADMIN']],
	[pattern: '/user/**',           access: ['ROLE_ADMIN']],
	[pattern: '/securityInfo/**',   access: ['ROLE_ADMIN']],
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

//some possible values:
//ROLE_USER, ROLE_ADMIN, IS_AUTHENTICATED_FULLY, IS_AUTHENTICATED_ANONYMOUSLY

grails.plugin.springsecurity.password.algorithm='SHA-512'      //pw encryption algorithm
grails.plugin.springsecurity.portMapper.httpPort = "8181"      //port map for http
grails.plugin.springsecurity.portMapper.httpsPort = "8443"     //port map for https
grails.plugin.springsecurity.rejectIfNoRule = true             //force authentication if no rule exists

grails.gsp.enable.reload = true
grails.gsp.view.dir = "/var/www/grails/curricula/"
