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
            <#if (user.imageURL)??>
                <img src="${user.imageURL}" width="200"/>
            </#if>
            <p><a href="/edit-user?id=${user.id}">Edit user</a> </p>
            <#sep><p>=======================</p></#sep>
        </#items>
    </ul>
</#list>
</body>
</html>