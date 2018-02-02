<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="usawidDetailsInfo"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
				<div class="form-group" id="didDiv">
					<strong><span class="glyphicon glyphicon-eye-open"></span>&nbsp;订单详情</strong>
				</div>
			</div>
			<div class="modal-body">
				<div>
					<table class="table table-striped table-bordered table-hover">
						<tr> 
							<td style="width:150px;"><strong>入库单号：</strong></td>
							<td id="usawid"></td>
						</tr>
						<tr>
							<td><strong>入库人：</strong></td>
							<td id="inMember"></td>
						</tr>
						<tr>
							<td><strong>入库时间：</strong></td>
							<td id="inDate"></td>
						</tr>
						<tr>
							<td><strong>入库申请单备注：</strong></td> 
							<td><pre class="pre-scrollable" style="width:800px;height:60px;" id="inNote"></pre></td>
						</tr>
					</table>
					<table class="table table-condensed table-bordered table-hover" id="detailsTab">
						<thead>
							<tr>
								<th class="text-left" style="width:10%;">半成品编号</th> 
								<th class="text-center" style="width:20%;">半成品名称</th>
								<th class="text-center" style="width:20%;">规格</th>
								<th class="text-center" style="width:20%;">数量</th>
							</tr>
						</thead>
						<tbody id="details">
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
