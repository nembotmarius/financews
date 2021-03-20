pipeline {
    agent any
    stages {
        stage ('Build') {
            steps {
                sh 'cd financewseurekadiscovery'
                sh 'mvn -Dmaven.test.failure.ignore=true install'
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
    }
}
