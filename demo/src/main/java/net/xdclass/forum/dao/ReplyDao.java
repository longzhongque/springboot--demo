package net.xdclass.forum.dao;

import net.xdclass.forum.domain.Reply;
import net.xdclass.forum.util.DataSourceUtil;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ReplyDao {
    private QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());
    //开启驼峰映射
    private BeanProcessor beanProcessor = new GenerousBeanProcessor();
    private RowProcessor processor = new BasicRowProcessor(beanProcessor);

    /**
     * topic_id查询回复总记录
     */
    public int countTotalReplyByCid(int topicId){
        String sql = "select * from reply where topic_id=?";
        Long count = null;
        try {
            count = (Long)queryRunner.query(sql,new ScalarHandler<>(),topicId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count.intValue();
    }

    public List<Reply> findListByTopicId(int topicId,int from,int PageSize){
        String sql = "select * from reply where topic_id=? order by create_time asc limit ?,?";
        List<Reply> replyList = null;
        try {
            replyList = queryRunner.query(sql,new BeanListHandler<>(Reply.class,processor),topicId,from,PageSize);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return replyList;
    }

    public int save(Reply reply) {
        String sql = "insert into reply (topic_id,floor,content,user_id,username,user_img,create_time,update_time,`delete`)" +
                "values (?,?,?,?,?,?,?,?,?)";
        Object[] params = {
                reply.getTopic_id(),
                reply.getFloor(),
                reply.getContent(),
                reply.getUser_id(),
                reply.getUserName(),
                reply.getUser_img(),
                reply.getCreate_time(),
                reply.getUpdate_time(),
                reply.getDelete()
        };
        int rows = 0;
        try {
            rows = queryRunner.update(sql,params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }
}
