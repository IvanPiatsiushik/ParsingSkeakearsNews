#!/usr/bin/env bash
mvn package -Dmaven.test.skip
echo 'Copy files ...'
scp ssh -i~/.ssh/vscale \
    target/testSneakerParse-0.0.1-SNAPSHOT.jar\
    root@77.223.97.24:/home/ivan/app/jar-files/

echo 'Restart server...'
ssh -i~/.ssh/vscale root@77.223.97.24 <<EOF
pgrep java | xargs kill -9
nohup java -jar testSneakerParse-0.0.1-SNAPSHOT.jar > log.txt &
EOF
echo 'Bye'