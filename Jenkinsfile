String branchName = "master"
String gitCredentials = "ba607c6d-dbb9-4e83-85f4-695a0defc7db"
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