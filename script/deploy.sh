#!/bin/bash

REPOSITORY=/home/ec2-user/app/S3
PROJECT_NAME=place

echo "> Build 파일복사"
cp $REPOSITORY/zip/*.war $REPOSITORY

echo "> 현재 구동 중인 애플리케이션 pid 확인"
CURRENT_PID=$(pgrep -fl place | grep war | awk '{print $1}')

echo "현재 구동 중인 애플리케이션 pid: $CURRENT_PID"

if [ -z "CURRENT_PID" ]; then
  echo "> 현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다."
else
  echo "> kill -15 CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> 새 애플리케이션에 배포"

WAR_NAME=$(ls -tr $REPOSITORY/*.war | tail -n 1)

echo "> WAR Name: $WAR_NAME"

echo "> $WAR_NAME 에 실행권한 추가"

chmod +x $WAR_NAME

echo "> $WAR_NAME 실행"

nohup java -jar \
  -Dspring.config.location=classpath:/application.yml,classpath:/application-real.yml,/home/ec2-user/app/application-real-db.properties \
  -Dspring.profiles.active=real \
  $WAR_NAME > $REPOSITORY/nohup.out 2>&1 &