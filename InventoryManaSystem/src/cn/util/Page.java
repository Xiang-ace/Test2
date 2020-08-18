package cn.util;

public class Page {
	// 每页显示数据条数
	private int size;
	// 当前显示页数
	private int currentPage;
	// 显示总页数（通过数据总条数和size求出）
	private int totalPage;
	// 数据总条数
	private int totalCount;
	
	public Page(int size, int currentPage, int totalPage, int totalCount) {
		super();
		this.size = size;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.totalCount = totalCount;
	}
	
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		/*if (totalCount % size == 0) {
			this.totalPage = totalCount / size;
		} else {
			this.totalPage = totalCount / size + 1;
		}*/
	}

}
