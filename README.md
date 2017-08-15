# jenkins-certificate

### This is the offcial docker image downloaded with (will install the latest)
docker pull jenkins:2.19.4

### The next directory will be dedicated to keep the jenkins home volume
new_jenkins_volume

### Port 50000 is only needed in case you need JNLP

### This will create the docker container for the jenkins master only
```
docker run -d -p 8080:8080  -p 50000:50000 -v /home/mishkin/Docker/new_jenkins/new_jenkins_volume:/var/jenkins_home jenkins
```
### And with memory limit and root user
```
docker run -u root -d -p 8080:8080  -p 50000:50000 -m=2147483648 -v /home/mishkin/Docker/new_jenkins/new_jenkins_volume:/var/jenkins_home --name my_new_jenkins jenkins 
```
### To run it with docker-compose and in daemon mode 
```
COMPOSE_HTTP_TIMEOUT=200 docker-compose up -d --build
```
### That image is for the jenkins certified 2017 read the next link for furhter info
https://www.cloudbees.com/sites/default/files/cje-study-guide-2017.pdf

### 3 slaves based on ubuntu 16.04 LTS will be created with ssh enabled and jenkins:jenkins creds

## How to build up
```
COMPOSE_HTTP_TIMEOUT=200 docker-compose up -d --build
```


