<%@page import="java.math.BigInteger"%>
<%@page import="java.security.MessageDigest"%>
<%@page import="com.beans.users"%>
<%@page import="com.daos.userDao"%>
<html>
    <head> 
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <style>
body {
  margin: 0;
  padding: 0;
  background-color: #17a2b8;
  height: 100vh;
}
#login .container #login-row #login-column #login-box {
  margin-top: 120px;
  max-width: 600px;
  height: 320px;
  border: 1px solid #9C9C9C;
  background-color: #EAEAEA;
}
#login .container #login-row #login-column #login-box #login-form {
  padding: 20px;
}
#login .container #login-row #login-column #login-box #login-form #register-link {
  margin-top: -85px;
}
        </style>

    </head>
<body>
 <div id="login">
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="" method="post">
                            <h3 class="text-center text-info">Assessment Login</h3>
                            <div class="form-group">
                                <label for="username" class="text-info">Username:</label><br>
                                <input type="text" name="username" id="username"  required="required"class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <input type="password" name="password" id="password" required="required" class="form-control">
                            </div>
                            <div class="form-group">
                                 <input type="submit" name="submit" class="form-control btn btn-info btn-md" value="submit">
                            </div>
                            
                        </form>
                    </div>
                    <%
                     if (request.getParameter("submit") != null) {
                      String user_name = request.getParameter("username");
                    String temp= request.getParameter("password");
                    MessageDigest md = MessageDigest.getInstance("MD5"); 
			byte[] messageDigest = md.digest(temp.getBytes()); 
			BigInteger no = new BigInteger(1, messageDigest); 
			String hashtext = no.toString(16); 
			while (hashtext.length() < 32) { 
				hashtext = "0" + hashtext; 
			} 
			
                     userDao ud=new userDao();
                    users user=ud.valid_details(user_name, hashtext);
                    //  System.out.println(password);
                       
                        if (user!= null) {
                            session.setAttribute("user", user);
                             out.println("<script>alert('login successfully!');</script>");
                            out.println("<script>window.location='URL_fetch.jsp'</script>");
                            
                        } else {
                            out.println("<script>alert('Invalid Userid or Password');</script>");
                            out.println("<script>window.location='index.jsp'</script>");
                        }
                     }
                    %>
                </div>
            </div>
        </div>
    </div>
</body>
</html>