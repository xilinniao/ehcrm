<%@ page contentType="text/html; charset=utf-8"%>
			<form action="<%=path%>/${url}?method=onEdit${moduleName}?cap_first" class="validate" id="saveform" name="saveform" method="post">
						<input type="hidden" name="${moduleName}Id" id="${moduleName}Id"/>
						<input type="hidden" name="parent${moduleName}?cap_firstId" id="parent${moduleName}?cap_firstId" />
							<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
							  <tbody>
							  <#list attr as x>
							  <tr>
							    <th><#if x.remark??>${x.remark}</#if></th>
								<td><input type="text" name="${x.columnName}" class="formText {required: true}" id="${x.columnName}" size="40"></td>
							  </tr>
							  </#list>
							  </tbody>
							</table>
							<div class="buttonArea">
								<input type="button" class="formButtonSubmit" id="btnSave" value="保存" hidefocus="true"/>
								<input type="button" class="formButtonSubmit" id="btnDelete" value="删除" hidefocus="true"/>
							</div>
						</form>