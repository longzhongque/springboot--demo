package net.xdclass.forum.domain;

import java.util.Date;

/**
 * CREATE TABLE `forum`.`Untitled`  (
 *   `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
 *   `c_id` int(11) NULL DEFAULT NULL COMMENT '分类',
 *   `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
 *   `content` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内容',
 *   `pv` int(11) NULL DEFAULT NULL COMMENT '浏览量',
 *   `user_id` int(11) NULL DEFAULT NULL,
 *   `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
 *   `user_img` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
 *   `create_time` datetime NULL DEFAULT NULL,
 *   `update_time` datetime NULL DEFAULT NULL,
 *   `hot` int(2) NULL DEFAULT 0 COMMENT '是否热⻔ 1是热⻔',
 *   `delete` int(11) NULL DEFAULT 0 COMMENT '0是未删除，1是⼀件删除',
 *   PRIMARY KEY (`id`) USING BTREE
 * ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;
 */
public class Topic {
    private int id;
    private int c_id;
    private String title;
    private String content;
    private int pv;
    private int user_id;
    private String user_name;
    private String img;
    private Date create_time;
    private Date update_time;
    private int hot;
    private int delete;

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", c_id=" + c_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", pv=" + pv +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", img='" + img + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", hot=" + hot +
                ", delete=" + delete +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }
}
