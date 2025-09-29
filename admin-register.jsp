<%@ include file="base.jsp" %>
<div class="row justify-content-center mt-5">
    <div class="col-md-5">
        <div class="card shadow">
            <div class="card-header bg-success text-white">
                <h3 class="text-center">Admin Registration</h3>
            </div>
            <div class="card-body">
                <form action="${pageContext.request.contextPath}/admin/register" method="post">
                    <div class="mb-3">
                        <label>Email</label>
                        <input type="email" name="email" class="form-control" value="${admin.email}" required>
                    </div>
                    <div class="mb-3">
                        <label>Password</label>
                        <input type="password" name="password" class="form-control" required>
                    </div>
                    <button class="btn btn-success w-100">Register</button>
                </form>
                <c:if test="${not empty error}">
                    <p class="text-danger mt-2">${error}</p>
                </c:if>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
