grails.project.work.dir = 'target'

grails.project.dependency.resolver = "maven"
grails.project.dependency.resolution = {

    inherits "global"
    log "warn"

    repositories {
        grailsCentral()
        mavenRepo "http://repo.grails.org/grails/core"
    }

    dependencies {

        String datastoreVersion = '2.0.0.M3'

        compile "org.grails:grails-datastore-gorm-hibernate:$datastoreVersion"

        runtime 'cglib:cglib:2.2.2'

        test 'org.spockframework:spock-grails-support:0.7-groovy-2.0', {
            export = false
        }
    }

    plugins {
        build(':release:3.0.0', ':rest-client-builder:1.0.3') {
            export = false
        }

        test ':spock:0.7', {
            exclude 'spock-grails-support'
            export = false
        }

        test ':scaffolding:1.0.0', {
            export = false
        }
    }
}
