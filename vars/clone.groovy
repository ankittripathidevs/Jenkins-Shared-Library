def call(String url, String branch) {
    echo 'Cloning Code...'
    git branch: branch, 
        url: url
}
