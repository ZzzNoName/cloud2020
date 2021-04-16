###练习三种nacos配置
```yaml
#nacos-config-client-dev.yaml
config:
    info: nacos-config-client-dev  -1
```
```yaml
config:     
    info: nacos-config-client-info,DEV_GROUP -1
```
```yaml
config:     
    info: dev-22b9c782-705a-4769-ad9a-9b2097eb225c nacos-order-dev,DEFAULT_GROUP-1
```
###Nacos集群和持久化配置（重要）
```properties
#数据库更换  原先是derby
spring.datasource.platform=mysql
 
db.num=1
db.url.0=jdbc:mysql://192.168.226.128:3306/nacos_devtest?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC
db.user=root
db.password=root
```
###下载nginx配置
```conf
vim nginx.conf
 upstream cluster{
        server 127.0.0.1:3333;
        server 127.0.0.1:4444;
        server 127.0.0.1:5555;
    }
vim conf.d/default.conf
server {
    listen       1111;
    server_name  localhost;

    #charset koi8-r;
    #access_log  /var/log/nginx/host.access.log  main;

    location / {
       #root   /usr/share/nginx/html;
       #index  index.html index.htm;
       proxy_pass http://cluster;
    }
    .....
    重启nginx——nginx -c nginx.conf
}
```
###Nacos集群
```config
#修改cluster.conf
192.168.3.18:3333
192.168.3.18:4444
192.168.3.18:5555
```
```properties  
#修改application.properties
spring.datasource.platform=mysql
db.num=1
db.url.0=jdbc:mysql://127.0.0.1:3306/nacos_config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&serverTimezone=UTC
db.user=root
db.password=#Root1234
```
```shell script 
#修改startup.sh
while getopts ":m:f:s:c:p:d:" opt
do
    case $opt in
        m)
            MODE=$OPTARG;;
        f)
            FUNCTION_MODE=$OPTARG;;
        s)
            SERVER=$OPTARG;;
        c)
            MEMBER_LIST=$OPTARG;;
        p)
            EMBEDDED_STORAGE=$OPTARG;;
        d)
            PORT=$OPTARG;;
        ?)
        echo "Unknown parameter"
        exit 1;;
    esac
done
nohup $JAVA -Dserver.port=${PORT} ${JAVA_OPT} nacos.nacos >> ${BASE_DIR}/logs/start.out 2>&1 &
```
 执行./startup.sh -standalone -d 3333 
###安装mysql
导入——nacos-mysql.sql
```shell script

```

