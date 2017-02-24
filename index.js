function validate(){
    var uname = document.getElementById('uname').value;
    var x,y;
    if(uname == null || uname == undefined || uname == ""){
        alert("Kindly enter username");
         x = false;
    }
    var pswd = document.getElementById('pword').value;
    if(pswd == null || pswd == undefined || pswd == ""){
        alert("Kindly enter password");
        y = false;
    }
    if(x != false && y != false){
        return true;
    }
};
function submitAction(act)
{
    document.registerForm.action = act;
    if(validate()){
        document.registerForm.submit();
    }
};