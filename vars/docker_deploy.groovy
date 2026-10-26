def call() {
    echo 'Deploying application'
    sh 'docker compose up -d --build'
}
