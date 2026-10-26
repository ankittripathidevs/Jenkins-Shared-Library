def call() {
    emailext(
        to: 'ankittripathi2k24@gmail.com',
        subject: "${currentBuild.currentResult}: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
        body: """
            Build Status: ${currentBuild.currentResult}
            Job: ${env.JOB_NAME}
            Build Number: ${env.BUILD_NUMBER}
            Build URL: ${env.BUILD_URL}
        """,
        attachmentsPattern: 'results.json'
    )
}
