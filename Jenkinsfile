pipeline {
    agent any

    stages {
        stage ('verify stage') {
            steps {
                withMaven(maven : 'Maven'){
                bat 'mvn clean verify'
                }
            }
        }
        stage ('SonarQube') {
            steps {
                withMaven(maven : 'Maven'){
                bat 'mvn sonar:sonar'
                }
            }
        }
        stage ('packaging') {
            steps {
                withMaven(maven : 'Maven'){
                bat 'mvn package'
                }
            }
        }
    }
}
