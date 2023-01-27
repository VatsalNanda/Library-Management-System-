package nanda.vatsal.books;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nanda.vatsal.books.Book;
import nanda.vatsal.books.BookService;

@RestController
public class BookController {
	
	
	@Autowired
	public BookService bookService;
	
	@RequestMapping("/books")
	public List<Book> getAllBooks()
	{
		return bookService.getAllBooks();
	}
	
	@RequestMapping("/booksById/{id}")
	public Book getBookById(@PathVariable int id)
	{
		return bookService.getBookById(id);
		
				
	}
	
	@RequestMapping("/booksByTitle/{title}")
	public Book getBookByTitle(@PathVariable String title)
	{
		return bookService.getBookByTitle(title);				
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/books/addBook")
	public void addBook(@RequestBody Book book)
	{
		bookService.addBook(book);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,value="/books/updateBook/{id}")
	public void updateBook(@RequestBody Book book,@PathVariable int id)
	{
		bookService.updateBook(book,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/books/deleteBook/{id}")
	public void deleteBook(@PathVariable int id)
	{
		bookService.deleteBook(id);
	}
	
	
	
	

}
