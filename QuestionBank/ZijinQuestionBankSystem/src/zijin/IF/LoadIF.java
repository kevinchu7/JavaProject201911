package zijin.IF;

import java.io.FileNotFoundException;
import java.util.List;

import zijin.bean.ChoiceQuestion;
import zijin.bean.DetailStatistics;
import zijin.bean.FillQuestion;
import zijin.bean.JudgeQuestion;

public interface LoadIF {
	public boolean saveCQ(ChoiceQuestion CQ, int subjectid); 
	public boolean saveFQ(FillQuestion FQ, int subjectid); 
	public boolean saveJQ(JudgeQuestion JQ, int subjectid); 
	public List<DetailStatistics> saveExcel(int paperid);
}
