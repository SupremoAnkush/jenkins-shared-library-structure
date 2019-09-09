#!/isr/bin/env groovy

@Library('jenkins-library@master') _
 
pipeline {
    agent any
    stages {
       stage('checkout') {
            steps {
                 gitCheckout()
            }
        }
       stage('repoList') {
            steps {
                 fetchRepoList()
            }
        }
    }
}
