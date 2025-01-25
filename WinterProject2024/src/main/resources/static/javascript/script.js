
function goToRegister(){
    window.location.href = "/register";
}

function goToLogin(){
    window.location.href = "/loginPage";
}

function goToLogout(){
    window.location.href = "/logout";
}

function goToBoardManagement(){
    window.location.href= "/BoardManagement";
}

function goToCreatePost(boardId){
    window.location.href= "/BoardPostPage/" + boardId + "/CreatePost";
}

function moveIframe(url){
    let iframe = document.getElementById("boardIframe");
    iframe.src = window.location.origin + url;
}