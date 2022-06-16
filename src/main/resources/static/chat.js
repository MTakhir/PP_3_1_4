var stompClient = null;
$(document).ready(function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body));
        });
    });
})


function sendMessage() {
    stompClient.send("/app/hello", {}, JSON.stringify({'fromUserName': '', 'content': $("#message").val()}));
    message.value = ''
}

function showGreeting(message) {
    $("#greetings").append(`<tr><td>${message.fromUserName}: ${message.content}</td></tr>`);
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#send" ).click(function() { sendMessage(); });
});