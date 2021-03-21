String branchName = "dev"
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
    stage ('Build and test web services') {
        // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe reports and FindBugs reports
        echo 'Build and test financewseurekadiscovery'
        dir('build/financewseurekadiscovery') {
            sh "mvn clean verify"
        }
        echo 'Build and test financewsgatewayservice'
        dir('build/financewsgatewayservice') {
            sh "mvn clean verify"
        }
        echo 'Build and test financewssecurityservice'
        dir('build/financewssecurityservice') {
            sh "mvn clean verify"
        }
        echo 'Build and test financewsclientservice'
        dir('build/financewsclientservice ') {
            sh "mvn clean verify"
        }
    }
}