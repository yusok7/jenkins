pipeline {
    agent any
    options {
        timeout(time: 1, unit: 'HOURS')
    }

    environment {
        SOURCECODE_JENKINS_CREDENTIAL_ID = 'jenkins-github-wh'
        SOURCE_CODE_URL = 'https://github.com/yusok7/jenkins.git'
        RELEASE_BRANCH = 'master'
    }

    stages {
        stage('Init') {
            steps {
                echo 'clear'
                // sh 'docker rm -f server1'
                deleteDir()
            }
        }

        stage('clone') {
            steps {
                git url: "$SOURCE_CODE_URL",
                    branch: "$RELEASE_BRANCH",
                    credentialsId: "$SOURCECODE_JENKINS_CREDENTIAL_ID"
                sh "ls -al"
            }
        }

        stage('dockerizing') {
            steps {
                sh "pwd"
                sh "chmod +x ./gradlew"
                sh "./gradlew build --stacktrace"

                sh "docker build -t foodeats ."
            }
        }

        stage('deploy') {
            steps {
                sh "pwd"
                sh "docker-compose up --build -d"
            }
        }

        stage('deploy2') {
             steps {
                // sh 'docker rm -f spring-boot-ci-cd_docker-demo2_1'
                sh "pwd"
                sh "ls -al"
                dir ('./compose') {
                    sh "pwd"
                    sh "ls -al"
                    // sh 'docker rm -f server2'
                    sh "docker-compose up --build -d"
                }
                echo 'dir close'
                sh "pwd"
             }
        }
    }
}