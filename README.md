# MyLoginSystem
A login system using tokens for authentication build upon Spring-boot and Vue3.

## Components

### Languages and Resources/Plugins

#### BackEnd

- Java
- MySql
- SpringBoot
- MyBatis
- JSON Web Token
- FastJSON

#### FrontEnd

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

### Start FrontEnd server
```
$ cd ./LoginSysWeb
$ npm install
$ npm run dev
```
### Start BackEnd server

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
