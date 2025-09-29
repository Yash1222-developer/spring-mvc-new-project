<%@ include file="base.jsp" %>

<h2>Login</h2>
<form action="${pageContext.request.contextPath}/login" method="post" class="w-50 mx-auto mt-4">
    <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="email" class="form-control" id="email" name="email" required>
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" class="form-control" id="password" name="password" required>
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
</form>

<%@ include file="footer.jsp" %>
