<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>收货登记</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/maple.css'/>"></link>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/jquery-ui-1.10.4.min.css'/>"></link>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.js"></script>
	
<script type="text/javascript">
	$(function() {
		
		// 获取仓库
		$.post("${pageContext.request.contextPath}/store_ajaxList.action", {},
				function(data) {
					$select = $("#selectOption")
					for (var i = 0; i < data.length; i++) {
						var $option = $("<option value='" + data[i].id + "'> "
								+ data[i].name + "</option>");
						$select.append($option);
					}
				})
		$("input[name='name']").autocomplete({
			source:function(request, response) {
        // 获取用户当前输入的字符
        var term = request.term;
        console.log(term);
        $.post("goods_findNameLike", {name: term}, function(data){
            // 回显数据
            response(data);
        })
    },
      // 选择补全列表回显 
      select: function(event, ui){
    	    // ui.item可以是 source 绑定数组的某个元素
          // ui.item.value 返回选中值
               $("#goodsId").val(ui.item.id); 
	             $("input[name='nm']").val(ui.item.nm);
	             $("input[name='unit']").val(ui.item.unit);
	             $("#storeSelect").val(ui.item.store.id);
    	  }
		});
		
		// 根据简记码 获取货物 
    $("input[name='nm']").blur(function(){
    	if($(this).val()!="") {
	    	$.post("${pageContext.request.contextPath}/goods_findByNm.action", {"nm": $(this).val()}, function(data){
	         if(data) {
	             // 查询到货物
               $("#goodsId").val(data.id);
	             $("input[name='nm']").val(data.nm);
	             $("input[name='name']").val(data.name);
	             $("input[name='unit']").val(data.unit);
	             $("#storeSelect").val(data.store.id); // 通过val函数, 使选中
	         } else {
	        	              // 清空表单, 但是不能隐藏域
	             $("#goodsId").val("");
	             $("input[name='name']").val("");
	             $("input[name='unit']").val("");
	
	         }
	     });	
    	}
    });
		
	});

</script>
<style type="text/css">
.tx td {
	padding: 3px;
}
</style>
</head>
<body>
	<!-- 中间内容（开始） -->
	<table border="0" class="tx" width="100%">
		<tr>
			<td>当前位置&gt;&gt;首页&gt;&gt;入库</td>
		</tr>
	</table>
	<br>
	<table border="0" width="100%" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td rowspan="2">
				<form action="<c:url value='/jsps/store/remain.jsp'/>" method="post"
					name="select">
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						class="tx" align="center">
						<colgroup>
							<col width="20%" align="right">
							<col width="*%" align="left">
						</colgroup>
						<tr>
							<td bgcolor="a0c0c0" style="padding-left: 10px;" colspan="2"
								align="left"><b>货物入库登记：</b></td>
						</tr>
						<tr>
							<td>简记码：</td>
							<td>
							<s:hidden id="goodsId" cssClass="tx" name="id"></s:hidden>							

							<s:textfield cssClass="tx" name="nm" id="nm" ></s:textfield>
								</td>
						</tr>
						<tr>
							<td>货物名称：</td>
							<td>
							<s:textfield cssClass="tx" name="name"></s:textfield>
							</td>
						</tr>
						<tr>
							<td>计量单位：</td>
							<td>
							<s:textfield cssClass="tx" name="unit" ></s:textfield>
							</td>
						</tr>
						<tr>
							<td>入库数量：</td>
							<td>
														<s:textfield cssClass="tx" name="amount" ></s:textfield>
								</td>
						</tr>
						<tr>
							<td>选择仓库：</td>
							<td>
							<select class="tx" style="width: 120px;" name="storeid" id="selectOption">

							</select> (此信息从数据库中加载)</td>
						</tr>
						<tr>
							<td colspan="2" align="center" style="padding-top: 10px;"><input
								class="tx" style="width: 120px; margin-right: 30px;"
								type="button" onclick="document.forms[0].submit();" value="入库">
								<input class="tx" style="width: 120px; margin-right: 30px;"
								type="reset" value="取消"></td>
						</tr>
					</table>
				</form>
			</td>
			<td valign="top" width="20%">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td background="<c:url value='/picture/loginpage.gif'/>"
							align="center"><br> <font color="red">操作步骤</font></td>
					</tr>
					<tr>
						<td background="<c:url value='/picture/bg1.jpg'/>"
							style="padding-left: 10px;">1.输入简记码从数据库<br />查询是否已经存在此 <br />货物
							<br /> 2.没有则直接输入货物名称 <br> 3.从数据库选择仓库 <br>
							4.向仓库中新添加或是追加货物 <br /> 5.记录入库历史记录
						</td>
					</tr>
					<tr>
						<td><img src="<c:url value='/picture/bottom.jpg'/>"></td>
					</tr>
				</table>
		</tr>
	</table>
</body>
</html>