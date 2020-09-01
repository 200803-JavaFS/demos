//I want all my divs with classname coolclassname
let divElements = document.getElementsByClassName("coolclassname");

//gets me my first div element.
let firstdiv = divElements[0];

let emptyP = document.getElementById("p3");

let myButton = document.getElementsByTagName('button')[0];

//now we can start our actual dom manipulation

myButton.onclick = domFunc;

function domFunc() {
    firstdiv.style.backgroundColor = "rebeccapurple";
    emptyP.textContent = "I now have content!"; 
}

