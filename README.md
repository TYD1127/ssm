#Name：SSM初级实践
##所用技术：Spring+SpringMVC+Mybatis，Ajax+Bootstrap；
实现功能：数据库CUDR；AJax异步效验用户名；用户登录；

Jquery：{
## #id
选择器——概述：根据给定的ID匹配一个元素。

如果选择器中包含特殊字符，可以用两个斜杠转义。参见示例。

参数
id
  String用于搜索的，通过元素的 id 属性中给定的值

示例
描述:
查找 ID 为"myDiv"的元素。

HTML 代码:
<div id="notMe"><p>id="notMe"</p></div>
<div id="myDiv">id="myDiv"</div>jQuery 代码:
$("#myDiv");
}

Ajax总结:
1.导包；{
 ```xml
   <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>jquery</artifactId>
            <version>3.5.1</version>
        </dependency>
```

```xml
        <!--引入-->
            <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
```
}

2.编写Controller接受请求，返回数据；
3.编写Ajax请求
4.Ajax绑定事件，点击事件（.clack）;失去焦点（onblur）；键盘弹起（keyup）


###解决中文乱码（controller传给前端中文）
  ```xml
    <!-- 处理请求返回json字符串的乱码问题 -->
    <mvc:annotation-driven>
        <mvc:message-converters register-defaults="true">
            <bean class="org.springframework.http.converter.StringHttpMessageConverter">
                <property name="supportedMediaTypes">
                    <list>
                        <value>text/html;charset=UTF-8</value>
                        <value>application/json;charset=UTF-8</value>
                    </list>
                </property>
            </bean>
        </mvc:message-converters>
    </mvc:annotation-driven>
```
