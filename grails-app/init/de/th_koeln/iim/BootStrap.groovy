package de.th_koeln.iim

import de.th_koeln.iim.curricula.*

class BootStrap {

    def init = { servletContext ->

      def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save(failOnError: true)
      def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)

      //add an admin and default user
    def adminUser = User.findByUsername('admin') ?: new User(
            username: 'admin',
            password: '4dm1n.pw',
            enabled: true).save(failOnError: true)

    if (!adminUser.authorities.contains(adminRole)) {
        UserRole.create adminUser, adminRole
    }

    }
    def destroy = {
    }
}
