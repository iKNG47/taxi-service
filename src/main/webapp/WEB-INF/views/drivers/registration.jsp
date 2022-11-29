<%--
  Created by IntelliJ IDEA.
  User: igor
  Date: 11.11.2022
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registration</title>
    <style>
        <%@include file='/WEB-INF/views/css/style.css' %>
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form  action="${pageContext.request.contextPath}/registration" method="post">
    <section class="vh-100 gradient-custom">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="card bg-dark text-white" style="border-radius: 1rem;">
                        <div class="card-body p-5 text-center">

                            <div class="mb-md-5 mt-md-4 pb-5">

                                <h2 class="fw-bold mb-5">Sign up now</h2>
                                <h3 class="errorMsg">${errorMessage}</h3>


                                <div class="form-outline form-white mb-4">
                                    <input type="text" id="typeEmailX"  name="name" class="form-control form-control-lg" required />
                                    <label class="form-label" for="typeEmailX" >Name</label>
                                </div>

                                <div class="form-outline form-white mb-4">
                                    <input type="text"  name="license number" id="typePasswordX" class="form-control form-control-lg" required />
                                    <label class="form-label" for="typePasswordX">License Number</label>
                                </div>

                                <div class="form-outline form-white mb-4">
                                    <input type="email"  name="login"  class="form-control form-control-lg" required />
                                    <label class="form-label" for="typePasswordX">Email</label>
                                </div>

                                <div class="form-outline form-white mb-4">
                                    <input type="password"  name="password"  class="form-control form-control-lg" required />
                                    <label class="form-label" for="typePasswordX">Password</label>
                                </div>

                                <button class="btn btn-outline-light btn-lg px-5" type="submit" >Sign Up</button>



                            </div>

                            <div>
                                <p class="mb-0">Already have an account? <a href="/login" class="text-white-50 fw-bold">Sign In</a>
                                </p>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</form>


</body>
</html>
