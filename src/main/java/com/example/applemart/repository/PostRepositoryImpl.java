package com.example.applemart.repository;

import com.example.applemart.domain.Post;
import com.example.applemart.domain.QPost;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.applemart.domain.QPost.*;

public class PostRepositoryImpl implements PostRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public PostRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Post> findAll() {
        return queryFactory
                .selectFrom(post)
                .where(post.deleted.isFalse())
                .fetch();
    }

    @Override
    public List<Post> findPostsBySearch(String searchKeyword) {
        return queryFactory
                .selectFrom(post)
                .where(post.title.contains(searchKeyword)
                        .and(post.deleted.isFalse()))
                .fetch();
    }

    @Override
    @Modifying
    public void updatePostDelete(Long postId){
        queryFactory
                .update(post)
                .set(post.deleted,true)
                .where(post.id.eq(postId))
                .execute();
    }
}
