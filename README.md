# Vue + Spring Boot 登录系统

## 项目简介
本项目是一个基于 **Vue 3 (Vite)** 和 **Spring Boot** 开发的前后端分离登录系统。实现了用户注册、登录流程。


## 技术栈

### 前端
- **核心框架**: Vue 3
- **构建工具**: Vite
- **UI 组件库**: Element Plus
- **路由管理**: Vue Router
- **HTTP 客户端**: Axios

### 后端
- **核心框架**: Spring Boot
- **ORM 框架**: MyBatis-Plus
- **数据库**: MySQL 8.0
- **工具库**: Lombok, FastJSON

## 快速开始 

你可以选择 **直接运行成品 (jar)** 或 **从源码启动**。
### 方式 A：直接运行成品
无需安装 Node.js 和 Maven，直接下载 Release 中的 `LoginTest1.jar`。

1. **准备数据库**：导入 `login_project.sql`。
2. **启动命令**：
   - 如果你的数据库密码是 `123456`：
     ```bash
     java -jar LoginTest1.jar
     ```
   - 如果你的密码不是 `123456` ：
     ```bash
     java -jar LoginTest1.jar --spring.datasource.password=你的密码
     ```

---
### 方式 B：从源码启动
#### 1. 环境准备
确保你的电脑已安装：
- **JDK**: 17+
- **MySQL**: 8.0+
- **Node.js** (仅在需要修改前端代码时需要)

#### 2. 数据库配置
1. **初始化数据库**：
   请在数据库工具中执行项目根目录下的 `login_project.sql` 脚本。
   > **注意**：脚本会自动创建名为 `mydb1` 的数据库并导入初始数据。
   
2. **修改后端配置**：
   打开 `src/main/resources/application.properties`，确认数据库账号密码是否匹配：
   ```properties
   # 确保数据库名是 mydb1
   spring.datasource.url=jdbc:mysql://localhost:3306/mydb1
   # 修改为你本地的 MySQL 账号密码
   spring.datasource.username=root
   spring.datasource.password=你的密码
3. **启动项目**:
启动后端：运行 LoginTest1Application 主类。
本项目后端已集成静态资源，直接访问 http://localhost:8080 即可看到页面。