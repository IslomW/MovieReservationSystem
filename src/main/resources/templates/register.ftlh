<#ftl encoding="UTF-8">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>
        Thank you for registration, ${name}
    </title>
    <style>
        #body {
            display: flex;
            flex-direction: column;
            font-family: "Segoe UI", serif;
            align-items: center;
            background-color: deepskyblue;
            font-size: 20px;
            height: 100%;
        }

        #div{
            display: block;
            flex-direction: column;
            margin: 10%;
            font-family: "Segoe UI", serif;
            background-color: white;
            padding: 3%;
            border-radius: 20px;
            color: #000;
        }
    </style>
</head>

<body>
<div id="body">
    <div id="div">
        <h1>Registration</h1>
        <p>Hello, ${name}!</p>
        <p>This is registration mail. You can log in and use task list app.</p>
        <p>With best regards, <br> Sharipov Islombek</p>
    </div>
</div>
</body>

</html>