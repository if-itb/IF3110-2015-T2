<!-- Tugas 2 IF3110 Pengembangan Aplikasi Berbasis Web
Membuat website tanya jawab seperti Stack Exchange dengan REST dan SOAP dan arsitektur berorientasi servis.
Author: 
- Irene Wiliudarsan (13513002)
- Angela Lynn       (13513002)
- Devina Ekawati    (13513002) -->
<!-- File: register.jsp -->

<!DOCTYPE html>
<html>
  <head>
    <title>Log in</title>
    <meta charset="utf-8"/>
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
  </head>
  <body>
    <!-- Title -->
    <div class="title">
      <a href="index.jsp">
        StackExchange
      </a>
    </div>

    <!-- Question Form -->
    <div class="content">
      <div class="subtitle">
        Register
      </div>
      <form class="right" id="register-form" action="index.jsp" method="post">
        <input class="full-length" id="register-name" name="register-name" type="text" placeholder="Name">
        <input class="full-length" id="register-email" name="register-email" type="email" placeholder="Email">
        <input class="full-length" id="register-password" name="register-topic" type="password" placeholder="Password">
        <input class="button" name="register-submit" type="submit" value="Register">
      </form>
    </div>

    <!-- JavaScript -->
    <script src="js/script.js"></script>
  </body>
</html>
