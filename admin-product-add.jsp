<%@ include file="base.jsp" %>
<div class="row justify-content-center mt-5">
    <div class="col-md-6">
        <div class="card shadow">
            <div class="card-header bg-info text-white text-center">
                <h3>Add Product</h3>
            </div>
            <div class="card-body">
                <form action="${pageContext.request.contextPath}/admin/product/save" method="post" enctype="multipart/form-data">
                    <div class="mb-3">
                        <label>Product Name</label>
                        <input type="text" name="name" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label>Price</label>
                        <input type="number" name="price" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label>Image</label>
                        <input type="file" name="image" class="form-control" required>
                    </div>
                    <button class="btn btn-info w-100">Upload Product</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
