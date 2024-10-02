package com.api.book.FormController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.api.book.entities.Book;

@Controller
public class MyController {



    @GetMapping("/add")
    public String about(Model model) {
        model.addAttribute("book", new Book());
        return "add";
    }
    
    @GetMapping("/get")
    public String showBookForm() {
        return "get"; // assuming "bookForm" is the name of your HTML file
    }
    
    @GetMapping("/delete")
    public String DeleteBook() {
        return "Delete"; // assuming "bookForm" is the name of your HTML file
    }
    
    @GetMapping("/update")
    public String UpdateBook() {
        return "update"; // assuming "bookForm" is the name of your HTML file
    }
    
    @GetMapping("/home")
    public String home() {
        return "home"; // assuming "bookForm" is the name of your HTML file
    }
}
