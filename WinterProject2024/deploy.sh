#!/bin/bash

# 실행 중이던 서버 종료
echo "Stopping current server..."
ps -ef | grep "WinterProject2024-0.0.1-SNAPSHOT.jar" | grep -v grep | awk '{print $2}' | xargs kill -9 2> /dev/null

if [ $? -eq 0 ]; then
    echo "Server stopped successfully."
else
    echo "!!! No running server found."
fi

# 최신 코드 가져오기 (로컬 변경 사항 삭제 후 강제 pull)
echo "Resetting local changes..."
git reset --hard HEAD
if [ $? -ne 0 ]; then
    echo "!!! Failed to reset local changes."
    exit 1
fi

echo "Pulling latest code..."
git pull origin main
if [ $? -ne 0 ]; then
    echo "!!! Failed to pull latest code."
    exit 1
fi

# 권한 주기
sudo chmod +x gradlew
sudo chmod +x deploy.sh
sudo chmod +x restart.sh

# Gradle 빌드
echo "Building the project..."
./gradlew build > build.log 2>&1

if [ $? -ne 0 ]; then
    echo "!!! Build failed. Check build.log for details."
    exit 1
fi

# 서버 실행
echo "Starting the new server..."
nohup java -jar build/libs/WinterProject2024-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev > app.log 2>&1 &

# 서버 시작 상태 확인
if [ $? -eq 0 ]; then
    echo "Server started successfully. Logs can be found in app.log."
else
    echo "!!! Failed to start the server. Check app.log for more details."
fi