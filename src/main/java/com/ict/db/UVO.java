package com.ict.db;

public class UVO {
	private String u_idx,id,pwd;


	public UVO(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}

	public String getU_idx() {
		return u_idx;
	}

	public void setU_idx(String u_idx) {
		this.u_idx = u_idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "UVO [u_idx=" + u_idx + ", id=" + id + ", pwd=" + pwd + "]";
	}


	


}
