package zijin.IF;

import zijin.bean.Admin;
import zijin.bean.Student;
import zijin.bean.Teacher;

public interface UpdatePWIF {
    public int updatetPW(Teacher tc);
    public int updatesPW(Student sd);
    public int updateaPW(Admin ad);
}
