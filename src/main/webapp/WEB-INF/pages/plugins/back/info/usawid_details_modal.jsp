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
							<td id="usawid">111</td>
						</tr>
						<tr>
							<td><strong>入库人：</strong></td>
							<td id="inMember">111</td>
						</tr>
						<tr>
							<td><strong>入库时间：</strong></td>
							<td id="inDate">111</td>
						</tr>
						<tr>
							<td><strong>入库申请单备注：</strong></td> 
							<td><pre class="pre-scrollable" style="width:800px;height:60px;" id="inNote">发神经阿德里飞洒抵抗力 范德克鲁斯建立开放撒 方力申搭建了开发商的 发动机萨拉空间来看 234uop富士达会计分录款手机范德萨进来进来看范德萨克利夫兰斯顿卡机了开发商大量了快捷方式的拉开建立开放撒酒 刘嘉玲发撒旦机立刻地方撒刻录机弗拉基反抗螺丝钉</pre></td>
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
