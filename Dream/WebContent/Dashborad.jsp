<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: "Lato", sans-serif;
}

.sidenav {
  height: 100%;
  width: 160px;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #111;
  overflow-x: hidden;
  padding-top: 20px;
}

.sidenav a {
  padding: 6px 8px 6px 16px;
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display: block;
}

.sidenav a:hover {
  color: #f1f1f1;
}

.main {
  margin-left: 160px; /* Same as the width of the sidenav */
  font-size: 28px; /* Increased text to enable scrolling */
  padding: 0px 10px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
</style>
</head>
<body>

<div class="sidenav">
  <a href="#about">About</a>
  <a href="#services">Services</a>
  <a href="#clients">Clients</a>
  <a href="#contact">Contact</a>
</div>

<div class="main">
<head>
<style>
img {
  border: 50% solid #4CAF50;
  border-radius: 3px;
  padding: 60px;
  width: 150px;
.newspaper {
  column-count:2;
  column-gap: 50px;
  column-rule-style: solid;
  column-rule-width: 2px;
}
</style>
</head>

<body>

<center>

<a href="Deposit.jsp"><img src="image/deposit.png" alt="deposite.png"  deposit style="width:150px"></a>
<a href="BalanceEnquiry.jsp"><img src="image\balance enquiry.png" alt="balance enquiry.png" style="width:150px"></a>
 <a href="mini statement.jsp"><img src="image\download.png" alt="mini statement.png" style="width:150px"></a>
  <a href="Transfer.jsp"><img src="image\transfer.png" alt="transfer.png" style="width:150px"></a>
   <a href="Withdraw.jsp"><img src="image\withdraw.png" alt="withdraw.png" style="width:150px"></a>
<a href="withdraw.html"><img src="image\report.png" alt="download" style="width:150px"></center>
</div>

</body>
</html>