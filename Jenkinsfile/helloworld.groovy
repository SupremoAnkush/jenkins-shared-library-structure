#!/usr/bin/env groovy

@Library('jenkins-shared-library-structure@master') _
 
pipeline {
    agent any
    stages {
       /*stage('checkout') {
            steps {
                 gitCheckout()
            }
        }*/
       stage('repoList') {
            steps {
                 fetchRepoList()
            }
        }
    }
}
