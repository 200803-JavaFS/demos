

console.log("3" * 2); //6

console.log(5 + ""); //"5"

console.log(true == 1); //true

console.log(true == 8); //false

console.log("123" == 123); //true

console.log("123" === 123); //false

console.log(undefined == false); //false

console.log("string" == true); //false

console.log('' == false); //true

console.log(NaN == true); //false

console.log(1 == 1.0); //true

console.log(null == undefined); //true

console.log(null == 0); //false

console.log(0 == false); //true

console.log("true" == true); //false

console.log("string" * 8); //NaN

//truthy-falsey

if(true){
    console.log("true")
} else {
    console.log("false");
} //true

if(false){
    console.log("true")
} else {
    console.log("false");
} //false

if("string"){
    console.log("true")
} else {
    console.log("false");
} //true

if(""){
    console.log("true")
} else {
    console.log("false");
} //fasle

if(0){
    console.log("true")
} else {
    console.log("false");
} //fasle

if(-35){
    console.log("true")
} else {
    console.log("false");
} //true

if("string"*8){
    console.log("true")
} else {
    console.log("false");
} //false

if(null){
    console.log("true")
} else {
    console.log("false");
} //false

if(undefined){
    console.log("true")
} else {
    console.log("false");
} //false

function test() {
    return (true&&false)
}

console.log(test()); 

function strictly(){
'use strict';
var x = 9;
console.log(x)
}

strictly();
