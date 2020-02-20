package com.smallbeef.springboottest;

import com.smallbeef.springboottest.entity.Book;
import com.smallbeef.springboottest.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
class SpringboottestApplicationTests {

    @Autowired
    private BookRepository repository;
    @Test
    void contextLoads() {
        // 从第0页开始取3个数据
        PageRequest pageRequest = PageRequest.of(0,3);
        Page<Book> page = repository.findAll(pageRequest);
        int i = 0;
    }

}
