const helloURL = "localhost:8080/users/list/read";

window.addEventListener("DOMContentLoaded", () => {

    function req() {
        const request = new XMLHttpRequest();
        request.open("GET", helloURL);
        request.setRequestHeader("Content-Type", "application/json; charset = utf8");
        request.send();
        request.addEventListener("load", function () {
            if (request.status === 200) {
                let data = JSON.parse(request.response);
                console.log(data);
            } else {
                console.error("Что-то пошло не так")
            }
        });
    }
    req();
});


