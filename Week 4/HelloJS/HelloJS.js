console.log("Hello JavaScript it's nice to meet you!");

//JavaScript is loosely type so I can change the type of 
//data held in a declared variable

var a = 100;
a = true;
a = null;
a = "I'm a string";

console.log(a); //prints I'm a string. 

var b;
console.log(b); //prints underfined

//This is JS function

function logMessageFromInput() {
    message = document.getElementById('messageInput').value;
    console.log(message);
}

var anon = function () {
    console.log("In an anonymous function")
}

anon(); 

//Callback function

function funcOne(x) {console.log('x = '+x)}

function funcTwo(y, callback) {
    callback(y);
}

console.log(q);
funcTwo(9, funcOne);
funcTwo(5, funcThree)

/*the funcThree declaration is being 
hoisted so it can be called on line 39 before is declared
on line 44*/
function funcThree(z) {console.log('z = '+z)}


var q ="I'm a global trotter"

function adder(x) {

    return function (y){
        console.log(w);
        console.log(q); 
        var w = 5
        return x + y;
    }
}



var add5 = adder(5);

var add10 = adder(10);

console.log(add5(7));
console.log(add10(7));

