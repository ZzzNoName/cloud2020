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