#!/bin/bash

# 기존 서버 종료
ps -ef | grep "WinterProject2024-0.0.1-SNAPSHOT.jar" | grep -v grep | awk '{print $2}' | xargs kill -9 2> /dev/null

if [ $? -eq 0 ];then
    echo "my-application Stop Success"
else
    echo "my-application Not Running"
fi

echo "my-application Restart!"
echo $1

# 서버 실행
nohup java -jar build/libs/WinterProject2024-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev > /dev/null 2>&1 &