String branchName = "master"
String gitCredentials = "4d1ad663-0174-4f9d-b7a9-6d8695e734f0"
String repoUrl = "https://github.com/nembotmarius/financews.git"

node {
  // Start Stages
    stage('Clone') {
        // Clones the repository from the current branch name
        echo 'Make the output directory'
        sh 'mkdir -p build'

        echo 'Cloning files from (branch: "' + branchName + '" )'
        dir('build') {
            git branch: branchName, credentialsId: 	gitCredentials, url: repoUrl
        }
    }
    stage ('Build Eureka Services') {
        dir('build/financewseurekadiscovery') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
    }
}