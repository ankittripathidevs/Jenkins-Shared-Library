def call(String imageName) {
    echo 'Building Docker Image'
    sh "docker build -t ${imageName} ."
}
