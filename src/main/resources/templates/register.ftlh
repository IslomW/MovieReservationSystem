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

<div class="email-container">
    <div class="email-container">
        <div class="header">Welcome to our service!</div>

        <div class="content">
            <h2>Hello, ${name}!</h2>

            <p>Thank you for registering. We are glad that you have joined our community!</p>

            <p>Your login details:</p>
            <ul>
                <li><strong>Email:</strong> ${email}</li>
                <li><strong>Date of registration:</strong> ${registrationDate}</li>
            </ul>

            <p>To activate your account, please follow the link below:</p>
            <p><a href="${activationLink}" class="button">Activate account</a></p>
        </div>

        <div class="footer">
            © 2024 Movie Reservation System. All rights reserved.
        </div>
    </div>
</div>


<#--<div id="body">-->
<#--    <div id="div">-->
<#--        <h1>Registration</h1>-->
<#--        <p>Hello, ${name}!</p>-->
<#--        <p>This is registration mail. You can log in and use Movie Reservation app.</p>-->
<#--        <p>With best regards, <br> Sharipov Islombek</p>-->
<#--    </div>-->
<#--</div>-->
</body>

</html>