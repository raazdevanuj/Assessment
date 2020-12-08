<%@page import="com.beans.users"%>
<%@page import="com.daos.users_queryDao"%>
<%--<%@page import="java.util.Scanner"%>--%>
<%--<%@page import="org.apache.http.HttpResponse;"%>
<%@page import="org.apache.http.client.methods.HttpPost;"%>
<%@page import="org.apache.http.impl.client.CloseableHttpClient"%>
<%@page import="org.apache.http.impl.client.HttpClients"%>--%>
<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
        <style>
            .form-control-borderless {
                border: none;
            }

            .form-control-borderless:hover, .form-control-borderless:active, .form-control-borderless:focus {
                border: none;
                outline: none;
                box-shadow: none;
            }
        </style>
    </head>
    <body>
        <%
            int id;
            if (session.getAttribute("user") == null) {
                response.sendRedirect("index.jsp");
                return;
            } else {
                users user = (users) session.getAttribute("user");
                id = user.getUser_id();
            }
        %>
        <jsp:useBean class="com.beans.users" id="usee" scope="session"></jsp:useBean>
        <jsp:setProperty name="user" property="*"></jsp:setProperty>
            <br><br>
            <div class="row justify-content-center">
            <div class="col-md-6 center"> 
                <h3 class="text-center text-info">Welcome ${user.user_name} </h3>
            </div>
            <div class="col-md-10"></div> 
            <div class="col-md-2">
                <a class="btn btn-primary col-md-6 center" href="signout.jsp">Logout</a>
            </div>
            </div>
        <br>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-md-10">
                    <form class="card card-sm" action="./URLFetch_Controller"method="Get">
                        <div class="card-body row no-gutters align-items-center">
                            <div class="col-auto">
                                <i class="fas fa-search h4 text-body"></i>
                            </div>
                            <!--end of col-->
                            <div class="col">
                                <input class="form-control form-control-lg form-control-borderless" type="search" id="URL" name="URL" placeholder="URL">
                            </div>
                            <!--end of col-->
                            <div class="col-auto">
                                <button class="btn btn-lg btn-success" type="submit">Submit</button>
                            </div>
                            <!--end of col-->

                        </div>

                    </form>
                    <% if (request.getAttribute("server_string") != null) {%> 
                    <div class="row justify-content-center">
                        <div class="col-12 col-md-12">
                            <form class="card card-sm">
                                <div class="card-header">
                                    <label  class="form-control form-control-lg form-control-borderless text-center "><%out.println(request.getAttribute("url"));%></label>
                                </div>
                                <div class="card-body row no-gutters align-items-center"> 
                                    <div class="col">
                                        <textarea  class="form-control form-control-lg form-control-borderless"   rows="8" cols="60">
                                            <%out.println(request.getAttribute("server_string"));%>
                                        </textarea>
                                    </div>
                                </div>
                            </form>
                            <%users_queryDao uqd = new users_queryDao();
                                String url = (String) request.getAttribute("url");
                                String content = (String) request.getAttribute("server_string");
                                if (uqd.add(url, content, id)) {
                                    out.println("<script>alert('URL and content saved');</script>");
                                } else {
                                    out.println("<script>alert('URL and content not saved');</script>");
                                }
                            %>            
                        </div>
                    </div>
                    <%}%>
                </div>

            </div>
        </div>
    </body>
</html>