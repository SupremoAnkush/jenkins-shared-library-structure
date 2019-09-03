@Library('jenkins-library@master') _
 
pipeline {
    agent any
    stages {
        stage('Git Checkout') {
            steps {
            gitCheckout(
                branch: "master",
                userRemoteConfigs: [[credentialsId: 'AnkushGithub',
                url: 'https://github.com/SupremoAnkush/jenkins-shared-library-structur']]])
            )
            }
    }
    }
}