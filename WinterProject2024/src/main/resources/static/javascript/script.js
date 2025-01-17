
function goToRegister(){
    window.location.href = "/register"
}

function goToLogin(){
    window.location.href = "/loginPage"
}

function goToLogout(){
    window.location.href = "/logout"
}

function goToBoardManagement(){
    window.location.href= "/BoardManagement"
}

function moveIframe(url){
    let iframe = document.getElementById("boardIframe");
    iframe.src = url;
}