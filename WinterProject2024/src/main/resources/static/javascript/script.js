
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

function goToPostModify(boardId, postId){
    window.location.href=  "/" + boardId + "/" + postId + "/PostModify";
}

function goToPostDelete(boardId, postId){
    let url =  "/" + boardId + "/" + postId + "/PostDeleteFunction";
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            postId: postId,
            boardId: boardId
        }),
    })
    .then(response => {
        if(response.ok){
            alert('삭제 완료');
            window.location.href = "/BoardPostPage/" + boardId;
        } else {
            alert("삭제 실패");
        }
    });
}

function moveIframe(url){
    let iframe = document.getElementById("boardIframe");
    iframe.src = window.location.origin + url;
}