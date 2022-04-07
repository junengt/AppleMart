package com.example.applemart;

import com.example.applemart.domain.Post;
import com.example.applemart.domain.PostTag;
import com.example.applemart.domain.Tag;
import com.example.applemart.domain.User;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void doInit() {
        initService.doInitUserAndPost1();
        initService.doInitAddTag();
        initService.doInitUserAndPost2();
    }

    @Component
    @RequiredArgsConstructor
    @Transactional
    static class InitService {

        private final EntityManager em;

        public void doInitAddTag() {
            String[] tags  = {"AirPods Series","AirPdos Pro", "AirPods Max",
                    "iPad Pro", "iPad Air", "iPad mini", "Apple Watch Series",
                    "Apple Watch SE", "iPhone Series", "iPhone SE Series", "MacBook Air",
            "MacBook Pro", "iMac 24", "Display", "AirTag", "Mac mini", "Mac Studio", "Accessories"};
            for (String tagName : tags) {
                Tag tag = new Tag();
                tag.setName(tagName);
                em.persist(tag);
            }
        }

        public void doInitUserAndPost1() {
            User user = new User();
            user.setPhoneNumber("01022172425");
            user.setPhoto("애플사진");
            em.persist(user);

            Post post = new Post();
            post.setUser(user);
            post.setTitle("맥북 프로 팝니다");
            post.setPrice(5000000);
            post.setContent("500만원에 팝니다");
            em.persist(post);
        }

        public void doInitUserAndPost2() {
            User user = new User();
            user.setPhoneNumber("01012345678");
            user.setPhoto("애플사진");
            em.persist(user);

            Post post = new Post();
            post.setUser(user);
            post.setTitle("맥북 에어 팜다");
            post.setPrice(1000000);
            post.setContent("100만원에 팜다");
            em.persist(post);
        }
    }
}
