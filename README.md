# MyLoginSystem
A login system using tokens for authentication build upon Spring-boot and Vue3.


## Demo

I'm excited to share the live demo of my project with you! Experience the features and functionality by visiting the following link:

[**Project Demo Link**](https://jamesjiang97.github.io/LoginSysWeb/)

⚠️ **Important Notice:** Please do not use your real username, email address, or password when testing the demo. I highly recommend using fictional information to protect your personal data. I will not be held responsible for any information leaks or security breaches resulting from the use of real credentials.

Enjoy exploring the demo, and feel free to provide feedback or report any issues you may encounter.



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
