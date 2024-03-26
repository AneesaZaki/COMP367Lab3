pipeline {
    agent any

    environment {
        DOCKER_USERNAME = credentials('aneezaki')
        DOCKER_PASSWORD = 'Computer297!'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/AneesaZaki/COMP367Lab3.git'
                echo "GitHub Repository URL: https://github.com/AneesaZaki/COMP367Lab3.git"
            }
        }
        stage('Maven Build') {
            steps {
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
        stage('Docker Login') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'aneezaki', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh "docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD"
                }
            }
        }
        stage('Docker Build & Push') {
            steps {
                script {
                    // Build Docker image
                    sh "docker build -t maven-webapp ."
                }
            }
        }
        stage('Docker Push') {
            steps {
                sh "docker push maven-webapp"
            }
        }
    }
}
