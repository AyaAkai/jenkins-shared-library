def call() {
    echo "Building Docker image"
    def imageName = "ayaahmed123/jenkins-sample"
    sh "docker build -t ${imageName}:v${env.BUILD_NUMBER} ."
}
