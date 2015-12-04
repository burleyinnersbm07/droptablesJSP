<%-- 
    Document   : createRecord
    Created on : Nov 3, 2015, 5:19:26 PM
    Author     : John Phillips
--%>

<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalTime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Bug Tracking System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="mystyle.css">
        <link href='https://fonts.googleapis.com/css?family=Inconsolata:400,700|Titillium+Web:400,400italic' rel='stylesheet' type='text/css'>
        <!-- JQuery UI code to implement a datepicker control -->
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script>
            
        </script>
    </head>
    <body>
        <h1><a href="home.html">Bug Tracking System</a></h1>
        <h2>Submit New Bug Report</h2>
        <form action="create" method="get">

            <!-- Used the new HTML5 email type to force the user to enter an email address.-->
            Game: 
            <select name="game">
                <option value="">Select Game</option>
                <option value="fallingSkies">fallingSkies</option>
                <option value="ShapeChaser">ShapeChaser</option>
                <option value="invadersFrom">invadersFrom</option>
                <option value="pet_cemetary">pet_cemetary</option>
            </select>
            <br><br>

            <!-- Used the new HTML5 number type to force the user to enter a number.-->
            Operating System: 
            <select name="operatingsystem">
                <option value="">Select OS</option>
                <option value="Windows 7">Windows 7</option>
                <option value="Windows 8/8.1">Windows 8/8.1</option>
                <option value="Windows 10">Windows 10</option>
                <option value="Linux/Unix">Linux/Unix derivative</option>
                <option value="OSx">OSx</option>
            </select>
            <br><br>

            Python Version: <input type="text" name="pythonversion" size="30"
                                   placeholder="Enter python version">
            <br><br>

            <!-- Used the new HTML5 time type and the new Java8 LocalTime.now() to grab the current time.-->
            <!-- This is somewhat experimental; we might be better off just using a type='text' control.-->
            Bug Description: <br>
            <textarea  name="problemdesc" maxlength="500" cols="60" rows="6" placeholder="Describe the bug or problem."></textarea>

            <br><br>

            Notes:<br>
            <textarea  name="notes" maxlength="500" cols="60" rows="6" placeholder="Additional information: computer configurations, special settings, or anything out you think would be useful!"></textarea>
            <br><br>

            <input type="hidden" name="action" value="createRecord">

            <input type="submit" name="submit" value="Submit">
            <br><br>
        </form>
    </body>
</html>

