<script setup lang="ts">

import { apiNameExist } from '@/apis/NameExist'
import { apiEmailExist} from '@/apis/EmailExist'
import { apiSignIn } from '@/apis/SignIn'
import { apiSignUp } from '@/apis/SignUp'
import { ref } from 'vue'
import { useTokenStore } from '@/stores/token'
import router from '@/router/router'

const name = ref('')
const email = ref('')
const pw = ref('')
const msg = ref(' ')

const tokenStore = useTokenStore()

function clean() {
	name.value = ''
	email.value = ''
	pw.value = ''
}

function signIn() {
	console.log('signin')
	document.getElementById('container')!.classList.remove("right-panel-active");
	setTimeout(clean, 400)
}

function signUp() {
	console.log('signup')
	document.getElementById('container')!.classList.add("right-panel-active");
	setTimeout(clean, 400)
}


function nameExist() {
	apiNameExist(name.value).then((response) => {
		if(response.data.code == 500){
			msg.value = 'name exist'
		}else{
			msg.value = ' '
		}
	})
}

function emailExist() {
	apiEmailExist(email.value).then((response) => {
		if(response.data.code == 500){
			msg.value = 'email exist'
		}else{
			msg.value = ' '
		}
	})
}

function SignIn(){
	apiSignIn(email.value, pw.value).then((response)=>{
		if (response.data.code == 200) {
			console.log(response.data.msg)
			tokenStore.setUserName(response.data.userName)
			tokenStore.setUserId(response.data.userId)
			tokenStore.setToken(response.data.token)
			router.push('/MyPage')
		}else{
			alert("failed")
		}
	})
}

function SignUp(){
	apiSignUp(name.value, email.value,pw.value).then((response)=>{
		if (response.data.code == 200) {
			alert("success! Please sign in")
		}else{
			alert("failed")
		}
	})
}



</script>

<template>

	<div class="body-bg" id="bodu-bg">
		<div class="container" id="container">
			<div class="form-container sign-up-container">
				<form action="#">
					<h5></h5>
					<h1 class="tit">Create Account</h1>
					<p></p>					
					<input class="inp" type="text" v-model="name" @blur="nameExist" placeholder="Name" />
					<input class="inp" type="email" v-model="email" @blur="emailExist" placeholder="Email" />
					<input class="inp" type="password" v-model="pw" placeholder="Password" />
					<h5>{{msg}}</h5>
					<button type='button' @click="SignUp">Sign Up</button>
					<h5></h5>
				</form>
			</div>
			<div class="form-container sign-in-container">
				<form action="#">
					<h1 class="tit">Sign in</h1>
					<p></p>
					<input class="inp" type="email" v-model="email" placeholder="Email" />
					<input class="inp" type="password" v-model="pw" placeholder="Password" />
					<a>&nbsp</a>
					<!-- <a href="#">Forgot your password?</a> -->
					<button type='button' @click="SignIn">Sign In</button>
				</form>
			</div>
			<div class="overlay-container">
				<div class="overlay">
					<div class="overlay-panel overlay-left">
						<h1>Welcome Back!</h1>
						<p>To keep connected with us please login with your personal info</p>
						<button @click="signIn">Sign In</button>
					</div>
					<div class="overlay-panel overlay-right">
						<h1>Hello, Friend!</h1>
						<p>Enter your personal details and start journey with us</p>
						<button @click="signUp">Sign Up</button>
					</div>
				</div>
			</div>
		</div>
	</div>


</template>

<style scoped>
@import url('https://fonts.googleapis.com/css?family=Montserrat:400,800');

* {
	box-sizing: border-box;
}

.body-bg {
	background: #f6f5f7;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
	font-family: 'Montserrat', sans-serif;
	height: 100vh;
	width: 100%;
	position: fixed;
}

h1 {
	font-weight: bold;
	margin: 0;
}

h2 {
	text-align: center;
}

