package com.smallbeef.springboottest.controller;

import com.smallbeef.springboottest.entity.Book;
import com.smallbeef.springboottest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;


/**
 * RestController = @Controller + @ResponseBody
 * Controller 将当前修饰的类注入SpringBoot IOC容器，使得从该类所在的项目跑起来的过程中，这个类就被实例化。
 * 当然也有语义化的作用，即代表该类是充当Controller的作用
 * ResponseBody 该类中所有的API接口返回的数据都会以Json字符串的形式返回给客户端
 *
 * RequestMapping 提供路由信息，负责URL到Controller中的具体函数的映射。服务器发送 /book 请求时执行该类
 *
 * 通过Handler数据才能调给前端使用
 */
@RestController
@RequestMapping("/book")
public class BookHandler {
    @Autowired
    private BookRepository bookRepository;

    /**
     * 分页显示
     *
     * GetMapping是一个组合注解 是@RequestMapping(method = RequestMethod.GET)的缩写
     * page/size 表示从第几页开始，每页几个
     */
    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return bookRepository.findAll(request);
    }


    /**
     * 添加图书
     *
     * RequestBody 通过映射把前端Json数据转化成java对象
     */
    @PostMapping("/add")
    public String save(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    /**
     * 根据Id查询图书信息
     */
    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        return bookRepository.findById(id).get();
    }

    /**
     * 修改图书信息
     *
     * PUT请求：如果两个请求相同，后一个请求会把第一个请求覆盖掉。（所以PUT用来改资源）
     * Post请求：后一个请求不会把第一个请求覆盖掉。（所以Post用来增资源）
     */
    @PutMapping("/update")
    public String update(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        bookRepository.deleteById(id);
    }

}
