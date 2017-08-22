# docker-infra-jenkins-cert2017

### Description

This repo just contains very basic infra docker based to have a minimal lab for jenkins 2017 certificate preparation (that means jenkins LTS 2.19.4).

It will spin up in total 4 docker containers and create an internal network (bridge based to be run on a single docker host)

* Jenkins master 2.19.4 LTS
* slave1 Ubuntu 16.04 LTS 
* slave2 Ubuntu 16.04 LTS
* slave3 Ubuntu 16.04 LTS

To gather the requirements for the certification by Cloudbees please read the next link:
```
https://www.cloudbees.com/sites/default/files/cje-study-guide-2017.pdf
```
And of course refeer to the oficial documentation of Jenkins Docker here:
```
https://github.com/jenkinsci/docker/blob/master/README.md

```
### Requirements

* Docker version 1.12.6 or above
* docker-compose version 1.9.0 or above
* create a directory to host the jenkins master volume, call it jenkins_master_volume/ or edit docker-compose.yml file

Please notice that exposure of port 50000 is only needed in case you need JNLP, in case you want to add a windows node as slave via JNLP.

### How to build and run the containers

Run it with docker-compose and in daemon mode forcing build at least the very first time
```
COMPOSE_HTTP_TIMEOUT=200 docker-compose up -d --build
```

The very first time you will need to provide the "initialAdminPassword" from /var/jenkins_home/secrets/initialAdminPassword, but as we have a volume we can just browse there and get it, and paste it into the jenkins web GUI

```
prompt$ cd jenkins_master_volume/
prompt$ cat secrets/initialAdminPassword 
```


### How to stop and remove the cotnainers
```
docker-compose down
```

### How to configure the slaves in the jenkins master

While not being automated yet, pelase check the ips of each slave in the docker-compose.yml file, configure them as ssh agents and the use the credentials jenkins:jenkins
