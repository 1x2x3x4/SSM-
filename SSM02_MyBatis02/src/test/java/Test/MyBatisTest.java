package Test;

import com.itheima.pojo.Employee;
import com.itheima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyBatisTest {

    //【1】查询所有员工信息findByIdTest()方法
    @Test
    public void findByIdTest() {
        // 通过工具类生成SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        Employee employee =
                session.selectOne("com.itheima.mapper.EmployeeMapper.findById", 2);
        System.out.println(employee);
        session.commit();
        // 关闭SqlSession
        session.close();
    }

    //【2】添加员工信息insertEmployeeTest()方法
    @Test
    public void insertEmployeeTest() {
        // 通过工具类生成SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        Employee employee = new Employee();
        employee.setId(4);
        employee.setName("赵六");
        employee.setAge(55);
        employee.setPosition("总裁");
        int result =
                session.insert("com.itheima.mapper.EmployeeMapper.addEmployee", employee);
        if (result > 0) {
            System.out.println("成功插入" + result + "条数据");
        } else {
            System.out.println("插入数据失败");
        }
        System.out.println(employee.toString());
        session.commit();
        // 关闭SqlSession
        session.close();
    }

    //【3】修改员工信息updateEmployeeTest()方法
    @Test
    public void updateEmployeeTest() {
        // 通过工具类生成SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        Employee employee = new Employee();
        employee.setId(2);
        employee.setName("小四");
        employee.setAge(23);
        employee.setPosition("经理");
        int result =
                session.update("com.itheima.mapper.EmployeeMapper.updateEmployee",
                        employee);
        if (result > 0) {
            System.out.println("成功更新" + result + "条数据");
        } else {
            System.out.println("更新数据失败");
        }
        System.out.println(employee.toString());
        session.commit();
        // 关闭SqlSession
        session.close();
    }

    //【4】删除员工信息deleteEmployeeTest()方法
    @Test
    public void deleteEmployeeTest() {
        // 通过工具类生成SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        int result =
                session.delete("com.itheima.mapper.EmployeeMapper.deleteEmployee", 4);
        if (result > 0) {
            System.out.println("成功删除" + result + "条数据");
        } else {
            System.out.println("删除数据失败");
        }
        session.commit();
        // 关闭SqlSession
        session.close();
    }


}
