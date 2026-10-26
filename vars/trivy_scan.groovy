def call(){
  echo 'Scanning files for vulnerabilities...'
  sh "trivy fs . --output results.json"
}
