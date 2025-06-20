pipeline {
    agent any
    tools { 
        git 'Git'  // Replace 'Default Git' with the name configured in Jenkins,
        maven 'Maven'  // Name should match the one set in Global Tool Configuration
    }
    environment {
        PATH = "C:\\Program Files\\apache-maven-3.9.9\\bin;${env.PATH}"
    }
    stages {
        stage('Clone Repository') {
             steps {
                script {
                    checkout([$class: 'GitSCM', 
                        branches: [[name: '*/main']], 
                        userRemoteConfigs: [[
                            url: 'https://github.com/montriv/cross-browser-testing.git',
                            credentialsId: '0066fdc5-5b68-4204-94b5-1a7f8538396a'
                        ]]
                    ])
                }
            }
        }
        stage('Install Dependencies') {
            steps {
               bat 'mvn clean test'
           //  bat '"C:\\Program Files\\apache-maven-3.9.9\\bin\\mvn" clean test'
            }
        }

        stage('Run Tests on Chrome') {
            steps {
                bat 'mvn clean test -DsuiteXmlFile=testng.xml -Dbrowser=chrome'
              //bat '"C:\\Program Files\\apache-maven-3.9.9\\bin\\mvn" clean test -DsuiteXmlFile=testng.xml -Dbrowser=chrome'
            }
        }

        stage('Run Tests on Firefox') {
            steps {
                bat 'mvn clean test -DsuiteXmlFile=testng.xml -Dbrowser=firefox'
            // bat '"C:\\Program Files\\apache-maven-3.9.9\\bin\\mvn" clean test  -DsuiteXmlFile=testng.xml -Dbrowser=firefox'
           		echo "Success!"
            }
        }
        
        stage('Run Tests on Edge') {
            steps {
               // bat 'mvn clean test -DsuiteXmlFile=testng.xml -Dbrowser=edge'
            }
        }

        stage('Generate Reports') {
            steps {
                archiveArtifacts artifacts: '**/target/*.html', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
            emailext body: "Build completed",
                     subject: "Jenkins Build",
                     to: "monish.itoperations@gmail.com"
        }
    }
}
