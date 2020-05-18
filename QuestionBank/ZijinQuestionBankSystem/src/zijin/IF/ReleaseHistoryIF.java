package zijin.IF;

import java.util.List;

import zijin.bean.ChoiceQuestion;
import zijin.bean.FillQuestion;
import zijin.bean.JudgeQuestion;
import zijin.bean.Paper;

public interface ReleaseHistoryIF {
     public List<Paper> findpaperHistory(String tid);
     public List<ChoiceQuestion> getChoiceQPaper(int paperid);
     public List<FillQuestion> getFillQPaper(int paperid);
     public List<JudgeQuestion> getJudgeQPaper(int paperid);
}
