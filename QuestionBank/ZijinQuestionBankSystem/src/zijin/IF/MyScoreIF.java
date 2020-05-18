package zijin.IF;

import java.util.List;

import zijin.bean.ScoreTable;

public interface MyScoreIF {
	public List<ScoreTable> getMyScore(String sid);
}
