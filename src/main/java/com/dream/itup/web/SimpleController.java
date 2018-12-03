package com.dream.itup.web;

import com.dream.itup.persistence.model.Book;
import com.dream.itup.persistence.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {

    @Autowired
    private BookRepository bookRepository;

    @Value("${spring.application.name}")
    String appName;

    @RequestMapping("/save")
    @ResponseBody
    public String save(Model model) {
        Book book = new Book("ini judul", "ini penulis");
        Book book1 = bookRepository.save(book);
        return "home"+book1.getTitle();
    }

    @RequestMapping("/get")
    public String get(Model model) {
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("appName", appName);
        model.addAttribute("books", books);
        return "home";
    }
}