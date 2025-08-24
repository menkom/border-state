#!/bin/bash

export BORDER_WAITING_AREA_URL="http://localhost:8081"
export DATASOURCE_URL="jdbc:mariadb://localhost:3306/border_state_db"
export LOG_IN_JSON="false"
export POSTGRES_PASSWORD="your_password"
export POSTGRES_USER="bot_mariadb_user"

#set -a
#source .collector.env
#set +a

JAR_PATH="../../build/libs/border-state-collector-1.0.6.jar"

# get service that run on 8080 port
pid=$(lsof -t -i:8080)

if [ -n "$pid" ]; then
  echo "Current application running with PID $pid"
  kill -9 $pid
  if [ $? -eq 0 ]; then
    echo "Process finished"
  else
    echo "Failed to kill process"
  fi
else
  echo "No process found on port 8080"
fi

#java -Dlogging.config=./logback-spring.xml -jar "$JAR_PATH"
#nohup - not stop service on console close
#> /dev/null 2>&1  - no logging (but logging managed by application works)
# echo $! > border-state-collector.pid - save application PID to file
nohup java -Dlogging.config=./logback-spring.xml -jar "$JAR_PATH" > /dev/null 2>&1 & echo $! > border-state-collector.pid
echo "Application started in background with PID $!"