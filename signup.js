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