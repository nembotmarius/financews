String branchName = "master"
String gitCredentials = "2f57ac1f31adcba0bb965eafca6d308bbb261f55"
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
}