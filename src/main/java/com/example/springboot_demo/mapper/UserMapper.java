package com.example.springboot_demo.mapper;

import com.example.springboot_demo.entity.ReleaseServiceEntity;
import com.example.springboot_demo.entity.School;
import com.example.springboot_demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
//    @Select("SELECT * FROM user WHERE id = #{id}")
//    List<User> getUserById(Long id);
//
//    @Select("SELECT * FROM user")
//    List<User> getUsers();
//
//    @Select("SELECT * from release_plan_pipeline where plan_id = #{planId} and is_deleted = 0")
//    ReleaseServiceEntity findReleaseServiceById(@Param("planId") String planId);
//
//    @Select("SELECT * from release_plan_pipeline where plan_id = #{planId} and is_deleted = 0")
//    List<ReleaseServiceEntity> findReleaseService(@Param("planId") String planId);
//
//    @Results(id = "resultsMap", value = {
//            @Result(column = "id",property = "id",id = true),
//            @Result(column = "user_name",property = "userName1"),
//            @Result(column = "email",property = "email")
//    })
//    @Select({"select * from user where id = #{id}"})
//    List<User> findUser(@Param("id") Integer id);

    @Results(id = "schoolMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "id", property = "users",
                    many = @Many(select = "findUsersById"))
    })
    @Select({"select * from school where id != 5 limit #{page},#{size} "})
    List<School> getSchool(@Param("id") Integer id, @Param("page") Integer page, @Param("size") Integer size);

    @Select("select * from user where school_id = #{id} ")
    List<User> findUsersById(@Param("id") Integer id);
}
