1.新建模块
1.1 新建multi-module 项目
删除其他，只留下 pom.xml，*.iml,.gitignore
1.2 新建子模块 alhpa,beta,common,core
子模块中删除其他，只留下 src,pom,*.iml
1.3 子模块内部文件
干掉子模块内部的*Application,resources目录；

组织模块

2 最外层pom:root
2.1 打包方式
    <packaging>pom</packaging>
2.2 modules
     <modules>
         <module>common</module>
         <module>core</module>
         <module>alpha</module>
         <module>beta</module>
     </modules>
2.3 pom版本管理
dependencyManagement
2.4 配置主类
注意：主类向上move一级，放到公共目录上，能够扫描到所有下级文件；
<mainClass>com.lei.min.CoreApplication</mainClass>
2.5 resource 扫描 xml 
                    <include>**/*.xml</include>
2.6 resource 扫描 application配置
                    <include>**/*.yml</include>
                    <include>**/*.properties</include>

3 子模块 pom
3.1 配置父类
    <parent>
        <groupId>com.lei.min</groupId>
        <artifactId>module</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
3.2 配置依赖
        <dependency>
            <groupId>com.lei.min</groupId>
            <artifactId>common</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
3.3 干掉多余配置 spring-boot-maven-plugin
所有pom的这个配置都去掉

4 遇到的问题
4.1 发现不了子模块组件
解决方法见2.4
4.2 读取不了application 配置文件
解决方法见2.6
4.3 启动报错 repackage failed:Unable to find main class
解决方法见1.3，2.4
4.4 右上角模块变灰问题处理 
setting->maven->Ignored Files 取消pom 勾选即可；

   
