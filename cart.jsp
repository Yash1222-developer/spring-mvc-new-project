<%@ include file="base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>My Cart</h2>
<table class="table table-bordered mt-3">
    <thead>
        <tr>
            <th>Product</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="item" items="${cartList}">
            <tr>
                <td>${item.productName}</td>
                <td>₹${item.price}</td>
                <td>${item.quantity}</td>
                <td>₹${item.total}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/cart/remove?productId=${item.productId}" class="btn btn-danger btn-sm">Remove</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<a href="${pageContext.request.contextPath}/checkout" class="btn btn-primary">Proceed to Checkout</a>
<%@ include file="footer.jsp" %>
