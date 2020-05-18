package zijin.IF;

import java.util.List;

import zijin.bean.Errors;
import zijin.bean.Mistakes;

public interface MyMistakeIF {
     public List<Errors> getmistakeList(String sid);
     public List<Mistakes> Mistakesc(String sid, int paperid);
     public List<Mistakes> Mistakesf(String sid, int paperid);
     public List<Mistakes> Mistakesj(String sid, int paperid);
}
