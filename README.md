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

### How to build and run the containers + basic config of jenkins

Run it with docker-compose and in daemon mode forcing build at least the very first time
```
COMPOSE_HTTP_TIMEOUT=200 docker-compose up -d --build
```

The very first time you will need to provide the "initialAdminPassword" from /var/jenkins_home/secrets/initialAdminPassword, but as we have a volume we can just browse there and get it, and paste it into the jenkins web GUI

```
prompt$ cd jenkins_master_volume/
prompt$ cat secrets/initialAdminPassword 
```
For the certification jenkins lab, is recommended to just install the suggested plugins

### How to stop and remove the cotnainers
```
docker-compose down
```

### How to add the slave nodes into the jenkins master

While not being automated yet, pelase notice the steps needed to add the 3 ubuntu slaves created by the docker-compose to the jenkins master once initially configured:

* As an admin user, go to the url localhost:8080/computer, select 'New Node'
* Provide a node name, e.g. linux-slave1 and select 'permanent agent'
* Fill the data requested, name, description, executors until you rech launch method
* Select Launch method to 'Launch slave agent via SSH'
* Provide the ip in the host field acording to the ips of the docker-compose.yaml file, the original ones are 192.168.250.3 for unbut_salve1, 192.168.250.4 for unbut_salve2 and 192.168.250.5 for unbut_salve3
* You will need to create the jenkins credentials by clicking Add -> Jenkins -> ensure Kind Userame with password and fill Username with jenkins and Password with jenkins and finally Add
* IMPORTANT, select Host Key Verification Strategy to 'Non verifying Verfication Strategy'  you will need to add(create) credentials the first time with user jenkins and password jenkins,
