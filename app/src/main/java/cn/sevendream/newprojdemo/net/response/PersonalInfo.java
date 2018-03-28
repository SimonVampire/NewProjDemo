package cn.sevendream.newprojdemo.net.response;

import java.io.Serializable;

import cn.sevendream.newprojdemo.net.response.common.ParentResp;

/**
 * Created by zhangxue on 2018/3/22.
 */

public class PersonalInfo extends ParentResp implements Serializable{
	private static final long serialVersionUID = -4074455318158546313L;
	private String account;
	private int age;
	private boolean isVip;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isVip() {
		return isVip;
	}

	public void setVip(boolean vip) {
		isVip = vip;
	}

	@Override
	public String toString() {
		return "PersonalInfo{" +
				"account='" + account + '\'' +
				", age=" + age +
				", isVip=" + isVip +
				'}';
	}
}
