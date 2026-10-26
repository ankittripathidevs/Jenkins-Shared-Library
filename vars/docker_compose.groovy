def call() {
    echo 'Deploying Application'
    sh 'docker-compose down && docker-compose up -d --build'
}
