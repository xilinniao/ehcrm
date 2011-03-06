<%@ page contentType="text/html; charset=utf-8"%>
			<form action="<%=path%>/admin/menu.do?method=onEditMenu" class="validate" id="saveform" name="saveform" method="post">
						<input type="hidden" name="menuId" id="menuId"/>
						<input type="hidden" name="parentMenuId" id="parentMenuId" />
							<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
							  <tbody>
							  <tr>
							    <th>上级菜单</th>
								<td class="left"><input type="text" name="parentMenuName" class="formText ro {required: true}" readonly id="parentMenuName">
								<input type="button" class="formButton" id="parent_menu_select" value="选择" hidefocus="true"/>
								</td>
							  </tr>
							  <tr>
							    <th>菜单名称</th>
								<td><input type="text" name="menuName"  class="formText {required: true}" id="menuName" size="40"></td>
							  </tr>
							  <tr>
							    <th>资源类型</th>
								<td><select name="resType" id="resType">
								  <option value="">请选择</option>
								  <option value="1">菜单</option>
								  <option value="2">权限资源</option>
								  </select>
								</td>
							  </tr>
							  <tr>
							    <th>菜单地址</th>
							    <td><input type="text" name="menuUrl" class="formTextLL" id="menuUrl"></td>
							  </tr>
							  <tr>
							    <th>资源编码</th>
							    <td><input type="text" name="menuCode" class="formTextS" id="menuCode"></td>
							  </tr>
							  <tr>
							    <th>排序号</th>
							    <td><input type="text" name="sortNum" class="formTextSS {required: true,integer:true,min:0}" id="sortNum" title="排序号决定了菜单的排列顺序，顺序按从小到大排序"></td>
							  </tr>
							  </tbody>
							</table>
							<div class="buttonArea">
								<input type="button" class="formButtonSubmit" id="btnSave" value="保存" hidefocus="true"/>
								<input type="button" class="formButtonSubmit" id="btnDelete" value="删除" hidefocus="true"/>
							</div>
						</form>