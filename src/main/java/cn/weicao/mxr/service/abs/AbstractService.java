package cn.weicao.mxr.service.abs;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractService {
	protected Map<String,Object> converToMap(int currentPage,int lineSize,String column,String keyWord,Date start,Date end){
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("start", (currentPage - 1) * lineSize) ;
		map.put("lineSize", lineSize) ;
		if ("".equals(column)) {
			map.put("column", null) ;
		} else {
			map.put("column", column) ;
		}
		if ("".equals(keyWord)) {
			map.put("keyWord", null) ;
		} else {
			map.put("keyWord", "%" + keyWord + "%") ; 
		}
		if(start != null && end != null) {
			if(start.getTime() >= end.getTime()) {
				map.put("endTime", end) ;
			}else {
				map.put("startTime", start) ;
				map.put("endTime", end) ;
			}
		}else if(start == null && end != null) {
			map.put("endTime", end) ;
		}else if(start != null && end == null) {
			map.put("startTime", start) ;
		}else {}
		return map ;
	}
}
