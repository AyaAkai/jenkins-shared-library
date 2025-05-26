def call(String imageName) {
    withCredentials([string(credentialsId: 'dockerhub-cred', variable: 'dockerhub-cred')]) {
        sh "echo \$DOCKER_PASSWORD | docker login -u ayaahmed123 --password-stdin"
        sh "docker push ${imageName}"
    }
}

