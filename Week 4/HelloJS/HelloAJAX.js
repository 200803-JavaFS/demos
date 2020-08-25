let button = document.getElementById('btn');
button.addEventListener("click", ajaxFunc);

let pokepic = document.getElementById("pokepic");
let pokename = document.getElementById("pokename");
let poketype = document.getElementById("poketype"); 
let pokenum = document.getElementById("pokenum");

function ajaxFunc() {
    let num = document.getElementById("field").value;

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200){
            let data = JSON.parse(xhr.responseText);
            renderHTML(data);
        }
    }

    xhr.open("GET", "https://pokeapi.co/api/v2/pokemon/"+num+"/");
    xhr.send();
}

function renderHTML(data) {
    pokepic.setAttribute("src", data.sprites.front_default);
    pokename.innerText = data.name;
    poketype.innerText = data.types[0].type.name;
    if(data.types[1]){
        poketype.append(", ");
        poketype.append(data.types[1].type.name);
    }
    pokenum.innerText = data.id;

}

