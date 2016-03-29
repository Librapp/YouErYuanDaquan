package com.ctbri.youeryuandaquan.data;

/**
 * 
 * @author 梦思
 * @description 孩子数据实体类
 * @createTime 2013/12/16
 */
public class ChildData {
	/** ID */
	private int id;
	/** ���� */
	private String name;
	/** �ǳ� */
	private String nickName;
	/** �Ա� */
	private int gender;
	/** 宝宝生日 */
	private String birthdate;
	/** �꼶 */
	private int grade;
	/** �༶ */
	private int klass;
	/** �����׶�԰ID */
	private int kId;
	/** �����׶�԰���� */
	private String kName;
	/** �໤��ID */
	private int parentId;
	/** �໤������ */
	private String parentName;
	/** ��ע */
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getKlass() {
		return klass;
	}

	public void setKlass(int klass) {
		this.klass = klass;
	}

	public int getkId() {
		return kId;
	}

	public void setkId(int kId) {
		this.kId = kId;
	}

	public String getkName() {
		return kName;
	}

	public void setkName(String kName) {
		this.kName = kName;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
