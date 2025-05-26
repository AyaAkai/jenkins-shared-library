def call() {
    echo "Pushing Docker image to DockerHub"
    def imageName = "ayaahmed123/jenkins-sample"
    withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
        sh "echo \$DOCKER_PASSWORD | docker login -u \$DOCKER_USERNAME --password-stdin"
        sh "docker push ${imageName}:v${env.BUILD_NUMBER}"
    }
}