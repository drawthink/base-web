# base-web
介绍：采用springmvc和mybatis及velocity模板的Javaweb基础项目，已经搭建好开发所需的全部环境，只需要修改几处配置，便可以在此之上开发你的项目，省去了搭建繁琐web环境的时间。

1.修改src/main/resources/jdbc.properties

    将数据库，uname,password修改为自己的。这个不用多说了吧。
    
2.mybatis根据数据库表自动生成实体，dao层以及Mapper文件。
      修改配置：generatorConfig.xml(文件中有具体注释）
   怎么运行呢？
   
   step1:
   
   ![](https://github.com/drawthink/base-web/blob/master/img/step1.png?raw=true)
   
   step2:
   
   ![](https://github.com/drawthink/base-web/blob/master/img/step2.png?raw=true)
    
   step3:
   
   ![](https://github.com/drawthink/base-web/blob/master/img/step3.png?raw=true)
   
>1.Name字段随便起一个名字

>2.Command Line中填入：mybatis-generator:generate

   step:4
   
   ![](https://github.com/drawthink/base-web/blob/master/img/step4.png?raw=true)
   
    这一步成功后会在dao,entity，mapping包出现对应数据库的表的xxxMapper.java,xxx.java,xxxMapper.xml。
  
3.至此环境已基本OK，可以开始专心编写自己的业务代码了。

4.项目结构。

![](https://github.com/drawthink/base-web/blob/master/img/tree.png?raw=true)

4.1common包封装了
    exception   自定义异常。
    logger      打印日志文件封装
    utils       相关工具类
    
4.2 在com.drawthink.controller.TestController中有简单的例子。

注：项目以后还会陆续完善，如有错误的地方，望大家指正。

项目地址：[github](https://github.com/drawthink/base-web)

希望大家能在github上给个star。