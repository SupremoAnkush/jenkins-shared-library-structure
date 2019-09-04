#!/isr/bin/env groovy

@Library('jenkins-library@master') _
 
pipeline {
    agent any
    stages {
       stage('build') {
            steps {
                 HelloWorld()
            }
        }
    }
}
