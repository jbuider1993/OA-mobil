# app-oaserver

#### 介绍
微服务APP接口端,win10风格的一套系统，前端采用layui作为前端框架，后端采用SpringBoot作为服务框架，采用自封装的xml对所有请求进行参数校验，以保证接口安全性。
主项目地址：https://gitee.com/doc_wei01_admin/skyeye
APP端接口微服务地址：https://gitee.com/doc_wei01_admin/app-oaserver
APP端地址：https://gitee.com/doc_wei01_admin/oa-app
小程序端地址：https://gitee.com/doc_wei01_admin/small-pro

#### 软件架构

- |----app-oaserver------------------------OA项目APP接口服务
- - |----app-common---------------------工具层
- - |----app-eureka-----------------------服务注册与发现项目`[端口：8000]` `eureka监控`
- - |----app-producer--------------------不做任何权限校验的生产者`[端口：9000]`
- - |----app-producer-hastoken-----------只做userToken校验的生产者`[端口：9002]`
- - |----app-zipkin-----------------------分布式链路跟踪`[端口：8005]` `请求链路监控`
- - |----app-zuul------------------------网关`[端口：8888]`
- - - |----swagger2--------------------接口文档`[接口文档：http://localhost:8888/doc.html]`
- - |----app-consumer-------------------服务消费者（熔断器）`[端口：9001]`


#### 效果图

|效果图|效果图|
| ------------- | ------------- |
|![](https://s2.ax1x.com/2019/04/16/Avo0c8.png "1.png")|![](https://images.gitee.com/uploads/images/2019/0623/142954_6c8612f2_1541735.png "1.png")|
|![](https://images.gitee.com/uploads/images/2018/1107/104734_d9304e60_1541735.png "2.png")|![](https://images.gitee.com/uploads/images/2018/1107/104903_f244dfde_1541735.png "3.png")|
|![](https://s2.ax1x.com/2019/06/23/ZPS5h4.png)|![](https://images.gitee.com/uploads/images/2018/1118/191634_497ea929_1541735.png "微信图片_20181118191516.png")|
|![](https://images.gitee.com/uploads/images/2018/1118/193301_72d0bb49_1541735.png "微信截图_20181118193254.png")|![](https://s2.ax1x.com/2019/04/16/Av7lee.png "微信截图_20181120154643.png")|
|![](https://images.gitee.com/uploads/images/2018/1121/105120_65de9434_1541735.png "1.png")|![](https://images.gitee.com/uploads/images/2019/0623/145248_4a51c610_1541735.png)|
|![](https://images.gitee.com/uploads/images/2019/0122/113516_b0600e8f_1541735.png "1.png")|![](https://images.gitee.com/uploads/images/2018/1207/123501_3248346e_1541735.png "微信截图_20181207123447.png")|
|![](https://images.gitee.com/uploads/images/2019/0113/114947_1c7fa387_1541735.png "微信截图_20190113114922.png")|![](https://images.gitee.com/uploads/images/2019/0202/130711_7ed57951_1541735.png "3.png")|
|![](https://s2.ax1x.com/2019/06/23/ZPC6cd.png)|![](https://images.gitee.com/uploads/images/2019/0623/145351_dd55da65_1541735.png)|
|![](https://images.gitee.com/uploads/images/2019/0623/143810_e76aec71_1541735.png)|![](https://images.gitee.com/uploads/images/2019/0623/144143_1063782a_1541735.png)|
|![](https://images.gitee.com/uploads/images/2019/0623/144444_73cfd8a1_1541735.png)||


#### 环境搭建
##### 开发工具:

- MySql: 数据库</br>
- Tomcat: 应用服务器</br>
- SVN|Git: 版本管理</br>
- Nginx: 反向代理服务器</br>
- Varnish: HTTP加速器</br>
- IntelliJ IDEA|Eclipse: 开发IDE</br>
- Navicat for MySQL: 数据库客户端</br>
- Redis Manager：redis视图工具</br>

#### 资源下载

- JDK8 https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html</br>
- Maven http://maven.apache.org/download.cgi</br>
- Redis https://redis.io/download</br>
- Nginx http://nginx.org/en/download.html</br>

#### 在线文档

- [JDK8中文文档](https://blog.fondme.cn/apidoc/jdk-1.8-youdao/)</br>
- [Spring4.x文档](http://spring.oschina.mopaas.com/)</br>
- [Mybatis3官网](http://www.mybatis.org/mybatis-3/zh/index.html)</br>
- [Nginx中文文档](http://tool.oschina.net/apidocs/apidoc?api=nginx-zh)</br>
- [Git官网中文文档](https://git-scm.com/book/zh/v2)</br>

#### 项目交流：

**为防止恶意进群，特开启收费模式，请见谅。**

|QQ群|公众号|
|-------|-------|
|![](https://images.gitee.com/uploads/images/2018/1205/145236_4fce6966_1541735.jpeg "微信图片_20181205145217.jpg")|![](https://images.gitee.com/uploads/images/2018/1207/083137_48330589_1541735.jpeg "qrcode_for_gh_e7f97ff1beda_258.jpg")|
