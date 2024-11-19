let value_X, value_Y, value_R;
let points = [];
const CANVAS = document.getElementById("myCanvas");
const CTX = CANVAS.getContext("2d");
const INPUT = document.querySelector("input[type=text]");
const CHECKBOXES = document.querySelectorAll("input[type=checkbox]")
document.getElementById("check-button").onclick = manageData;
INPUT.oninput = setValueY;
document.querySelector("canvas")
    .addEventListener("click", (event) => handleImageClick(CANVAS, event));
draw();
CHECKBOXES.forEach(b => b.addEventListener("change", setValueX));

function setValueX(event) {
    let state = event.target.checked;
    CHECKBOXES.forEach(b => b.checked = false);
    event.target.checked = state;
    value_X = event.target.value;
}

function setValueY(){
    value_Y = INPUT.value;
}

function setValueR() {
    value_R = document.getElementById("r-input").options[document.getElementById("r-input").
        options.selectedIndex].value;
    draw();
}

function draw() {
    CTX.clearRect(0, 0, CANVAS.width, CANVAS.height);
    CTX.scale(1, 1);
    CTX.beginPath();
    CTX.fillStyle = "blue";
    CTX.moveTo(CANVAS.width / 2, CANVAS.height / 2);
    CTX.arc(CANVAS.width / 2, CANVAS.height / 2, 30 * value_R, 1.5 * Math.PI, 2 * Math.PI);
    CTX.fill();
    CTX.closePath();

    CTX.fillRect(CANVAS.width / 2, CANVAS.height / 2, -30 * value_R, 15 * value_R);

    CTX.moveTo(CANVAS.width / 2, CANVAS.height / 2);
    CTX.lineTo(CANVAS.width / 2, CANVAS.height / 2 - 30 * value_R);
    CTX.lineTo(CANVAS.width / 2 - 30 * value_R, CANVAS.height / 2);
    CTX.fill();

    CTX.fillStyle = "black";
    CTX.beginPath();
    CTX.moveTo(0, CANVAS.height / 2);
    CTX.lineTo(CANVAS.width, CANVAS.height / 2);
    CTX.closePath();
    CTX.stroke();

    CTX.beginPath();
    CTX.moveTo(CANVAS.width, CANVAS.height / 2);
    CTX.lineTo(CANVAS.width - 10, CANVAS.height / 2 - 5);
    CTX.lineTo(CANVAS.width - 10, CANVAS.height / 2 + 5);
    CTX.fillText('x', CANVAS.width - 15, CANVAS.height / 2 + 15);
    CTX.closePath();
    CTX.fill();

    CTX.beginPath();
    CTX.moveTo(CANVAS.width / 2 - 15 * value_R, CANVAS.height / 2 + 5);
    CTX.lineTo(CANVAS.width / 2 - 15 * value_R, CANVAS.height / 2 - 5);
    CTX.closePath();
    CTX.stroke();
    CTX.beginPath();
    CTX.moveTo(CANVAS.width / 2 - 30 * value_R, CANVAS.height / 2 + 5);
    CTX.lineTo(CANVAS.width / 2 - 30 * value_R, CANVAS.height / 2 - 5);
    CTX.closePath();
    CTX.stroke();
    CTX.beginPath();
    CTX.moveTo(CANVAS.width / 2 + 15 * value_R, CANVAS.height / 2 + 5);
    CTX.lineTo(CANVAS.width / 2 + 15 * value_R, CANVAS.height / 2 - 5);
    CTX.closePath();
    CTX.stroke();
    CTX.beginPath();
    CTX.moveTo(CANVAS.width / 2 + 30 * value_R, CANVAS.height / 2 + 5);
    CTX.lineTo(CANVAS.width / 2 + 30 * value_R, CANVAS.height / 2 - 5);
    CTX.closePath();
    CTX.stroke();

    CTX.beginPath();
    CTX.moveTo(CANVAS.width / 2, 0);
    CTX.lineTo(CANVAS.width / 2, CANVAS.height);
    CTX.closePath();
    CTX.stroke();

    CTX.beginPath();
    CTX.moveTo(CANVAS.width / 2, 0);
    CTX.lineTo(CANVAS.width / 2 - 5, 10);
    CTX.lineTo(CANVAS.width / 2 + 5, 10);
    CTX.fillText('y', CANVAS.width / 2 + 15, 10);
    CTX.closePath();
    CTX.fill();

    CTX.beginPath();
    CTX.moveTo(CANVAS.width / 2 + 5, CANVAS.height / 2 - 30 * value_R);
    CTX.lineTo(CANVAS.width / 2 - 5, CANVAS.height / 2 - 30 * value_R);
    CTX.closePath();
    CTX.stroke();
    CTX.beginPath();
    CTX.moveTo(CANVAS.width / 2 + 5, CANVAS.height / 2 - 15 * value_R);
    CTX.lineTo(CANVAS.width / 2 - 5, CANVAS.height / 2 - 15 * value_R);
    CTX.closePath();
    CTX.stroke();
    CTX.beginPath();
    CTX.moveTo(CANVAS.width / 2 + 5, CANVAS.height / 2 + 15 * value_R);
    CTX.lineTo(CANVAS.width / 2 - 5, CANVAS.height / 2 + 15 * value_R);
    CTX.closePath();
    CTX.stroke();
    CTX.beginPath();
    CTX.moveTo(CANVAS.width / 2 + 5, CANVAS.height / 2 + 30 * value_R);
    CTX.lineTo(CANVAS.width / 2 - 5, CANVAS.height / 2 + 30 * value_R);
    CTX.closePath();
    CTX.stroke();
    if (value_R > 2) {
        CTX.fillText("-R/2", CANVAS.width / 2 - 15 * value_R, CANVAS.height / 2 + 10);
        CTX.fillText("-R", CANVAS.width / 2 - 30 * value_R, CANVAS.height / 2 + 10);
        CTX.fillText("R/2", CANVAS.width / 2 + 15 * value_R, CANVAS.height / 2 + 10);
        CTX.fillText("R", CANVAS.width / 2 + 30 * value_R, CANVAS.height / 2 + 10);
        CTX.fillText("-R", CANVAS.width / 2 - 25, CANVAS.height / 2 + 30 * value_R);
        CTX.fillText("-R/2", CANVAS.width / 2 - 25, CANVAS.height / 2 + 15 * value_R);
        CTX.fillText("R", CANVAS.width / 2 - 25, CANVAS.height / 2 - 30 * value_R);
        CTX.fillText("R/2", CANVAS.width / 2 - 25, CANVAS.height / 2 - 15 * value_R);
    }
}

