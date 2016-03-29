package com.ctbri.youeryuandaquan.data;

/**
 * 
 * @author 梦思
 * @description 幼儿园数据类
 * @createTime 2013/12/16
 */
public class YouErYuanData {
	/** ID */
	public String id = "";
	/** 名字 */
	public String name = "";
	/** 介绍 */
	public String info = "";
	/** 省 */
	public String province;
	/** 市 */
	public String city;
	/** 区 */
	public String district;
	/** 标签 */
	public String tab;
	/** 幼儿园=0，早教=1 */
	public int type;
	/** 邮箱 */
	public String email;
	/** 电话 */
	public String tel = "";
	/** 地址 */
	public String address;
	/** 经度 */
	public String longitude;
	/** 纬度 */
	public String latitude;
	/** 图片URL */
	public String pics = "";
	/** 视频URL */
	public String videos = "";
	/** 点评数 */
	public int commentCount = 0;
	/** 帖子数 */
	public int topicCount = 0;
	/** 浏览数 */
	public int visitCount = 0;
	/** 收藏数 */
	public int favCount = 0;
	/** 图片数 */
	public int picCount = 0;
	/** 评分 */
	public float mark;
	/** 成立日期 */
	public String foundDate;
	/** 详细介绍 */
	public String content;
	/** 办学条件 */
	public String foundcondition;
	/** 入学条件 */
	public String entrancondition;
	/** 其他说明 */
	public String remark;
	/** 费用 */
	public String price = "";
	/** 收费单位 */
	public String unit = "/年";
	/** 网址 */
	public String website;
	/** 是否收藏 */
	public boolean isFavorite = false;
	/** 是否加入 */
	public boolean isJoin = false;
	/** 分类 */
	public String category;
	/** 喜欢 */
	public Float mark_childfeeling;
	/** 食物 */
	public Float mark_food;
	/** 卫生 */
	public Float mark_health;
	/** 硬件 */
	public Float mark_hadrware;
	/** 教师 */
	public Float mark_teacher;
	/** 交通 */
	public Float mark_traffic;
	public CommentData comment;
	public CommentData myComment;
	public TopicData topic;
	public NewsData news;
	/** 封面 */
	public String cover;
}
