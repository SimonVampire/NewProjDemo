package cn.sevendream.newprojdemo.bean;

import java.io.Serializable;

/**
 * Created by zhangxue on 2018/3/28.
 */

public class User implements Serializable{
	private static final long serialVersionUID = -8364522445524672839L;
	private String account;
	private String password;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" +
				"account='" + account + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