function validateX() {
    return value_X !== undefined && value_X !== null && !isNaN(value_X);
}

function validateY() {
    const yRegexp = /-?\d+[.?\d+]*/i;
    if (yRegexp.test(value_Y)) {
        return value_Y >= -3 && value_Y <= 5;
    } else {
        return false;
    }
}

function validateR() {
    return value_R !== undefined && value_R !== null && !isNaN(value_R);
}

function handleImageClick(canvas, event) {
    let area = canvas.getBoundingClientRect();
    let rawX = event.clientX - area.left - canvas.width / 2;
    let rawY = canvas.height / 2 - (event.clientY - area.top);
    value_X = (rawX / (canvas.width / 2) * value_R * 1.75);
    value_Y = (rawY / (canvas.height / 2) * value_R * 1.75);
    manageData();
}


function redrawCanvas(){
    CTX.clearRect(0, 0, CANVAS.width, CANVAS.height);
    draw();
    points.forEach((point) => drawPoint(point.x, point.y, point.r))
}


function manageData() {
    console.log(value_X, value_Y, value_R);
    if (validateX() && validateY() && validateR()) {
        fetch('/labwork2/controller', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                x: value_X,
                y: value_Y,
                r: value_R
            })
        }).then((response) => {
            return response.json();
        }).then((json) => {
            updateTable([json["x"], json["y"], json["r"], json["isHit"]]);
            drawPoint(value_X, value_Y, value_R);
            points.push({
                x: value_X,
                y: value_Y,
                r: value_R,
            })
            redrawCanvas();
        }).catch((e) => {
            document.getElementById("result-text").innerText = "error: " + e.message;
            document.getElementById("result-text").classList.add("errorStub");
            document.getElementById("result-text").style.display = "flex";
            setTimeout(() => {
                document.getElementById("result-text").style.display = "none";
                document.getElementById("result-text").classList
                    .remove(...document.getElementById("result-text").classList);
            }, 1000);
            });

    } else {
        document.getElementById("result-text").innerText = "Some of parameters(X, Y, R) are invalid." +
        "\nMake sure that input data is correct and try again.";
        document.getElementById("result-text").classList.add("warningStub");
        document.getElementById("result-text").style.display = "flex";
        setTimeout(() => {
            document.getElementById("result-text").style.display = "none";
            document.getElementById("result-text").classList
                .remove(...document.getElementById("result-text").classList);
        }, 1000);
    }

    function updateTable(data) {
        let table = document.getElementsByTagName('tbody')[0];
        let row = table.insertRow();
        let noDataRow = document.getElementById("no-data");
        if(noDataRow) {
            noDataRow.remove();
        }
        data.forEach((element) => {
            let cell = row.insertCell();
            cell.innerText = element;
        });
        document.getElementById("result-text").innerText = "Data has been successfully processed.";
        document.getElementById("result-text").classList.add("outputStub");
        document.getElementById("result-text").style.display = "flex";
        setTimeout(() => {
                document.getElementById("result-text").style.display = "none";
                document.getElementById("result-text").classList.remove(...document.getElementById("result-text").classList);
            },
            1000);

    }
}

function drawPoint(x, y, r) {
    const scale = 30 * r;
    const center_X = CANVAS.width / 2;
    const center_Y = CANVAS.height / 2;
    const dot_X = center_X + (x / (r * 1.75)) * scale;
    const dot_Y = center_Y - (y / (r * 1.75)) * scale;

    CTX.beginPath();
    CTX.arc(dot_X, dot_Y, 3, 0, 2 * Math.PI);
    CTX.fillStyle = "red";
    CTX.fill();
    CTX.closePath();
}

