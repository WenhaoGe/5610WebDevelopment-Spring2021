var $usernameFld, $passwordFld;
var $firstNameFld, $lastNameFld, $roleFld;
var $updateBtn, $createBtn;
var $userRowTemplate;
var userService = new AdminUserServiceClient();

var users = []

function createUser() {

    let user = {
        username: $usernameFld.val(),
        password: $passwordFld.val(),
        firstname: $firstNameFld.val(),
        lastname: $lastNameFld.val(),
        role: $roleFld.val()
    }

    userService.createUser(user).then(function (actualUser) {
        users.push(actualUser)
        renderUsers(users)
    })
}

function deleteUser(event) {
    let button = $(event.target)
    let index = button.attr("id")
    let id = users[index]._id
    userService.deleteUser(id).then(function (status) {
        users.splice(index, 1)
        renderUsers(users)
    })
}

let selectedUser = null
function selectUser(event) {
    let id = $(event.target).attr("id")
    console.log(id)
    selectedUser = users.find(user => user._id === id)
    $usernameFld.val(selectedUser.username)
    $passwordFld.val(selectedUser.password)
    $firstNameFld.val(selectedUser.firstname)
    $lastNameFld.val(selectedUser.lastname)
    $roleFld.val(selectedUser.role)
}

function updateUser() {

    selectedUser.username = $usernameFld.val()
    selectedUser.password = $passwordFld.val()
    selectedUser.firstname = $firstNameFld.val()
    selectedUser.lastname = $lastNameFld.val()
    selectedUser.role = $roleFld.val()
    userService.updateUser(selectedUser._id, selectedUser).then(status => {
        let index = users.findIndex(user => user._id === selectedUser._id)
        users[index] = selectedUser
        renderUsers(users)
    })
}

function renderUsers(users) {
    $userRowTemplate.empty()
    for (let i = 0; i < users.length; i++) {
        let user = users[i]
        $userRowTemplate
            .prepend(`
            <tr>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.firstname}</td>
                <td>${user.lastname}</td>
                <td>${user.role}</td>
                <td>
                    <button id="${i}" class="neu-delete-btn">Delete</button>
                    <button id="${user._id}" class="wbdv-select-btn">Select</button>
                </td>
            </tr>
            `)
    }
    $(".neu-delete-btn").click(deleteUser)
    $(".wbdv-select-btn").click(selectUser)

}

function main() {

    $usernameFld = jQuery("#usernameFld")
    $userRowTemplate = jQuery("#wbdv-tbody")
    $createBtn = $(".jga-create-btn")
    $passwordFld = $("#passwordFld")
    $firstNameFld = $("#firstNameFld")
    $lastNameFld = $("#lastNameFld")
    $roleFld = $("#roleFld")
    $updateBtn = $(".wbdv-update-btn")
    $updateBtn.click(updateUser)
    $createBtn.click(createUser)
    userService.findAllUsers().then(function (actualUsers) {
        users = actualUsers
        renderUsers(users)
    })
}

$(main)