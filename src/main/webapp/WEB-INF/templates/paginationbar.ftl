<script type="text/javascript">
	$(function(){
		$("input[value='go']").click(function(){
			var pageno = $("input[name='pageno']").val();
			var regexp = /^[0-9]+$/ ;
			if(regexp.test(pageno)){
				if(parseInt(pageno)>${totalPageCount}){
					alert("超出了最大页码！");
				}else{
					// 提交
					location.href = "${contextPath}/${pageQueryUrl}?pageno="+pageno+"&"+"${paramUrl}";
				}
			}else{
				// 不满足
				alert("跳转页码必须为整数！");
			}
		});
	});
</script>
<#-- 分页工具条 -->
<div align="right">
	<#-- 分页部分文字信息 --> 
	<span>总记录数 ： ${totalCount}条</span>
	<span>每页记录数： ${numberPerPage}条</span>
	<span>共${totalPageCount}页</span>
	<span>当前第${pageno}页</span>
	<#-- 首页 上一页-->
	<#if pageno==1>
		<#-- 当前页是第一页 -->
		<a>首页</a><a>上一页</a>
	<#else>
		<#-- 当前页不是第一页 -->
		<a href="${contextPath}/${pageQueryUrl}?pageno=1&${paramUrl}">首页</a>	
		<a href="${contextPath}/${pageQueryUrl}?pageno=${pageno-1}&${paramUrl}">上一页</a>	
	</#if>
	
	<#-- 页码 -->
	<#list begin..end as i>
		<#if pageno==i>
			<#-- 当前页码  -->
			<a>${i}</a>
		<#else>
			<#-- 不是当前页码-->
			<a href="${contextPath}/${pageQueryUrl}?pageno=${i}&${paramUrl}">${i}</a>	
		</#if>
	</#list>
	<#-- 下一页 尾页 -->
	<#if pageno==totalPageCount>
		<#--当前页已经是最后一页 -->
		<a>下一页</a><a>尾页</a>
	<#else>
		<#-- 不是最后一页 -->
		<a href="${contextPath}/${pageQueryUrl}?pageno=${pageno+1}&${paramUrl}">下一页</a>	
		<a href="${contextPath}/${pageQueryUrl}?pageno=${totalPageCount}&${paramUrl}">尾页</a>
	</#if>	
	
	<#-- 跳转 -->
	<input type="text" size="2" name="pageno"/>
	<input type="button" value="go" size="2" />
</div>
