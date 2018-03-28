package cn.sevendream.newprojdemo.net.response.common;




public  class ParentResp {
	private boolean success = true;
	private String description = "成功";
	//后续用于验签
	private String sign;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	@Override
	public String toString() {
		return "ParentResp{" +
				"success=" + success +
				", description='" + description + '\'' +
				", sign='" + sign + '\'' +
				'}';
	}
}
