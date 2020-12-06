<% if (request.getAttribute("server_string") != null) {%> 
                    <div class="row justify-content-center">
                        <div class="col-12 col-md-12">
                            <form class="card card-sm">
                                <div class="col">
                                 <%%>
                            </div>
                                <div class="card-body row no-gutters align-items-center"> 
                                    <div class="col">
                                        <textarea  class="form-control form-control-lg form-control-borderless"   rows="8" cols="60">
                                            <%out.println(request.getAttribute("server_string"));%>
                                        </textarea>
                                    </div>
                                </div>
                            </form>

                        </div>
                    </div>
                    <%}%>