/* .tit {
	line-height: 4cm;
} */

p {
	font-size: 14px;
	font-weight: 100;
	line-height: 20px;
	letter-spacing: 0.5px;
	margin: 20px 0 30px;
}

span {
	font-size: 12px;
}

a {
	color: #333;
	font-size: 14px;
	text-decoration: none;
	margin: 15px 0;
}

button {
	border-radius: 20px;
	border: 1px solid #FF4B2B;
	background-color: #FF4B2B;
	color: #FFFFFF;
	font-size: 12px;
	font-weight: bold;
	padding: 12px 45px;
	letter-spacing: 1px;
	text-transform: uppercase;
	transition: transform 80ms ease-in;
}

button:active {
	transform: scale(0.95);
}

button:focus {
	outline: none;
}

button.ghost {
	background-color: transparent;
	border-color: #FFFFFF;
}

form {
	background-color: #FFFFFF;
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
	padding: 0 50px;
	height: 100%;
	text-align: center;
}

input {
	background-color: #eee;
	border: none;
	padding: 12px 15px;
	margin: 8px 0;
	width: 100%;
}

.container {
	background-color: #fff;
	border-radius: 10px;
	box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25),
		0 10px 10px rgba(0, 0, 0, 0.22);
	position: relative;
	overflow: hidden;
	width: 768px;
	max-width: 100%;
	min-height: 480px;
	/* margin: auto;
	transform: translate3d(0, 50%, 0); */
}

.form-container {
	position: absolute;
	top: 0;
	height: 100%;
	transition: all 0.6s ease-in-out;
}

.sign-in-container {
	left: 0;
	width: 50%;
	z-index: 2;
}

.container.right-panel-active .sign-in-container {
	transform: translateX(100%);
}

.sign-up-container {
	left: 0;
	width: 50%;
	opacity: 0;
	z-index: 1;
}

.container.right-panel-active .sign-up-container {
	transform: translateX(100%);
	opacity: 1;
	z-index: 5;
	animation: show 0.6s;
}

@keyframes show {

	0%,
	49.99% {
		opacity: 0;
		z-index: 1;
	}

	50%,
	100% {
		opacity: 1;
		z-index: 5;
	}
}

.overlay-container {
	position: absolute;
	top: 0;
	left: 50%;
	width: 50%;
	height: 100%;
	overflow: hidden;
	transition: transform 0.6s ease-in-out;
	z-index: 100;
	background: linear-gradient(315deg, rgba(101, 0, 94, 1) 3%, rgba(60, 132, 206, 1) 38%, rgb(99, 238, 44) 68%, rgba(251, 76, 76, 0.947) 98%);
	animation: gradient 10s ease infinite;
	background-attachment: fixed;
	background-size: 300% 300%;

}

.container.right-panel-active .overlay-container {
	transform: translateX(-100%);
}

.overlay {
	color: #FFFFFF;
	position: relative;
	left: -100%;
	height: 100%;
	width: 200%;
	transform: translateX(0);
	transition: transform 0.6s ease-in-out;
}

@keyframes gradient {
	0% {
		background-position: 0% 0%;
	}

	50% {
		background-position: 100% 100%;
	}

	100% {
		background-position: 0% 0%;
	}
}

.container.right-panel-active .overlay {
	transform: translateX(50%);
}

.overlay-panel {
	position: absolute;
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
	padding: 0 40px;
	text-align: center;
	top: 0;
	height: 100%;
	width: 50%;
	transform: translateX(0);
	transition: transform 0.6s ease-in-out;
}

.overlay-left {
	transform: translateX(-20%);
}

.container.right-panel-active .overlay-left {
	transform: translateX(0);
}

.overlay-right {
	right: 0;
	transform: translateX(0);
}

.container.right-panel-active .overlay-right {
	transform: translateX(20%);
}

.inp {
	border-radius: 400px
}
</style>