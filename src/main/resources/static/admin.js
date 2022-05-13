const url ='http://localhost:8080/users'

fetch(url)
    .then(res => { res.json().then(
        users=>{
            var temp = ""

            users.forEach((user)=>{
                temp += "<tr class=\"allUsersTable\">";
                temp += "<td>"+user.id+"</td>"
                temp += "<td>"+user.firstName+"</td>"
                temp += "<td>"+user.lastName+"</td>"
                temp += "<td>"+user.age+"</td>"
                temp += "<td>"+user.email+"</td>"
                temp += "<td>"+user.email+"</td>"
                temp += "<td><button class=\"btn btn-info eBtn\" data-toggle=\"modal\">Edit</button></td>"
                temp += "<td><button class=\"btn btn-danger dBtn\" data-toggle=\"modal\">Delete</button></td>"
            })
            document.getElementById("tableAllUsers").innerHTML = temp
        }
    )

    })


