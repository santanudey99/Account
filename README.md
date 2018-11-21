1. Run this image with -
docker run --name=account -d -v ~/accountlogs:/logs -p 3333:3333 registry.gitlab.com/santanudey/account
This will create log files under /accountlogs directory of current user.