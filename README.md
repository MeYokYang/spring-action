- [spring-action](#spring-action)
  - [项目初始化](#项目初始化)
  - [相关事项](#相关事项)

# spring-action

此项目是笔者学习《Spring 实战》<sup id="SpringInAction">[1](#footnote1)</sup>时所练习使用的项目。

相关平台版本信息：

|  平台   |              版本              |     查询指令     |
| :-----: | :----------------------------: | :--------------: |
| OS 平台 | CentOS7 3.10.0-1160.el7.x86_64 |    `uname -a`    |
|  Java   |          java 11.0.20          | `java --version` |
|  Maven  |       Apache Maven 3.9.6       | `mvn --version`  |
|   Git   |      git version 1.8.3.1       | `git --version`  |

## 项目初始化

1. Maven

   本项目使用 Maven 进行管理与构建。初始化项目时使用 Maven Archetype 生成项目骨架：

   ```shell
   mvn archetype:generate -DarchetypeCatalog=internal
   # groupId: xyz.meyok.study
   # artifactId: spring-action
   # version: 1.0-SNAPSHOT
   ```

   POM 中初始化主要设置 Java 版本、jar 包主类。

2. 运行脚本

   项目使用 Shell Script 脚本来进行 Maven 相关生命周期运行，以及 jar 包的执行。脚本文件为`${project_directory}/run.sh`<sup id="ProjectDirectory">[2](#footnote2)</sup>。

   ```shell
   vim ${project_directory}/run.sh
   # 内容见源文件
   chmod u+x ${project_directory}/run.sh
   ```

3. Git

   项目使用 Git 进行管理。main<sup id="MainBranchName">[3](#footnote3)</sup>、dev、meyok 分别为主分支、开发分支、meyok 用户分支：

   ```shell
   cd ${project_directory}
   git init
   git add . && git commit -m "init(ALL): 初始化 Maven 项目。"
   git branch dev
   git checkout -b meyok
   ```

## 相关事项

- 项目使用 JDK11 版本，测试时需要的 sun.misc.Unsafe 类已被弃用（在 jdk.unsupported 模块中），所以项目测试相关代码已被注解。

---

<a id="footnote1">1</a>: [美]Craig Walls.Spring in Action(5th Edition)[M].张卫滨.北京:人民邮电出版社.yyyy-MM-dd:1-xxx.[↩](#SpringInAction)

<a id="footnote2">2</a>: 本文 Shell 中涉及项目主目录时，使用 Shell 环境变量`${project_directory}`代替。[↩](#ProjectDirectory)

<a id="footnote3">3</a>: 本项目使用的 git 版本不支持初始化项目时指定主分支名，主分支名按照默认配置被初始化为 master，而本项目在被上传至远程仓库时，主分支名被修改为 main。[↩](#MainBranchName)
