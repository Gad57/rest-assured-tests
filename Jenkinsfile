pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Gad57/rest-assured-tests.git'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }
}