<%@ include file="base.jsp" %>
<div class="row justify-content-center mt-5">
    <div class="col-md-5">
        <div class="card shadow">
            <div class="card-header bg-primary text-white text-center">
                <h3>Admin Login</h3>
            </div>
            <div class="card-body">
                <form action="${pageContext.request.contextPath}/admin/login" method="post">
                    <div class="mb-3">
                        <label>Email</label>
                        <input type="email" name="email" class="form-control" value="${admin.email}" required>
                    </div>
                    <div class="mb-3">
                        <label>Password</label>
                        <input type="password" name="password" class="form-control" required>
                    </div>
                    <button class="btn btn-primary w-100">Login</button>
                </form>

                <c:if test="${not empty error}">
                    <p class="text-danger mt-2">${error}</p>
                </c:if>

                <hr>
                <p class="text-center">Don't have an account? 
                    <a href="${pageContext.request.contextPath}/admin/register" class="btn btn-success btn-sm">Register</a>
                </p>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
