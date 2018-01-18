<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="ucgoodsConstituteInfo"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
				<div class="form-group" id="didDiv">
					<strong><span class="glyphicon glyphicon-eye-open"></span>&nbsp;半成品信息详情</strong>
				</div>
			</div>
			<div class="modal-body">
				<div>
					<table class="table table-condensed table-bordered table-hover" id="detailsTab">
						<thead>
							<tr>
								<th class="text-left" style="width:40%;">半成品编号</th> 
								<th class="text-center" style="width:10%;">半成品名称</th>
								<th class="text-center" style="width:10%;">规格</th>
								<th class="text-center" style="width:10%;">数量</th>
							</tr>
						</thead>
						<tbody>
							<tr class="text-primary">
								<td class="text-left">10001</td>
								<td class="text-center">钢管</td>
								<td class="text-center">1</td>
								<td class="text-center">100</td>
							</tr>
							<tr class="text-primary">
								<td class="text-left">10002</td>
								<td class="text-center">弹簧</td>
								<td class="text-center">11</td>
								<td class="text-center">2000</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div id="pageDiv" class="text-right">
					<ul class="pagination pagination-sm" id="pagecontrol"></ul>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭窗口</button>
			</div>
		</div>
	</div>
</div>
