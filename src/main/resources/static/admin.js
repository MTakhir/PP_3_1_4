const url1 ='http://localhost:8080/users/user'
const url2 ='http://localhost:8080/users'
const url3 ='http://localhost:8080/users/'

//Nav Bar
fetch(url1)
    .then(res => { res.json().then(
        user=>{
            let navBar = ""
            navBar += "<b class=\"text-white\">"+user.email+"</b>"
            navBar += "<span class=\"text-white\"> with roles: </span>"
            navBar += "<span class=\"text-white\">"
            user.roles.forEach((role) => navBar += role.role.replace('ROLE_','')+' ')
            navBar += "</span>"
            document.getElementById("navBar").innerHTML = navBar
        }
    )
    })

//Admin Panel
let table = ""

const showTable = (users) => {
    users.forEach((user)=> {
        table += `
                <tr id="${user.id}">
                    <td>${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.age}</td>
                    <td>${user.email}</td>
                    <td>`

        user.roles.forEach((role) => table += role.role.replace('ROLE_','')+" ")

        table += `
                    </td>
                    <td><button class="btn btn-info eBtn" data-toggle="modal">Edit</button></td>
                    <td><button class="btn btn-danger dBtn" data-toggle="modal">Delete</button></td>
                 `
    })
    document.getElementById("tableAllUsers").innerHTML = table
}

fetch(url2)
    .then( response => response.json())
    .then(data => showTable(data))

const on = (element, event, selector, handler) => {
    element.addEventListener(event, e => {
        if(e.target.closest(selector)){
            handler(e)
        }
    })
}

//Add new user
addNewUser.addEventListener('submit', (e) => {
    e.preventDefault()
    const rolesList = document.querySelector('#roles')
    const rolesListSelected = [].filter
        .call(rolesList.options, option => option.selected)
        .map(option => option.text)

    fetch('http://localhost:8080/users', {
        method: 'POST',
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify({
            firstName:firstName.value,
            lastName:lastName.value,
            age:age.value,
            email:email.value,
            password:pass.value,
            roles: rolesListSelected
        })
    })
        .then(response => response.json())
        .then(data => {
            const addUser = []
            addUser.push(data)
        })
})

//Edit Modal
on(document, 'click', '.eBtn', e => {
    const line1 = e.target.parentNode.parentNode
    const id1 = line1.children[0].innerHTML
    const firstName1 = line1.children[1].innerHTML
    const lastName1 = line1.children[2].innerHTML
    const age1 = line1.children[3].innerHTML
    const email1 = line1.children[4].innerHTML

    idEdit.value = id1
    firstNameEdit.value = firstName1
    lastNameEdit.value = lastName1
    ageEdit.value = age1
    emailEdit.value = email1
    $('#editModal').modal()
})

editModal.addEventListener('submit', (e) => {
    e.preventDefault()
    const rolesList = document.querySelector('#rolesEdit')
    const rolesListSelected = [].filter
        .call(rolesList.options, option => option.selected)
        .map(option => option.text)

    let formDataEdit = new FormData()
    formDataEdit.append('text', JSON.stringify({
        id:idEdit.value,
        firstName:firstNameEdit.value,
        lastName:lastNameEdit.value,
        age:ageEdit.value,
        email:emailEdit.value,
        password:passEdit.value,
    }))
    formDataEdit.append('text', JSON.stringify(rolesListSelected))
    fetch(url2, {
        method: 'PATCH',
        headers: {
            'Content-Type':'application/json'
        },
        body: formDataEdit
    })
        .then(response => response.json())
        .then(data => {
            const editUser = []
            editUser.push(data)
        })

})

//Delete Modal
on(document, 'click', '.dBtn', e => {
    const line2 = e.target.parentNode.parentNode
    const id2 = line2.children[0].innerHTML
    const firstName2 = line2.children[1].innerHTML
    const lastName2 = line2.children[2].innerHTML
    const age2 = line2.children[3].innerHTML
    const email2 = line2.children[3].innerHTML
    idDelete.value = id2
    firstNameDelete.value = firstName2
    lastNameDelete.value = lastName2
    ageDelete.value = age2
    emailDelete.value = email2
    $('#deleteModal').modal()
})

deleteModal.addEventListener('submit', (e) => {
    fetch(url3+idDelete.value, {
        method: 'DELETE'
    })
        .then(res => res.json())
        .then(() => location.reload())
})