package zijin.bean;

/**
 * 文件名：DetailStatistics.java
 * 作用：封装成绩统计数据信息，用于之后的老师对成绩的统计->teacher.detailStatistics.jsp 以及规定了Excel的到处格式
 * 创建者：陈天、瞿嘉乐、季洋洋、朱凯
 * 创建时间：
 * 
 */
public class DetailStatistics {
    private String sid;
    private String sname;
    private int score;
    private int paperid;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getPaperid() {
		return paperid;
	}
	public void setPaperid(int paperid) {
		this.paperid = paperid;
	}
} 

