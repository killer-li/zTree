package util;

import java.util.Collection;

public class ShowByPage {
	public int showPage =1 ; 		//目标页码
	public int currentPage =1 ;		//当前页码
	public int pageSize =10 ;		//每页显示记录条数
	public int totalPage = 1 ;		//总页码
	public int allCount =0 ;		//总记录数
	
	public Collection<Object> rsList ;	//当前结果集

	public int getShowPage() {
		return showPage;
	}

	public void setShowPage(int showPage) {
		if(showPage < 1)
			showPage = 1 ;
		if(showPage > totalPage)
			showPage = totalPage ;
		this.showPage = showPage;
		this.setCurrentPage(showPage) ;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getAllCount() {
		return allCount;
	}

	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}

	public Collection<Object> getRsList() {
		return rsList;
	}

	public void setRsList(Collection<Object> rsList) {
		this.rsList = rsList;
	}
}

