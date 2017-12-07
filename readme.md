# springboot-mybatis-druid

>  springboot-mybatis-druid整合，使用druid数据源控制，mybatis持久化，springmvc视图
>
>  只引入了整合相关依赖包

- maven
- springboot
- mybatis
- druid

### pom

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<!-- 项目信息 -->
	<groupId>com.project</groupId>
	<artifactId>springboot-mybatis-druid</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>springboot-mybatis-druid</name>
	<url>http://maven.apache.org</url>

	<!--配置属性，版本号 -->
	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<java.version>1.7</java.version>
		<druid.version>1.1.5</druid.version>
		<spring-boot.version>1.5.6.RELEASE</spring-boot.version>
	</properties>
	
	<!-- spring boot依赖 非parent调用 -->
	<dependencyManagement>
		<dependencies>
			<dependency>
				<!-- Import dependency management from Spring Boot,not include plugin 
					management as the parent import style -->
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-dependencies</artifactId>
				<version>${spring-boot.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>

	<dependencies>
		<!-- spring boot -->
		<!-- https://docs.spring.io/spring-boot/docs/1.2.3.RELEASE/reference/html/using-boot-build-systems.html#using-boot-starter-poms -->
		<!-- spring boot web 包含spring mvc和tomcat-->
		<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
          	<exclusions>
		        <!-- 去除spring-boot-start内的logback依赖使用log4j2 -->
		        <exclusion>
		            <groupId>org.springframework.boot</groupId>
		            <artifactId>spring-boot-starter-logging</artifactId>
		        </exclusion>
		    </exclusions> 
        </dependency>
        <!-- springboot 单元测试 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
        </dependency>
        
        <!-- springboot的mybaties -->
		<!-- https://mvnrepository.com/artifact/org.mybatis.spring.boot/mybatis-spring-boot-starter -->
		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>1.3.1</version>
		</dependency>
		
		<!-- druid -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>${druid.version}</version>
        </dependency>
        
        <!-- 数据库驱动 -->
        <!-- postgre -->
		<!-- https://mvnrepository.com/artifact/postgresql/postgresql -->
		<dependency>
		    <groupId>postgresql</groupId>
		    <artifactId>postgresql</artifactId>
		    <version>9.1-901-1.jdbc4</version>
		</dependency>
      	<!-- springboot log4j2 -->
		<dependency>
		    <groupId>org.springframework.boot</groupId>
		    <artifactId>spring-boot-starter-log4j2</artifactId>
		</dependency>
		
		<!-- if no this dependency, then error comes: 	ClassNotFoundException:org.apache.log4j.Priority! -->  
		<!-- 好像是由于druid依赖导致的找不到log4j类 -->
        <dependency>  
          <groupId>log4j</groupId>  
          <artifactId>log4j</artifactId>  
          <version>1.2.12</version>  
        </dependency>  
	</dependencies>
  
	<build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>2.1</version>
                <configuration>
                    <source>1.7</source>
                    <target>1.7</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-source-plugin</artifactId>
                <executions>
                    <execution>
                        <id>attach-sources</id>
                        <goals>
                            <goal>jar</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-javadoc-plugin</artifactId>
                <executions>
                    <execution>
                        <id>attach-javadoc</id>
                        <goals>
                            <goal>jar</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <charset>UTF-8</charset>
                    <encoding>UTF-8</encoding>
                    <docencoding>UTF-8</docencoding>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-gpg-plugin</artifactId>
                <executions>
                    <execution>
                        <id>sign-artifacts</id>
                        <phase>verify</phase>
                        <goals>
                            <goal>sign</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```

### update

更改build构建，增加打包jar，打包war(已注释)相关依赖。

修改入口App.class，支持打包war。

日志使用log4j2。