package zijin.IF;

import java.util.List;

import zijin.bean.DetailStatistics;
import zijin.bean.StatisticsTable;

public interface StatisticsIF {
    public List<StatisticsTable> getStatistics(String tid);
    public List<DetailStatistics> getdetailStatistics(int paperid);
}
