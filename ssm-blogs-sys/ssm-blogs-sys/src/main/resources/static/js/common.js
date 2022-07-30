function getUserInfo(pageName) {
    $.ajax({
        type: 'get',
        url: '/blog/login',
        success: function (body) {
            if (body.userId && body.userId > 0) {
                console.log("当前用户登录成功! 用户名: " + body.username);
                if (pageName == 'blog_list.html') {
                    changeUserName(body.username)
                }
            } else {
                alert("当前您尚未登录, 请登录后再访问博客列表!");
                location.assign('login.html');
            }
        },
        error: function () {
            alert("当前您尚未登录! 请登录之后再访问博客列表");
            location.assign('login.html');
        }
    });
}

function changeUserName(username) {
    let h3 = document.querySelector('.card>h3');
    h3.innerHTML = username;
}