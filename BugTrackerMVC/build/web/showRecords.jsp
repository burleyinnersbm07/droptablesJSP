<%-- 
    Document   : displayRecords
    Created on : Nov 3, 2015, 4:52:40 PM
    Author     : John Phillips
--%>

<%@page import="java.util.List, model.Bug"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Bug Tracking System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="mystyle.css">
        <link href='https://fonts.googleapis.com/css?family=Inconsolata:400,700|Titillium+Web:400,400italic' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <h1><a href="home.html">Bug Tracking System</a></h1>
        <h2>All Bugs</h2>
        <!--
            //List<Bug> mydata = (List<Bug>) request.getAttribute("mydata");
            //out.println("<table>");
            //for (Bug bug : mydata) {
                //out.println(bug.inHTMLRowFormat());
            //}
            //out.println("</table>");
        %> -->
        <%
            List<Bug> fallingSkies = (List<Bug>) request.getAttribute("fallingSkies");
            out.println("<h3 style='color:rgb(150,150,150)'>fallingSkies Bugs</h3>");
            out.println("<table style='margin:0 auto; width=100%'>");
            out.println("<thead style='background-color: rgb(200, 200, 200)'><td>ID</td><td>OS</td><td>Python</td><td>Description</td><td>Notes</td></thead>");
            for (Bug bug : fallingSkies) {
                out.println(bug.inHTMLRowFormat());
            }
            out.println("</table>");
            
            List<Bug> ShapeChaser = (List<Bug>) request.getAttribute("ShapeChaser");
            out.println("<h3 style='color:rgb(150,150,150)'>ShapeChaser Bugs</h3>");
            out.println("<table style='margin:0 auto'>");
            out.println("<thead style='background-color: rgb(200, 200, 200)'><td>ID</td><td>OS</td><td>Python</td><td>Description</td><td>Notes</td></thead>");
            for (Bug bug : ShapeChaser) {
                out.println(bug.inHTMLRowFormat());
            }
            out.println("</table>");
            
            List<Bug> invadersFrom = (List<Bug>) request.getAttribute("invadersFrom");
            out.println("<h3 style='color:rgb(150,150,150)'>invadersFrom Bugs</h3>");
            out.println("<table style='margin:0 auto'>");
            out.println("<thead style='background-color: rgb(200, 200, 200)'><td>ID</td><td>OS</td><td>Python</td><td>Description</td><td>Notes</td></thead>");
            for (Bug bug : invadersFrom) {
                out.println(bug.inHTMLRowFormat());
            }
            out.println("</table>");
            
            List<Bug> pet_cemetary = (List<Bug>) request.getAttribute("pet_cemetary");
            out.println("<h3 style='color:rgb(150,150,150)'>pet_cemetary Bugs</h3>");
            out.println("<table style='margin:0 auto'>");
            out.println("<thead style='background-color: rgb(200, 200, 200)'><td>ID</td><td>OS</td><td>Python</td><td>Description</td><td>Notes</td></thead>");
            for (Bug bug : pet_cemetary) {
                out.println(bug.inHTMLRowFormat());
            }
            out.println("</table>");
        %>
    </body>
</html>
