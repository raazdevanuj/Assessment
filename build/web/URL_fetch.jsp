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
    <jsp:useBean class="com.beans.users" id="usee" scope="session"></jsp:useBean>
    <jsp:setProperty name="user" property="*"></jsp:setProperty>
        <br><br>
        <div class="row justify-content-center">
            <div class="col-md-6 center">  <h3 class="text-center text-info">Welcome ${user.user_name} </h3></div></div><br><br><br>
        <div class="container">
            <br/>
            <div class="row justify-content-center">
                <div class="col-12 col-md-10">
                    <form class="card card-sm">
                        <div class="card-body row no-gutters align-items-center">
                            <div class="col-auto">
                                <i class="fas fa-search h4 text-body"></i>
                            </div>
                            <!--end of col-->
                            <div class="col">
                                <input class="form-control form-control-lg form-control-borderless" type="search" placeholder="URL">
                            </div>
                            <!--end of col-->
                            <div class="col-auto">
                                <button class="btn btn-lg btn-success" type="submit">Submit</button>
                            </div>
                            <!--end of col-->
                        </div>
                    </form>
                </div>
                <!--end of col-->
            </div>
        </div>
    </body>
</html>