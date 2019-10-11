<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>向服务器发送请求</title>
<script type="text/javascript" src="${ pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body>
<h1>版本一</h1>
<%--
1.通过表单发送请求
2.通过链接发送请求
3.通过Ajax发起请求
4.通过JavaScript发起请求location.href="";
 --%>
 <hr/>
 <%--
 通过表单发送请求
  --%>
 <form method="post" action="${pageContext.request.contextPath}/StuServlet?method=addStu">
 	输入姓名:<input type="text" name="stuName"/><button>提交</button>
 </form>
 <hr/>
 <%--
 通过链接发送请求
  --%>
  <a href="${pageContext.request.contextPath}/StuServlet?method=delStu&stuId=s001">删除学生</a>
  <hr/>
<%--
 通过Ajax发送请求
  --%> 
  <button id="btn">修改学生</button>
  <hr/>
<%--
 通过JavaScript发送请求
  --%>
  <button id="btn02">查询学生</button>
  <hr/>
</body>

<script>
//页面加载完毕，为id为btn的按钮绑定点击事件，通过点击事件向服务端发起Ajax请求】
$(function(){
	//页面加载完毕
	//为id为btn的按钮绑定点击事件
	$("#btn").click(function(){
		$.post("/TestBaseServlet/StuServlet",{"method":"updateStu","stuId":"s002"},function(data){
			console.log(data);
		});
	});
	$("#btn02").click(function(){
		//通过点击事件向服务端发起，location.href=""
		location.href="/TestBaseServlet/StuServlet?method=findStu";
	});
	
});
</script>
</html>