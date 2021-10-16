String branchName = "dev"
String gitCredentials = "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"
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
        echo 'Build and test financewsgatewayservice '
        dir('build/financewsgatewayservice') {
            sh "mvn clean verify"
        }
        echo 'Build and test financewssecurityservice'
        dir('build/financewssecurityservice') {
            sh "mvn clean verify"
        }
        echo 'Build and test financewsclientservice'
        dir('build/financewsclientservice') {
            sh "mvn clean verify"
        }
        echo 'Build and test financewsfrontofficeservice'
        dir('build/financewsfrontofficeservice') {
            sh "mvn clean verify"
        }
    }
    stage ('Build docker image and launch container') {
        echo 'start docker compose'
        dir('build') {
            sh "docker container stop \$(docker container ls -q --filter name=prodfinancews*) || true"
            sh "docker rm \$(docker ps -a -q) || true"
            sh "docker image rmi \$(docker images | grep latest | tr -s ' ' | cut -d ' ' -f 3) || true"
            sh "docker-compose up -d"
        }
    }
}
