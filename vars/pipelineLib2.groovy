def call() {
    pipeline {
        agent any

        environment {
            XYZ = 'ITI ITI ITI'
            IMAGE_NAME = 'ayaahmed123/jenkins-library'
        }

        stages {
            stage('Build Docker Image') {
                steps {
                    echo 'Building Docker image'
                    buildDockerImage(env.IMAGE_NAME)
                }
            }

            stage('Push Docker Image') {
                steps {
                    echo 'Pushing Docker image to DockerHub'
                    pushDockerImage(env.IMAGE_NAME)
                }
            }
        }
    }
}
