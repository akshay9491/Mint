<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
<script>
function validate(){
var num=document.myform.num.value;
if (isNaN(num)){
  document.getElementById("numloc").innerHTML="Enter Numeric value only";
  return false;
}else{
  return true;
  }
}
</script>

<style>
*{  
  margin:0;
  padding:0;
}

body{
 
  background-color:#f0f0f0;
  font-family:helvetica;
}

#bg{
  position:relative;
  top:20px;
  height:1000px;
  width:800px;
  background:url('https://i.imgur.com/3eP9Z4O.png') center no-repeat;
  background-size:cover;
  margin-left:auto;
  margin-right:auto;
  border:#fff 15px solid;
}

.module{
  position:relative;
  top:15%;    
  height:70%;
  width:450px;
  margin-left:auto;
  margin-right:auto;
  border-radius:5px;
  background:RGBA(255,255,255,1);
 
 
}

.form1{
  float:left;
  height:100%;
  width:100%;
  box-sizing:border-box;
  padding:40px;
}

.textbox{
  height:50px;
  width:100%;
  border-radius:3px;
  border:rgba(0,0,0,.3) 2px solid;
  box-sizing:border-box;
  padding:10px;
  margin-bottom:30px;
}



.btnsubmit{
  height:50px;
  width:30%;
  border-radius:3px;
  border:rgba(0,0,0,.3) 0px solid;
  box-sizing:border-box;
  padding:10px;
  margin-bottom:30px;
  background:#90c843;
  color:#FFF;
  font-weight:bold;
  font-size: 12pt;
  transition:background .4s;
  cursor:pointer;
}


</style>



</head>
<body>
<div id="bg">
  <div class="module"><br>
    <ul>
   
      <center><h1>Withdraw Funds </h1></center>
    </ul>
  <div class="form1">
    <form  action="LoginController3" method="post">
    <input type="text" required name=" Customer Aadhar Number" placeholder=" Customer Aadhar Number" class="textbox" maxlength="12" name="num" > <span id="numloc"></span> 
      <input type="text" required name="Customer Account Number" placeholder="Customer Account Number" class="textbox"maxlength="12">
      <input type="text" required name="Agent Account Number" placeholder="Agent Account Number" class="textbox"maxlength="12">
       
      <input type="text"required name="Amount To Withdraw"  placeholder="Amount To Withdraw" class="textbox" maxlength="6">
   
    <br>
       
       
       <input type="password" placeholder="Security Pin" id = "myInput"  maxlength="5" class="textbox" required ><br>
       <input type="checkbox" onclick="myFunction() ">Show Password
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
       
 
      <center><button type ="submit" class="btnsubmit">Submit</button></center>
    </form>
  </div>
</div>
</div>
</body>
</html>
