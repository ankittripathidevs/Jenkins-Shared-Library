def call(String imageName, String dockerHubRepo, String imageTag = 'latest') {
    withCredentials([
        usernamePassword(
            credentialsId: 'DockerHub_Credentials',
            usernameVariable: 'DockerHub_USER',
            passwordVariable: 'DockerHub_PASS'
        )
    ]) {
        try {
            echo 'Logging in to Docker Hub'

            sh '''
                set +x
                echo "$DockerHub_PASS" | docker login \
                    -u "$DockerHub_USER" \
                    --password-stdin
            '''

            echo 'Tagging Docker image'

            sh """
                docker image tag \
                    '${imageName}:${imageTag}' \
                    "\$DockerHub_USER/${dockerHubRepo}:${imageTag}"
            """

            echo 'Pushing Docker image'

            sh """
                docker push \
                    "\$DockerHub_USER/${dockerHubRepo}:${imageTag}"
            """
        } finally {
            sh 'docker logout || true'
        }
    }
}
