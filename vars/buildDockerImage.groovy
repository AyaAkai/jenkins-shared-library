def call() {
    echo "Building Docker image"
    def imageName = "ayaahmed123/jenkins-library"
    sh "docker build -t ${imageName}:v${env.BUILD_NUMBER} ."
}
