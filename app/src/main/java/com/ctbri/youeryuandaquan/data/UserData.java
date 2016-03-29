package com.ctbri.youeryuandaquan.data;


/**
 * 
 * @author 梦思
 * @description 用户实体类
 * @createTime 2013/12/16
 */
public class UserData {
	/** ID */
	private String id = "84360a977c723d6a87b3c8be5e07219c";
	/** 姓名 */
	private String name = "liyang";
	/** 邮箱 */
	private String email = "ctbri.com";
	/** 真实姓名 */
	private String realname;
	/** 昵称 */
	private String nickname = name;
	/** 级别 */
	private int level;
	/** 注册日期 */
	private String regDate;
	/** 密码 */
	private String password = "12345678";
	/** 电话 */
	private String tel = "";
	/** 签名 */
	private String signature = "";
	/** IM号 */
	private String IM;
	/** 头像 */
	private String photo = "";
	/** 地址 */
	private String address = "";
	/** 是否登录 */
	public boolean isLogin = false;
	/** sessionID */
	public int sessionID = 0;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getIM() {
		return IM;
	}

	public void setIM(String iM) {
		IM = iM;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
