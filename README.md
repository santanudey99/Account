1. Run this image with -
docker run --name=account -d -v ~/accountlogs:/logs -p 3333:3333 registry.gitlab.com/santanudey/account
This will create log files under /accountlogs directory of current user.
2. Following command will create logs in cloudwatch as well as mounted volume.
docker run --log-driver=awslogs --log-opt awslogs-group=docker-logs --log-opt awslogs-stream=account-logs -d -v ~/accountlogs:/logs -p 3333:3333 registry.gitlab.com/santanudey/account echo 'account app deployed'
3. 