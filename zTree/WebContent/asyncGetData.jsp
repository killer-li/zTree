<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>异步加载数据</title>
    
	<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">  
    <script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>  
    <script type="text/javascript" src="js/jquery.ztree.core-3.5.js"></script>  
    <script type="text/javascript" src="js/jquery.ztree.excheck-3.5.js"></script>  
    <script type="text/javascript" src="js/jquery.ztree.exedit-3.5.js"></script>  
    <script type="text/javascript">
		var setting = {
			async : {
				enable : true,
				autoParam : ["id", "name"],
				dataType : "text",
				dataFilter : filter,
				type : "post",
				url : "getDataAsync"
			},
			data : {
				simpleData : {
					enable : true,
					idKey : "id",
					pIdKey : "pId",
					rootPId : "0"
				}
			},
			view : {
				expandSpeed : "fast",
				selectedMulti : false,
				showLine: false,
				dblClickExpand: true
			},
			callback: {
				beforeClick: zTreeBeforeClick,
				onAsyncSuccess: zTreeOnAsyncSuccess,
				onAsyncError: zTreeOnAsyncError
			}
		};
		
		function filter(treeId, parentNode, childNodes) {  
            if (!childNodes) return null;  
            for (var i=0, l=childNodes.length; i<l; i++) {  
                childNodes[i].name = childNodes[i].name.replace('','');  
            }  
            return childNodes;  
        } 
		
		var zNodes = [
			{id:0,name:"根", isParent:true},
			{id:1,pId:0,name:"书籍", isParent:true},
			{id:2,pId:0,name:"服装", isParent:true}
		];
		
		function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
		   //alert(msg);
		}
		
		function zTreeOnAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
		    alert(XMLHttpRequest);
		}
		
		function zTreeBeforeClick(treeId, treeNode, clickFlag) {
			var zTree = $.fn.zTree.getZTreeObj("tree");
			if(treeNode.isParent) {
				zTree.expandNode(treeNode);
				return false;
			} else {
				$("#testIframe").attr("src", treeNode.file + "?name=" + treeNode.name);
				return true;
			}
		}
		
		$(document).ready(function(){
			//$.fn.zTree.init($("#tree"), setting, zNodes);
			$.fn.zTree.init($("#tree"), setting);
		});	
	</script>
  </head>
  
  <body>
    <TABLE border=0 height=600px align=left>
	<TR>
		<TD width=260px align=left valign=top style="BORDER-RIGHT: #999999 1px dashed">
			<ul id="tree" class="ztree" style="width:260px; overflow:auto;"></ul>
		</TD>
		<TD width=770px align=left valign=top>
			<IFRAME ID="testIframe" Name="testIframe" FRAMEBORDER=0 SCROLLING=AUTO width=100%  height=600px SRC="content.jsp"></IFRAME></TD>
	</TR>
</TABLE>
	<form action="getDataAsync" method="post">
		<input type="text" name="test"/>
		<input type="submit"/>
	</form>
  </body>
</html>
