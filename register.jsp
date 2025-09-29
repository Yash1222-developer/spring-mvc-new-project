<%@ include file="base.jsp" %>
<h2>Register</h2>
    <form action="${pageContext.request.contextPath}/register" method="post" class="w-50 mx-auto">
        <div class="mb-3">
            <label>Name</label>
            <input type="text" name="name" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Email</label>
            <input type="email" name="email" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Password</label>
            <input type="password" name="password" class="form-control" required>
        </div>
        <button class="btn btn-success">Register</button>
    </form>
    <%@ include file="footer.jsp" %>
