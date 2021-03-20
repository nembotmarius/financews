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
        dir('build/financewseurekadiscovery') {
            sh "mvn clean verify"
        }
    }
}