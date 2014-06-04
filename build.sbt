name := "it-store-manager"

version := "1.0.0"

scalaVersion := "2.10.3"

seq(webSettings :_*)

scalaSource in Compile := baseDirectory.value / "src/scala"

javaSource in Compile := baseDirectory.value / "src/java"

scalaSource in Test := baseDirectory.value / "test/scala"

javaSource in Test := baseDirectory.value / "test/java"

resourceDirectory in Compile := baseDirectory.value / "conf"

resourceDirectory in Test := baseDirectory.value / "test/conf"

libraryDependencies += "org.eclipse.jetty" % "jetty-webapp" % "9.1.0.v20131115" % "container"

libraryDependencies += "org.eclipse.jetty" % "jetty-plus" % "9.1.0.v20131115" % "container"

libraryDependencies += "org.eclipse.jetty" % "jetty-jsp" % "9.1.0.v20131115" % "container"

libraryDependencies += "javax.servlet" % "servlet-api" % "2.5" % "provided"

libraryDependencies += "javax.servlet.jsp" % "javax.servlet.jsp-api" % "2.3.1" % "provided"

libraryDependencies += "javax.servlet" % "jstl" % "1.2"

libraryDependencies += "org.apache.tomcat" % "el-api" % "6.0.39" % "provided"

libraryDependencies += "dom4j" % "dom4j" % "1.6.1"

libraryDependencies += "jaxen" % "jaxen" % "1.1.6"

libraryDependencies += "org.scalatest" %% "scalatest" % "1.9.2" % "test"

libraryDependencies += "org.scalamock" %% "scalamock-scalatest-support" % "3.0.1" % "test"

libraryDependencies += "junit" % "junit" % "4.11" % "test"

libraryDependencies += "com.novocode" % "junit-interface" % "0.10" % "test"

libraryDependencies += "commons-beanutils" % "commons-beanutils" % "1.9.1"

libraryDependencies += "org.hibernate" % "hibernate-core" % "3.6.10.Final"

libraryDependencies += "com.h2database" % "h2" % "1.4.177"

libraryDependencies += "org.apache.struts" % "struts2-core" % "2.3.16.3"

libraryDependencies += "org.springframework" % "spring-core" % "3.2.8.RELEASE"

libraryDependencies += "org.springframework" % "spring-beans" % "3.2.8.RELEASE"

libraryDependencies += "org.springframework" % "spring-context" % "3.2.8.RELEASE"

libraryDependencies += "org.springframework" % "spring-aspects" % "3.2.8.RELEASE"

libraryDependencies += "org.springframework" % "spring-test" % "3.2.8.RELEASE" % "test"

libraryDependencies += "org.springframework" % "spring-web" % "3.2.8.RELEASE"

libraryDependencies += "org.springframework" % "spring-orm" % "3.2.8.RELEASE"

libraryDependencies += "org.springframework" % "spring-tx" % "3.2.8.RELEASE"

libraryDependencies += "org.apache.struts" % "struts2-spring-plugin" % "2.3.16.3"

libraryDependencies += "c3p0" % "c3p0" % "0.9.1.2"

libraryDependencies += "org.aspectj" % "aspectjweaver" % "1.8.0"

libraryDependencies += "log4j" % "log4j" % "1.2.17"

libraryDependencies += "org.slf4j" % "slf4j-log4j12" % "1.7.7"
