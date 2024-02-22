<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<form action="servlet1" method="post">
    Name:<input type="text" name="username"/><br/><br/>
    Password:<input type="password" name="userpass"/><br/><br/>
    <input type="submit" value="login"/>
    <%--   Form action = servlet1  -> Lorsque le bouton de submit est cliqué, une requête
     de type "post" ayant comme champs username et userpass sera envoyée au servlet1 --%>
</form>

</body>
</html>