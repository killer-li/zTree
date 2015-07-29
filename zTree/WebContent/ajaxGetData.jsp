<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ajax get Data</title>
		<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
		<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="js/jquery.ztree.core-3.5.js"></script>
		<script type="text/javascript">
			var setting = {
				view : {
					dblClickExpand : true,
					showLine : false,
					selectedMulti : false
				},
				data : {
					simpleData : {
						enable : true,
						idKey : "id",
						pIdKey : "pId",
						rootPId : ""
					}
				}
			};
			var zNodes = [
				{id:1, pId:0, name:"基本功能演示", open:true},
				{id:101, pId:1, name:"基本功能演示11", file:"hao123.com"},
				{id:102, pId:1, name:"基本功能演示12", file:"baidu.com"},
				
				{id:2, pId:0, name:"基本功能演示"},
				{id:101, pId:2, name:"基本功能演示21", file:"hao123.com"},
				{id:102, pId:2, name:"基本功能演示22", file:"baidu.com"}
			];
			
			
			$(document).ready(function(){
				$.ajax({
					type: "post",
					url:"ajaxData",
					async:false,
					cache:false,
					dataType: "json", 
                    success: function (data) { 
                    	zNodes = data;
                    },
                    error: function () { 
                    	alert("error!!!");
                    } 
				});
				
				$.fn.zTree.init($("#tree"), setting, zNodes);
				var zTree = $.fn.zTree.getZTreeObj("tree");
				zTree.selectNode(zTree.getNodeByParam("id", "202"));
			});		
		</script>
	</head>
	<body>
		<ul id="tree" class="ztree" style="width:260px; overflow:auto;"></ul>
	</body>
</html>