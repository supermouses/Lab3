package trinhquangtan.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import trinhquangtan.demo.enity.Book;
import trinhquangtan.demo.services.BookService;
import trinhquangtan.demo.services.CategoryService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.spi.ToolProvider.findFirst;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String showAllBooks(Model model)
    {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books",books);
        return  "book/list";
    }
    @GetMapping("/add")
    public String addBookForm(Model model)
    {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "book/add";
    }
    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Book book)
    {
        bookService.addBook(book);
        return "redirect:/books";
    }
    @GetMapping("/delete/{id}")
    public  String deleteBook(@PathVariable("id") Long id)
    {
        Book book = bookService.getBookById(id);
        bookService.deleteBook(id);
        return "redirect:/books";
    }
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") Long id,Model model)
    {
        Optional<Book> book = bookService.getAllBooks().stream().filter(books ->Objects.equals(books.getId(), id))
                .findFirst();
        if (book.isPresent())
        {
            model.addAttribute("book",book.get());
            return "book/edit";
        }else {
            return "not found";
        }
    }
    @PostMapping("/edit")
    public String editBook(@ModelAttribute("book") Book updatedBook)
    {
        bookService.getAllBooks().stream()
                .filter(book -> book.getId() == updatedBook.getId())
                .findFirst()
                .ifPresent(book -> book.setId(book.getId()));
        return "redirect:/books";
    }
}
