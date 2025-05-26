def call() {
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
    evaluate(script)
}