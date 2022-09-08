pipeline {
    agent any
    stages {
        stage("Build Maven") {
            steps {
                powershell 'mvn -B clean package'
            }
        }
        stage("Run Gatling") {
            steps {
                powershell 'mvn gatling:test'
            }
            post {
                always {
                    gatlingArchive()
                }
            }
        }
    }
}

