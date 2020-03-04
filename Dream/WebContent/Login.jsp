<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MINT BANKING</title>
</head>
<style>

{
margin: 0;
padding: 0;
background :url("")
background-size: cover;
font-family:sans-serif
}
.title
{
	text-align:center;
	padding: 50px 0 20px;
}
.title h1
{
	margin: 0;
	padding: 0;
	color:#262626;
	text-transform: uppercase;
	font-size: 36px;
}
.container
{
width: 50%;
height: 400px;
background: #fff;
margin:0 auto;
border:2px solid #fff;
box-shadow: 0 15px 40px rgba(0,0,0,0.5);
}
.formBox
{
	width:30%;
	padding:80px 40px;
	box-sizing:border-box;
	height:400px;
	
	background:#fff;
}
.formBox p
{
	margin: 0;
	padding: 0;
	font-weight:bold;
	color:#a6af13;
}

.formBox input[type="text"],
.formBox input[type="Password"]
{
border: none;
border-bottom:2px solid #a6af13;
outline: none;
height: 40px;
}
.formBox input[type="text"]:focus,
.formBox input[type="Password"]:focus
{
	border-bottom:2px solid #262626;
}
.formBox input[type="submit"]
{
	border: none;
	outline: none;
	height: 40px;
	color: #fff;
	background:#262626;
	cursor: pointer;
}
.formBox input[type="submit"]:hover
{
	background:#a6af13;
}
.formBox a
{
color:#262626;
font-size: 12px;
font-weight:bold;
}

</style>
<body>
<div class="title"><h1>Sign In Form</h1></div>
<div class="container formBox">

<form action="LoginController1" method=post>

 <label for="username">UserName</label>
    <input  type="text"  id="username" name="username" required style="width:100%;margin-bottom:20px;">

    <label for="password">Password</label>
    <input type="password"  id = "myInput" name="password" required style="width:100%;margin-bottom:20px;"> 
<script>
function myFunction() {
  var x = document.getElementById("myInput");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}

</script>

	<br>

	<input type="checkbox" onclick="myFunction()">Show Password<br><br>
     <input  type="submit" name="" value="sign in" required style="width:100%; margin-bottom:20px;">
     <center><a href="#"> Forget Password</a></center>
  </form>
</div>
</form>
</div>
</body>
</html>
