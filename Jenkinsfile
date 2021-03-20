String branchName = env.BRANCH_NAME
String gitCredentials = "ba3620ef2e1b6a1746252c383c745c1b6bbfa16e"
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