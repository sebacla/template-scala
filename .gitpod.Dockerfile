FROM gitpod/workspace-full

SHELL ["/bin/bash", "-c"]
USER gitpod

RUN curl -s "https://get.sdkman.io" | bash
RUN . /home/gitpod/.sdkman/bin/sdkman-init.sh && sdk selfupdate force
RUN . /home/gitpod/.sdkman/bin/sdkman-init.sh && sdk install java $(sdk list java | grep -o "8\.[0-9]*\.[0-9]*\.hs-adpt" | head -1)
RUN . /home/gitpod/.sdkman/bin/sdkman-init.sh && sdk install sbt
RUN mkdir -p /tmp/mongodb && \
    cd /tmp/mongodb && \
    wget -qOmongodb.tgz https://fastdl.mongodb.org/linux/mongodb-linux-x86_64-ubuntu2004-5.0.2.tgz && \
    tar xf mongodb.tgz && \
    cd mongodb-* && \
    sudo cp bin/* /usr/local/bin/ && \
    rm -rf /tmp/mongodb && \
    sudo mkdir -p /data/db && \
    sudo chown gitpod:gitpod -R /data/db
