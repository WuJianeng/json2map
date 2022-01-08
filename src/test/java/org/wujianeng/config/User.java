package org.wujianeng.config;

import org.wujianeng.annotation.FieldName;
import org.wujianeng.annotation.Path;
import org.wujianeng.annotation.Table;

/**
 * @author wu_jianeng@foxmail.com
 * @date 2022/1/8 21:48
 */
@Table(name = "user_table")
public class User {
    @FieldName("user_id")
    @Path("$..data[*].id")
    String userId;

    @FieldName("user_name")
    @Path("$..name")
    String userName;

    @FieldName("signature")
    @Path("$..headline")
    String signature;

    @FieldName("follower_count")
    @Path("$..follower_count")
    int followerCount;

    @FieldName("answer_count")
    @Path("$..answer_count")
    int answerCount;
}
