const url = "http://localhost:8081/fluffybunnies/"

document.getElementById("loginbtn").addEventListener("click", loginFunc);

async function loginFunc() {
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;

    let user = {
        username : usern,
        password : userp
    }

    let resp = await fetch(url+"login", {
        method: 'POST',
        body: JSON.stringify(user)
    })

    if(resp.status===200){
        console.log(resp)
        document.getElementById("login-row").innerText = "YOU HAVE LOGGED IN.";
        let button = document.createElement('button');
        button.className = "btn btn-success";
        button.id = "findAllBtn";
        button.innerText = "Find All Avengers";
        button.onclick=findAllFunc;
        document.getElementById("table-row").appendChild(button);
    } else {
        document.getElementById("login-row").innerText = "Login failed!";
    }
}

async function findAllFunc() {
    const myHeaders = new Headers();

    myHeaders.append('Access-Control-Allow-Credentials', true);

    let resp = await fetch(url+"avenger", {
        mode: "no-cors",
        credentials: 'include',
        headers: myHeaders
      });

    if(resp.status===200){
        let data = await resp.json;
        console.log(data); 
    }
}