<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="warehouseGoodsInfo"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
				<div class="form-group" id="didDiv">
					<!-- 定义表单提示文字 -->
					<label class="col-md-5 control-label">半成品库：</label>
				</div>
			</div>
			<div class="modal-body">
				<div id="goodsBasicInfo">
					<table class="table table-condensed table-hover" id="goodsTable">
						<thead>
							<tr>
								<th class="text-center"><strong>编号</strong></th>
								<th class="text-center"><strong>名称</strong></th>
								<th class="text-center"><strong>规格</strong></th>
								<th class="text-center"><strong>数量</strong></th>
							</tr>
						</thead>
						<tbody id="ucgoods">
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
