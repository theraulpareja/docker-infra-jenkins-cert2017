# This Dockerfile configures basic slave
FROM jenkins:2.19.4
MAINTAINER Raul Pareja <raul.pareja@gmail.com>
USER jenkins
COPY ./groovy-scripts/masterexecutors.groovy /usr/share/jenkins/ref/init.groovy.d/masterexecutors.groovy
