String branchName = "master"
String gitCredentials = "4d1ad663-0174-4f9d-b7a9-6d8695e734f0"
String repoUrl = "https://github.com/nembotmarius/financews.git"

pipeline {
    agent any
    stages {
        stage('clone') {
            steps {
                echo 'Make the output directory'
                sh 'mkdir -p build'

                echo 'Cloning files from (branch: "' + branchName + '" )'
                dir('build') {
                    git branch: branchName, credentialsId: 	gitCredentials, url: repoUrl
                }
            }
        }
        stage('Build') {
            steps {
                dir('build/financewseurekadiscovery') {
                    sh 'mvn -B -DskipTests clean package'
                }
            }
        }
        stage('Test') {
            steps {
                dir('build/financewseurekadiscovery') {
                    sh 'mvn test'
                }
            }
            post {
                always {
                    dir('build/financewseurekadiscovery') {
                        junit 'target/surefire-reports/*.xml'
                    }
                }
            }
        }
    }
}