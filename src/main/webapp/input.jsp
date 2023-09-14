<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        fieldset {
            width: 300px;
            margin: auto;
            border: 1px solid rgb(0, 132, 255);
            text-align: center;
        }

        .text {
            width: 90%;
            height: 30px;
            padding: 5px;
            margin: 5px;
        }

        #submit {
            border: none;
            font-size: 20px;
            width: 48%;
            margin: auto;
            margin-top: 5px;
            background-color: rgb(214, 231, 248);
            cursor: pointer;
        }

        #submit:hover {
            background-color: skyblue;

        }
    </style>
</head>

<body>
    <form action="/save.contacts" method="post">
        <fieldset>
            <legend>Input Contact</legend>
            <input type="text" name="writer" placeholder="작성자 명을 입력해주세요." class="text">
            <input type="text" name="message" placeholder="메세지를 입력해주세요." class="text"><br>
            <input type="submit" id="submit" value="save" class="submit" />
            <input type="button" id="submit" value="back" class="back" />
        </fieldset>
    </form>
   	<script>
   	$(document).ready(function () {
        $(".back").click(function () {
            window.location.href = "/index.jsp";
        });
    });
   	</script>
</body>

</html>