<#setting number_format="0.##">
{
	"sEcho":"${sEcho}",
	"iTotalRecords": "${page.totalCount}",
    "iTotalDisplayRecords": "${page.totalCount}",
    "aaData": [
    	<#if page.result?exists >
		    <#list page.result as x>
		    	[
		    		"${x.dept.deptName}",
	    			"${x.userCode}",
	    			"${x.userName!''}",
	    			"${x.sex!''}",
	    			"${x.age!''}",
	    			"${x.job!''}",
	    			"${x.status!''}",
	    			"<a class='button white' title='修改用户资料' onclick='editUser(${x.userId})' href='#'><span class='icon_single edit'></span></a><a class='button white' title='设置用户权限' onclick='editUserPriv(${x.userId})' href='#'><span class='icon_single group'></span></a>"]<#if x_has_next>,</#if>
		    </#list>
	    </#if>
    ]
}