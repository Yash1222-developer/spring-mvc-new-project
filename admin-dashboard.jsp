<%@ include file="base.jsp" %>
<div class="container mt-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>Admin Dashboard</h2>
        <a href="${pageContext.request.contextPath}/admin/product/add" class="btn btn-success">Add Product</a>
        <a href="${pageContext.request.contextPath}/admin/logout" class="btn btn-danger">Logout</a>
    </div>
    
    <div class="table-responsive shadow-sm">
        <table class="table table-striped table-hover">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Image</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${products}">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.name}</td>
                        <td>₹${p.price}</td>
                        <td>
                            <img src="${pageContext.request.contextPath}/images/${p.imagePath}" width="80" height="60" class="rounded"/>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/admin/product/edit/${p.id}" class="btn btn-warning btn-sm">Edit</a>
                            <a href="${pageContext.request.contextPath}/admin/product/delete/${p.id}" class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%@ include file="footer.jsp" %>
