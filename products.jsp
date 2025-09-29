<%@ include file="base.jsp" %>

<h2 class="mb-4">Available Products</h2>
<div class="row">
    <c:forEach var="product" items="${productList}">
        <div class="col-md-4 mb-4">
            <div class="card h-100">
                <img src="${pageContext.request.contextPath}/images/${product.imagePath}" class="card-img-top" alt="${product.productName}">
                <div class="card-body">
                    <h5 class="card-title">${product.productName}</h5>
                    <p class="card-text">${product.description}</p>
                    <p class="card-text"><strong>₹${product.price}</strong></p>
                    <a href="${pageContext.request.contextPath}/cart/add?productId=${product.productId}" class="btn btn-success">Add to Cart</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<%@ include file="footer.jsp" %>
