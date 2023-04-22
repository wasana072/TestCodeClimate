<%-- 
    Document   : chat.jsp
    Created on : Mar 28, 2023, 11:53:49 AM
    Author     : Wasana Ngaogate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.ResponseText" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ACIIDS2023</title>
        <link rel="stylesheet" href="style_chat.css">
    </head>

    <body>
        <h3>Chat with Bots</h3>
        <div class="container">

           
            <!--show user's chat-->
            <img src="logoMe.png" alt="Avatar" style="width:100%;">
            <p><%= request.getAttribute("sendText")%></P>

            <!--
                show area of ChatBots
            --> 
            <%  
                List<ResponseText> responseTexts = (List<ResponseText>) request.getAttribute("responseTexts");
                String logo;
                String responseText;
                for (ResponseText rt : responseTexts) {
                    logo =  rt.getLogo();
                    responseText = rt.getResponseText();
            %>
                    
            <img src="<%=logo %>" alt="Avatar" style="width:100%;">
            <p><%=responseText%></p>            
            <%
                }
                request.removeAttribute("sendText");
                request.removeAttribute("responseTexts");
            %>

        </div>

        <!--
            input area of user
        -->
        <div class="container">
            Let's say something:
            <form action="ChatServlet" method="post" accept-charset="UTF-8">
                <textarea name="sendText" rows="4" cols="50"></textarea>
                <input type="submit" value="send">
            </form>
        </div>

    </body>
</html>
