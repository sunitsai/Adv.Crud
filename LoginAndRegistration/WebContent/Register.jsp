<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>Registration Form Using jQuery - Demo Preview</title>
<meta name="robots" content="noindex, nofollow">
<!-- Include CSS File Here -->
<link rel="stylesheet" href="css/register.css" />
<!-- Include JS File Here -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="js/register.js"></script>
<script type="text/javascript">
/* $(".log-in").click(function(){
	alert("called");
    $(".signIn").addClass("active-dx");
    $(".signUp").addClass("inactive-sx");
    $(".signUp").removeClass("active-sx");
    $(".signIn").removeClass("inactive-dx");
});

$(".back").click(function(){
    $(".signUp").addClass("active-sx");
    $(".signIn").addClass("inactive-dx");
    $(".signIn").removeClass("active-dx");
    $(".signUp").removeClass("inactive-sx");
}); */
/* function getDiv(){
	$(".signIn").addClass("active-dx");
    $(".signUp").addClass("inactive-sx");
    $(".signUp").removeClass("active-sx");
    $(".signIn").removeClass("inactive-dx");
}
function getDivBack(){
	$(".signUp").addClass("active-sx");
    $(".signIn").addClass("inactive-dx");
    $(".signIn").removeClass("active-dx");
    $(".signUp").removeClass("inactive-sx");
} */
</script>
</head>
<body>
	<div class="container">
    <form class="signUp">
        <h3>Create Your Account</h3>
        <p>Just enter your email address</br>
and your password for join.
        </p>
        <input class="w100" type="email" placeholder="Insert eMail" reqired autocomplete='off' />
        <input type="password" placeholder="Insert Password" reqired />
        <input type="password" placeholder="Verify Password" reqired />
        <button class="form-btn sx log-in" onclick="getDiv()" type="button">Log In</button>
        <button class="form-btn dx" type="submit">Sign Up</button>
    </form>
    <form class="signIn">
        <h3>Welcome</br>Back !</h3>
        <button class="fb" type="button">Log In With Facebook</button>
        <p>- or -</p>
        <input type="email" placeholder="Insert eMail" autocomplete='off' reqired />
        <input type="password" placeholder="Insert Password" reqired />
        <button class="form-btn sx back" onclick="getDivBack()" type="button">Back</button>
        <button class="form-btn dx" type="submit">Log In</button>
    </form>
</div>
</body>
</html>