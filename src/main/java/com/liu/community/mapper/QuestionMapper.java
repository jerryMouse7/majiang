package com.liu.community.mapper;

import com.liu.community.entity.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface QuestionMapper {

        @Insert("insert into question (creator,title,description,comment_count,view_count,like_count,tag,gmt_create,gmt_modified) " +
                "values (#{creator},#{title},#{description},#{commentCount},#{viewCount},#{likeCount},#{tag},#{gmtCreate},#{gmtmodified})")
        void create(Question question );
}
