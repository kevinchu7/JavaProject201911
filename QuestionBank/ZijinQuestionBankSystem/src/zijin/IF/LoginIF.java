package zijin.IF;

import zijin.bean.Admin;
import zijin.bean.Student;
import zijin.bean.Teacher;

public interface LoginIF {
      public int studentLogin(Student std);
      public int adminLogin(Admin ad);
      public int teacherLogin(Teacher tc);
}
