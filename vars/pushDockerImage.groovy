def call(String imageName) {
    withCredentials([string(credentialsId: 'DOCKER_PASSWORD', variable: 'DOCKER_PASSWORD')]) {
        sh "echo \$DOCKER_PASSWORD | docker login -u ayaahmed123 --password-stdin"
        sh "docker push ${imageName}"
    }
}

