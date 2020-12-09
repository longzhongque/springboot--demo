package net.xdclass.forum.dao;

import net.xdclass.forum.domain.User;
import net.xdclass.forum.util.DataSourceUtil;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    private QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());

    //开启驼峰映射
    private BeanProcessor beanProcessor = new GenerousBeanProcessor();
    private RowProcessor processor = new BasicRowProcessor(beanProcessor);

    public int save(User user) throws Exception{
        String sql = "insert into user(phone,pwd,sex,img,create_time,role,username) values(?,?,?,?,?,?,?)";
        Object[] params = {
                user.getPhone(),user.getPwd(),user.getSex(),user.getImg(),user.getCreate_time(),user.getRole(),user.getUserName()
        };
        int i = 0;
        try {
            i = queryRunner.update(sql,params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    public User findByPhoneAndPwd(String phone, String md5pwd) {
        String sql = "select * from user where phone=? and pwd=?";
        User user = null;
        try {
            user = queryRunner.query(sql, new BeanHandler<>(User.class,processor),phone,md5pwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public List<User> list() {
        String sql = "select * from user";
        List<User> list = null;
        try {
            list = queryRunner.query(sql,new BeanListHandler<>(User.class,processor));
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
