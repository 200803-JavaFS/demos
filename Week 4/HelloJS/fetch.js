//Pokeapi endpoint
let apiURL = 'https://pokeapi.co/api/v2/pokemon/';

document.getElementById('getData').onclick = getData;

async function getData() {
    let userInput = document.getElementById('dataInput').value; 

    //clears the section "data" so that each time only one pokemon's information is displayed.
    document.getElementById('data').innerHTML = '';

    let response = await fetch(apiURL+userInput+'/');

    if(response.status === 200) {
        let data = await response.json();
        populateData(data);
    } else {
        document.getElementById('data').innerHTML = 'It got away!';
    }
}

function populateData(response) {
    let dataSection = document.getElementById('data');

    let nameTag = document.createElement('h3');
    nameTag.innerHTML = capitalize(response.name);
    let abilitiesArray = response.abilities;
    let abil = document.createElement('ul');
    for(let ability of abilitiesArray){
        let abilityLI = document.createElement('li');
        abilityLI.innerHTML = capitalize(ability.ability.name);
        abil.appendChild(abilityLI);
    } 

    dataSection.appendChild(nameTag);
    dataSection.innerHTML += 'Abilities<br>';
    dataSection.appendChild(abil);

    let spritesObj = response.sprites;

    for (let sprite in spritesObj) {
        if(spritesObj[sprite]) {
            let spriteImg = document.createElement('img');
            spriteImg.src = spritesObj[sprite];
            dataSection.appendChild(spriteImg);
        }
    }
}

function capitalize(str) {
    if(str){
        return str.charAt(0).toUpperCase() + str.slice(1);
    } else {return '';}
}