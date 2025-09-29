<%@ include file="base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Checkout</h2>
<p>Review your order and proceed with payment (dummy).</p>

<table class="table table-bordered mt-3">
    <thead>
        <tr>
            <th>Product</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="item" items="${cartList}">
            <tr>
                <td>${item.productName}</td>
                <td>₹${item.price}</td>
                <td>${item.quantity}</td>
                <td>₹${item.total}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<a href="${pageContext.request.contextPath}/orders/placeAll" class="btn btn-success">Confirm Order</a>
<%@ include file="footer.jsp" %>
