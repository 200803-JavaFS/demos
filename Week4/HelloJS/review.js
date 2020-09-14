//these are global scoped variables. 
console.log(a);

var a = 1;
let b = 'b';
const c = true;
//this is a var at the global scope
h = "h";

function func() {
    //these are functional scoped variables. 
    var d = 'd';
    let e = 'func e';
    const f = false;
    console.log("d: "+d+" e: "+e+" f: "+f);
    //this is a globally scoped var once the function is called. 
    w = "this is very wierd";
    if(true){
        var x = "X";
    }
    console.log(x)
}

func();

function func2(myfunc) {
    //this is a callback function
    myfunc();    
}

func2(func);

console.log(w);
//console.log(x);


if(true){
    //This var is global scoped
    var i = "I don't know";
    //these are blocked scoped variables
    let k = "I'm okay";
    const l = "Lets be constant";
    console.log(i+l);
}

console.log(i);
//console.log(k);
//console.log(l);


//console.log("d: "+d+" e: "+e+" f: "+f);

let r = [true, "false", {variable:"obj var"}, 3243];

console.log(r);


func2(()=>{
    console.log("I'm in an arrow function")
})

func2((p)=>{
    p = "I'm a param"
    console.log("I'm in an arrow function "+p)
})


function closure(){
    q = "I'm a closure";
    return function inner(){
        console.log(q)
        return q; 
    }
}

closure = closure();

console.log(closure)
let o = closure();
console.log(o);


//JS Object
let animal = {
    eats:true,
    walk() {
        alert("Animal walk")
    }
};

//Prototypal inheretance
let rabbit = {
    jumps:true,
    __proto__: animal
};

console.log(rabbit.eats);
console.log(rabbit.jumps);
rabbit.walk();
console.log(rabbit);
console.log(animal);

//class declaration
class Rectangle {
    constructor(h, w){
        this.height = h;
        this.width = w;
    }
}



let square = new Rectangle(10, 10);

console.log(square);


//Class expresions

let Oval = class{
    constructor(d){
        this.diameter = d;
    }
}

let circle = new Oval(5);

console.log(circle.diameter);