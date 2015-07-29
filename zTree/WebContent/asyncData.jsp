<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>  
	<HEAD>  
    <TITLE> ZTREE DEMO - Simple Data</TITLE>  
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">  
    <link rel="stylesheet" href="css/demo.css" type="text/css">  
    <link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">  
    <script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>  
    <script type="text/javascript" src="js/jquery.ztree.core-3.5.js"></script>  
    <script type="text/javascript" src="js/jquery.ztree.excheck-3.5.js"></script>  
    <script type="text/javascript" src="js/jquery.ztree.exedit-3.5.js"></script>  
    <SCRIPT type="text/javascript">  
        var setting = {  
            data: {  
                simpleData: {  
                    enable: true  
                }  
            }  
            ,async: {  
                enable: true,  
                url:"getData",  
                autoParam:["id", "name"],  
                otherParam:{"otherParam":"zTreeAsyncTest"},  
                dataFilter: filter  
            }  
        };  
        function filter(treeId, parentNode, childNodes) {  
            if (!childNodes) return null;  
            for (var i=0, l=childNodes.length; i<l; i++) {  
                childNodes[i].name = childNodes[i].name.replace('','');  
            }  
            return childNodes;  
        }  
        var zNodes =[  
            { id:1, pId:0, name:"parentNode 1", open:true},  
            { id:11, pId:1, name:"parentNode 11"},  
            { id:111, pId:11, name:"leafNode 111"},  
            { id:112, pId:11, name:"leafNode 112"},  
            { id:113, pId:11, name:"leafNode 113"},  
            { id:114, pId:11, name:"leafNode 114"},  
            { id:12, pId:1, name:"parentNode 12"},  
            { id:121, pId:12, name:"leafNode 121"},  
            { id:122, pId:12, name:"leafNode 122"},  
            { id:123, pId:12, name:"leafNode 123"},  
            { id:13, pId:1, name:"parentNode 13", isParent:true},  
            { id:2, pId:0, name:"parentNode 2", isParent:true}  
        ];  
  
        $(document).ready(function(){  
            $.fn.zTree.init($("#treeDemo"), setting, zNodes);  
        });  
    </SCRIPT>  
 </HEAD>  
  
<BODY>  
<h1>最简单的树 -- 简单 JSON 数据</h1>  
<h6>[ 文件路径: core/simpleData.html ]</h6>  
<div class="content_wrap">  
    <div class="zTreeDemoBackground left">  
        <ul id="treeDemo" class="ztree"></ul>  
    </div>  
</div>  
</BODY>  
</HTML>  