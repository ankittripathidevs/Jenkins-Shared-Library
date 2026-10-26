def call(String imageName, String imageTag = 'latest') {
    echo "Building Docker Image: ${imageName}:${imageTag}"
    sh "docker build -t ${imageName}:${imageTag} ."
}
