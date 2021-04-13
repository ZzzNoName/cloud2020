#SPRINGCLOUD BUS
###rabbitmq 插件安装方式
rabbitmq-plugins enable rabbitmq_management

###原先的通知方式
curl -X POST "http://localhost:3355/actuator/refresh"

###广播通知
curl -X POST "http://localhost:3344/actuator/bus-refresh"

###单点通知
curl -X POST "http://localhost:3344/actuator/bus-refresh/config-client:3355" 