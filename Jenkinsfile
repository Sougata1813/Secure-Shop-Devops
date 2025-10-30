pipeline{

    agent any

    stages{

        stage('git checkout'){

            steps{

                git branch: 'main', url: 'https://github.com/Sougata1813/Secure-Shop-Devops.git'

            }
        }
        stage('unit testing'){

            steps{

                sh 'mvn clean package'
            }
        }       
    }
}