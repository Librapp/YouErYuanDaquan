package com.ctbri.youeryuandaquan.data;

/**
 * 
 * @author 梦思
 * @description 评论实体类
 * @createTime 2013/12/17
 */
public class CommentData {
	/** ID */
	public String id;
	/** 评论对象ID */
	public String targetId;
	/** 用户ID */
	public String userId;
	/** 发表时间 */
	public String time;
	/** 内容 */
	public String content;
	/** 价格 */
	public String price;
	/** 评分 */
	public float mark;
	/** 教师资源评分 */
	public float mark_teacher;
	/** 硬件评分 */
	public float mark_hadrware;
	/** 卫生评分 */
	public float mark_health;
	/** 食物评分 */
	public float mark_food;
	/** 交通评分 */
	public float mark_traffic;
	/** 孩子喜欢评分 */
	public float mark_childfeeling;
	/** 用户名 */
	public String userName;
	/** 用户头像 */
	public String userPic;
	/** 评论对象名称 */
	public String targetName;
	/** 评论对象类型 */
	public String targetType;
}
