package com.moseswilliams.spring1webapp.controllers;

import com.moseswilliams.spring1webapp.repos.BookRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepo bookRepo;

    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @RequestMapping("/books")
    public String main(Model model){

        model.addAttribute("books", bookRepo.findAll());

        return "books/list";
    }
}
