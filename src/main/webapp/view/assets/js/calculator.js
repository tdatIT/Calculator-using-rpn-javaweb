//selector
const input = document.querySelector(".input");
const result = document.querySelector(".result");
const keys = document.querySelectorAll("button");
const display = document.querySelector(".display");
const output = document.querySelector(".output_postfix");
//eventlistener
keys.forEach(key => {
    key.addEventListener("click", cal);
});

function cal() {
    let buttonText = this.innerText;
    if (buttonText === "AC") {
        input.innerText = "";
        output.innerText = "";
        result.innerText = "0";
        result.style.animation = "";
        input.style.animation = "";
        display.style.height = "35vh";
        return;
    }
    if (buttonText === "DEL") {
        input.textContent = input.textContent.substr(0, input.textContent.length - 1);
        output.textContent = output.textContent.substr(0, output.textContent.length - 1);
        if(input.textContent.toString().length <= 24){
            //alert(input.textContent.toString().length);
            display.style.height = "35vh";
        }
        return;
    }
    if (buttonText === "=") {
        if(input.textContent.toString().length > 24){
            //alert(input.textContent.toString().length);
            display.style.height = "43vh";
        }
        //result.innerText = eval(output.innerText);
        result.style.animation = "big 0.5s ease-in-out";
        input.style.animation = "big 0.5s ease-in-out";
        //output.style.animation = "big 0.5s ease-in-out";
        result.style.animationFillMode = "forwards";
        input.style.animationFillMode = "forwards";
        //output.style.animationFillMode = "forwards";

    } else {
        input.textContent += buttonText;
        return;
    }

}

function getDataToServer() {
    let infix_str = $('.input').text();
    $.post("calculate", {infix: infix_str}, function (response) {
        const result_arr = response.split(';');
        if (result_arr[0] === 'null') {
            $(".result").text("Expression Error Syntax")
            $(".output_postfix").text("");
        } else {
            $(".postfix").text("Postfix: "+ result_arr[1]);
            $(".result").text(result_arr[0]);
            $(".output_postfix").text(result_arr[1]);
        }

    })
}

function clearDisplay() {
    $('.input').text("");
}

function backSpaceDisplay() {
    let str = $('.input').text();
    $('.input').text(str.slice(0, -1));
}

$(document).ready(function () {
    $('#send').click(function (e) {
        getDataToServer();
    })
})
$(document).keydown(function (e) {
    let display_str = $('.input').text();
    switch (e.keyCode) {
        case 8:
            backSpaceDisplay()
            break;
        case 13:
            getDataToServer()
            break;
        case 46:
            clearDisplay()
            break;
        default:
            if ((e.keyCode >= 48 && e.keyCode <= 57)
                || (e.keyCode >= 96 && e.keyCode <= 111)
                || (e.keyCode >= 187 && e.keyCode <= 191)) {
                $('.input').text($('.input').text() + e.key);
            }
            break;
    }
})
