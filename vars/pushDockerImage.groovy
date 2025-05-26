def call(String imageName) {
    echo "Pushing Docker image to DockerHub"
    withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
        sh "echo \$DOCKER_PASSWORD | docker login -u \$DOCKER_USERNAME --password-stdin"
        sh "docker push ${imageName}:v${env.BUILD_NUMBER}"
    }
}
