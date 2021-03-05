<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<#list list as item>
    <tr>
        <td>商品名称：${item.name}</td>
        <td>商品价格：${item.quantity}</td>
    </tr>
    <br/>
</#list>
<br/>
<tr>
    <td>产地：${place}</td>
</tr>
</body>
</html>