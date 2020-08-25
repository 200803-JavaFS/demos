const bubbling = false;
const capturing = true; 

document.getElementById("inner").addEventListener("click", () => {
    console.log("INNER - bubbling");
}, bubbling);

document.getElementById("middle").addEventListener("click", (event) => {
    console.log("MIDDLE - bubbling");
    event.stopImmediatePropagation();
}, bubbling);

document.getElementById("outer").addEventListener("click", () => {
    console.log("OUTER - bubbling");

}, bubbling);

document.getElementById("inner").addEventListener("click", () => {
    console.log("INNER - capturing");
}, capturing);

document.getElementById("middle").addEventListener("click", () => {
    console.log("MIDDLE - capturing");
}, capturing);

document.getElementById("outer").addEventListener("click", () => {
    console.log("OUTER - capturing");
}, capturing);