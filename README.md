# MyLoginSystem
A login system using tokens for authentication build upon Spring-boot and Vue3.

## Components

### Languages and Resources/Plugins

#### Back-End

- Java
- MySQL
- SpringBoot
- MyBatis
- JSON Web Token
- FastJSON

#### Front-End

- TypeScript
- HTML
- CSS
- Vue 3
- Axios

## Geting Started

### Prerequisites

```
IntelliJ IDEA
Node.js
Mysql 8.0
```

### Clone

```
$ git clone https://github.com/JamesJiang97/MyLoginSys.git
```

### Start Front-End Server
```
$ cd ./LoginSysWeb
$ npm install
$ npm run dev
```
### Start Back-End Server

 1. Create database table by running 
   ```
   ./sql/tb_account.sql
   ```
 2. Modify the database path in 
   ```
   ./LoginSysServise/src/main/resources/application.yml
   ```
 3. Open ./LoginSysServise in IntelliJ IDEA and run 
   ```
   ./LoginSysServise/src/main/java/com/jiang/LoginSysBackendApplication.java
   ```
