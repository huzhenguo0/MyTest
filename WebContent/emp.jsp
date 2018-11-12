<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$("<div id='autocomplete' style='background-color:#FFFFFF;heigth:100px;weight:100px;z-index:2;position:absolute'></div >").hide().insertAfter("#second");
			});

			function autocomple() {
				var value = $("#search-text").val();
				if(value == '') {
					return;
				}
				$("#autocomplete").empty();
				$.ajax({
					url: "${pageContext.request.contextPath}/emp/find?text=" + value,
					type: "post",
					contentType: "application/json; charset=utf-8",
					dataType: "json",
					success: function(data, textStatus) {
						if(data != null || !"".equals(data)) {
							var str = "";
							$.each(data, function(n, obj) {
								$("#autocomplete").show();
								str = "<li>" + obj + "</li>";
								$("#autocomplete").append(str);
								$("li").click(function() {
									//当点击哪个列表时就把它的值load到输入框中
									$("#search-text").val($(this).text());
									$("#autocomplete").empty();
								});
							});
						}
					}
				});
			}
		</script>
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
				<div id="header">
					<div id="second">
						<form action="${pageContext.request.contextPath}/emp/search" method="post">
							<input type="text" name="text" id="search-text" value="" maxlength="200" onkeyup="autocomple()" />
							<input type="submit" value="搜索" />
						</form>
					</div>
					<div id="navigation"></div>
				</div>
				<div id="content" style="z-index:1">
					<p id="whereami"></p>
					<table class="table">
						<tr class="table_header">
							<td>ID</td>
							<td>Name</td>
							<td>Dept</td>
							<td>Message</td>
						</tr>
						<c:forEach var="emp" items="${sessionScope.findAll}" varStatus="status">
							<tr <c:if test="${status.count %2!=0}">class="row1"</c:if>
								<c:if test="${status.count %2==0}">class="row2"</c:if>>
								<td>${emp.id}</td>
								<td>${emp.name}</td>
								<td>${emp.dept}</td>
								<td>${emp.message}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</body>

</html>