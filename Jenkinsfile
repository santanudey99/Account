pipeline {
    agent none          //{ label "docker" }    //Run everything on an agent with the docker daemon
    stages {
        stage('maven_package') {
            agent {
                docker {
                    name 'maven'
                    image 'maven:3.3.9-jdk-8-alpine'
                }
            }            
            steps {
                sh 'mvn clean package'
            }
        }
        stage('docker_build') {
            steps {
                sh """
                   docker login -u ${DOCKER_HUB_USER} -p ${DOCKER_HUB_PASSWORD}
                   docker build -t namespace/my-image:${gitCommit} .
                   docker push namespace/my-image:${gitCommit}
                   """
            }
        }
        stage('deploy_DEV') {
            agent {
                docker { image 'node:7-alpine' }
            }
            steps {
                sh """
                   kubectl apply -f /home/ec2-user/deployments/accountserv_depl_service_dev.yaml 
                   kubectl get pod --namespace=lkq-dev
                   kubectl get svc --namespace=lkq-dev'
                   """
            }
        }
    }
}
