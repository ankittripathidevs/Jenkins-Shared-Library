def call(){
  sh "trivy fs . --output results.json"
}
