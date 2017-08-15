# This Dockerfile configures basic slave
FROM ubuntu:16.04
MAINTAINER Raul Pareja <raul.pareja@gmail.com>

# Install basic build toold and  opensshd
RUN apt-get update && apt-get install -y \
    sudo \
    git \
    curl \
    wget \
    software-properties-common \
    openssh-server 

#Install openjdk8 once software-properties-common
RUN add-apt-repository -y ppa:openjdk-r/ppa &&\
    apt-get update && apt-get install -y \
    openjdk-8-jre-headless \
&& rm -rf /var/lib/apt/lists/*
    
# Create jenkins user 
RUN useradd -m -d /home/jenkins -s /bin/bash jenkins &&\
    echo "jenkins:jenkins" | chpasswd

# Configure SSH server (mind the need to create /var/run/sshd)
RUN sed -ri 's/^session\s+required\s+pam_loginuid.so$/session optional pam_loginuid.so/' /etc/pam.d/sshd && \
    mkdir -p /var/run/sshd

# Standard SSH port
EXPOSE 22

# Default command
CMD ["/usr/sbin/sshd", "-D"]
