def buildDockerImage() {
    echo "Building Docker image"
    def imageName = "ayaahmed123/jenkins-sample"
    sh "docker build -t ${imageName}:v${env.BUILD_NUMBER} ."
}

def pushDockerImage() {
    echo "Pushing Docker image to DockerHub"
    def imageName = "ayaahmed123/jenkins-sample"
    withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
        sh "echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin"
        sh "docker push ${imageName}:v${env.BUILD_NUMBER}"
    }
}

def buildAndPushDockerImage() {
    pipeline {
        agent any

        environment {
            XYZ = 'ITI ITI ITI'
        }

        stages {
            stage('Build Docker Image') {
                steps {
                    script {
                        buildDockerImage()
                    }
                }
            }
            stage('Push Docker Image') {
                steps {
                    script {
                        pushDockerImage()
                    }
                }
            }
        }
    }
}
