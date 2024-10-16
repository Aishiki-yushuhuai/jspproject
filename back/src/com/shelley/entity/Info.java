package com.shelley.entity;

import java.util.Date;

public class Info {
	
	private Integer id;
	private String image;
	private String message;
	private String remark;
	private Integer manager;
	private Date time;
	private Integer menuId;
	
	public Info() {
		super();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getManager() {
		return manager;
	}
	public void setManager(Integer manager) {
		this.manager = manager;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	@Override
	public String toString() {
		return "Info [id=" + id + ", image=" + image + ", message=" + message + ", remark=" + remark + ", manager="
				+ manager + ", time=" + time + ", menuId=" + menuId + "]";
	}
	
	
}
