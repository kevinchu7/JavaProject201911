package zijin.IF;

import java.util.List;

import zijin.bean.Subject;

public interface ManagementSubjectIF {

	public boolean addsubject(Subject sub);
    public List<Subject> findsubject();
    public boolean deletesubject(int subjectid);
    public boolean updatesubject(Subject sub);
}
