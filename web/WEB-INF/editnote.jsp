<%-- 
    Document   : editnote
    Created on : Jun 7, 2021, 4:46:04 PM
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
        <h2>Edit Note</h2>
        <form method="POST">
            <label style="display:inline;">Title:</label>
            <input type="text" name="title_area" value="${note.title}">
            <br>
            <label style="display:inline;">Contents:</label>
            <textarea style="display:inline;" name="content_area">${note.contents}</textarea>
            <br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
