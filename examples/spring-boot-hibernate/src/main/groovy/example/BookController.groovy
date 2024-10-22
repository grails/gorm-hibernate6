package example

import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CompileStatic
class BookController {

    @Autowired
    BookService bookService

    @RequestMapping("/books")
    List<Book> books() {
        Book.list()
    }

    @RequestMapping("/books/{title}")
    List<Book> booksByTitle(@PathVariable('title') String title) {
        bookService.find(title)
    }
}
