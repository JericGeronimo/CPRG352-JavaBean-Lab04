<%-- 
    Document   : viewnote
    Created on : Jun 7, 2021, 4:45:31 PM
    Author     : 855474
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <form method="GET">
            <h3 style="display:inline;">Title: </h3>
            <p style="display:inline;" name="title_area">${note.title}</p>
            <h3>Contents: </h3>
            <p name="content_area">${note.contents}</p>
            <a href="note?edit">Edit</a>
        </form>
    </body>
</html>
