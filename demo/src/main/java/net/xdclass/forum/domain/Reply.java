package net.xdclass.forum.domain;

import java.util.Date;

/**
 * CREATE TABLE `forum`.`Untitled`  (
 *   `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
 *   `topic_id` int(11) NULL DEFAULT NULL,
 *   `floor` int(11) NULL DEFAULT NULL COMMENT '楼层编号，回复是不能删除的',
 *   `content` varchar(524) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '回复内容',
 *   `user_id` int(11) NULL DEFAULT NULL,
 *   `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '回复⼈名称',
 *   `user_img` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '回复⼈头像',
 *   `create_time` datetime NULL DEFAULT NULL,
 *   `update_time` datetime NULL DEFAULT NULL,
 *   `delete` int(11) NULL DEFAULT NULL COMMENT '0是正常，1是禁⽤',
 *   PRIMARY KEY (`id`) USING BTREE
 * ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;
 */
public class Reply {
    private int id;
    private int topic_id;
    private int floor;
    private String content;
    private int user_id;
    private String userName;
    private String user_img;
    private Date create_time;
    private Date update_time;
    private int delete;

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", topic_id=" + topic_id +
                ", floor=" + floor +
                ", content='" + content + '\'' +
                ", user_id=" + user_id +
                ", userName='" + userName + '\'' +
                ", user_img='" + user_img + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", delete=" + delete +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }
}
