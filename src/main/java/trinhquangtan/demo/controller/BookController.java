package trinhquangtan.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import trinhquangtan.demo.enity.Book;
import trinhquangtan.demo.services.BookService;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping
    public String showAllBooks(Model model)
    {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books",books);
        return  "book/list";
    }
}
