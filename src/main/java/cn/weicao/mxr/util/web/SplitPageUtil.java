package cn.weicao.mxr.util.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 进行分页的参数处理操作
 * @author mxr
 */
public class SplitPageUtil {
	private int currentPage = 1 ;	// 参数：cp
	private int lineSize = 10 ;		// 参数：ls
	private String column ;		// 参数：col
	private String keyWord ;	// 参数：kw
	private Date startTime ; 
	private Date endTime ;
	private HttpServletRequest request ;
	/**
	 * 将你需要进行模糊查询的columnData（下拉框）传递到组件之中，目的是为了属性操作
	 * @param columnData 分页搜索的下拉列表数据
	 * @param handleUrlKey 设置分页路径的key
 	 */
	public SplitPageUtil(String columnData,String handleUrlKey) {
		this.request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest() ;
		this.request.setAttribute("columnData", columnData);
		this.request.setAttribute("handleUrl", handleUrlKey); 
		try {	// 这行代码出错只有不传递或传递非法参数的时候出现
			this.currentPage = Integer.parseInt(this.request.getParameter("cp")) ;
		} catch (Exception e) {}
		try {	// 如果出错就使用默认值
			this.lineSize = Integer.parseInt(this.request.getParameter("ls")) ;
		} catch (Exception e) {}
		this.column = this.request.getParameter("col") ;
		this.keyWord = this.request.getParameter("kw") ;
		try {
			String startTemp = this.request.getParameter("startTime") ;
			String endTemp = this.request.getParameter("endTime") ;
			if(startTemp != null && !"null".equals(startTemp) && !"".equals(startTemp)) {
				this.startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTemp) ;	
			}
			if(endTemp != null && !"null".equals(endTemp) && !"".equals(endTemp)) {
				this.endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTemp) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (this.column == null) {
			this.column = "" ;
		}
		if (this.keyWord == null) {
			this.keyWord = "" ;
		}
		this.request.setAttribute("currentPage", this.currentPage);
		this.request.setAttribute("lineSize", this.lineSize);
		this.request.setAttribute("keyWord", this.keyWord);
		this.request.setAttribute("column", this.column);
		if(this.startTime != null) {
			this.request.setAttribute("startTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.startTime));
		}else {
			this.request.setAttribute("startTime", this.startTime);
		}
		if(this.endTime != null) {
			this.request.setAttribute("endTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.endTime));
		}else {
			this.request.setAttribute("endTime", this.endTime);
		}
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getLineSize() {
		return lineSize;
	}
	public String getColumn() {
		return column;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public Date getStartTime() {
		return startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
}
