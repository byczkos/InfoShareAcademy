<!DOCTYPE html>
<html>
<head>
    <title> Users list. </title>
</head>
<body>
<#list users>
    <ul>
        <#items as user>
            <li><p>ID: ${user.id}</p></li>
            <li><p>Name: ${user.name}</p></li>
            <li><p>Login: ${user.login}</p></li>
            <li><p>Gender: ${user.gender}</p></li>
            <li><p>Age: ${user.age}</p></li>
            <#sep><p>=======================</p></#sep>
        </#items>
    </ul>
</#list>
</body>
</html>