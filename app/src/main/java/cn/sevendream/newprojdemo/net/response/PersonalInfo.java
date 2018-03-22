package cn.sevendream.newprojdemo.net.response;

import cn.sevendream.newprojdemo.bean.BaseVO;

/**
 * Created by zhangxue on 2018/3/22.
 */

public class PersonalInfo extends BaseVO {
	private String status;
	private String born;
	private String sex;
	private String idcard;
	private String att;
	private String postno;
	private String areano;
	private String style_simcall;
	private String style_citynm;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBorn() {
		return born;
	}

	public void setBorn(String born) {
		this.born = born;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getAtt() {
		return att;
	}

	public void setAtt(String att) {
		this.att = att;
	}

	public String getPostno() {
		return postno;
	}

	public void setPostno(String postno) {
		this.postno = postno;
	}

	public String getAreano() {
		return areano;
	}

	public void setAreano(String areano) {
		this.areano = areano;
	}

	public String getStyle_simcall() {
		return style_simcall;
	}

	public void setStyle_simcall(String style_simcall) {
		this.style_simcall = style_simcall;
	}

	public String getStyle_citynm() {
		return style_citynm;
	}

	public void setStyle_citynm(String style_citynm) {
		this.style_citynm = style_citynm;
	}
}
