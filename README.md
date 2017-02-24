# OnlineMovieTicketBookingSystem
index.html
signup.html
<html>
    <head>
        <title>
                SIGN UP
        </title>
        <link rel="stylesheet" type="text/css" href="signup.css" />
        <script src="signup.js" type="text/Javascript"></script>
    </head>
    <body class="signupBody">
        <div>
            <center>
                <h1>
                    <span class="S">S</span> ign
                    <span class="U">U</span> p
                </h1>
            </center>
        </div>
        <center>
        <h3 class="formsub">Fill the form below and sign up free.</h3>
        <form name="registerForm" method="get">
        <div >
            <div class="firstRow">
                
                <input id="name" type="text" autofocus="autofocus" placeholder="Enter Full Name" />
                
                <input id="email" type="text" placeholder="Enter Email(Username)" />

            </div>
            <br>
            <div class="secondRow">

                <input type="text" id="phoneNo" placeholder="Enter Phone Number" />

                <input type="text" id="state" placeholder="Enter Your State" />

            </div>
            <br>
            <div class="thirdRow">

                <input type="password" placeholder="Enter password" id="pswd" />
                <input type="password" placeholder="Re-enter password" id="rpswd" />

            </div><br>
            <input type="submit" value="Book Ticket" onclick="submitAction('book.html')"/>
        </div>
        </form>
        </center>
    </body>
</html>
signup.css
.S{
    font-size: 70px;
}
.U{
    font-size: 70px;
}
.formsub{
    margin-left: 22px;
}
.signupBody{
    background-color: cornflowerblue;
}
.firstRow{
    padding: 10px;
}
.secondRow{
    padding: 10px;
}
.thirdRow{
    padding: 10px;
}
signup.js
function validate(){
    var x = document.getElementById('email').value;
    var atPosition = x.indexOf("@");
    var dotPosition = x.lastIndexOf(".");
    var email, name, phoneNo, state, password;
    if(atPosition < 1 || dotPosition < atPosition + 2 || dotPosition + 2 >= x.length){
        alert("Not a valid e-mail address");
        email = false;
    }
    else{
        email = true;
    }

    var y = document.getElementById('name').value;
    if(y == "" || y == null || y == undefined){
        alert("Kindly enter name");
        name = false;
    }
    else{
        name = true;
    }

    var z = document.getElementById('phoneNo').value;
    var num = /^\d{10}$/;
    if(z. length == 10 && z.match(num)){
        phoneNo = true;
    }
    else{
        alert("Not a valid phoneNumber");
        phoneNo = false;
    }

    var p = document.getElementById('state').value;
    if(p == "" || p == null || p == undefined){
        alert("Kindly enter state")
        state = false;
    }
    else{
        state = true;
    }

    var q = document.getElementById('pswd').value;
    var r = document.getElementById('rpswd').value;
    if(q == ""){
        alert("Kindly enter password");
        password = false;
    }
    if (r == ""){
        alert("Kindly reenter password");
        password=false;
    }
    if(q != r){
        alert("Password doesnt match");
        password = false;
    }

    if(email && name && phoneNo && state && password){
        return true;
    }
    else{
        return false;
    }
};
function submitAction(act)
{
    document.registerForm.action = act;
    if(validate()){
        document.registerForm.submit();
    }
};
