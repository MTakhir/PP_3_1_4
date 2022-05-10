fetch(/admin)
    .then(response => response.json())
    .then(users=>{
        users.forEach((user)=>{
            temp += "<tr>";
            temp += "<td>"+user.id+"</td>"
            temp += "<td>"+user.firstName+"</td>"
            temp += "<td>"+user.lastName+"</td>"
            temp += "<td>"+user.age+"</td>"
            temp += "<td>"+user.email+"</td>"
            temp += "<td>"+user.email+"</td>"
        })
        document.getElementById("tableAllUsers").innerHTML = temp
    }))