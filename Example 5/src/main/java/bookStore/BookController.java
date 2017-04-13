package bookStore;

import bookStore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @Autowired
    AuthorService authorService;

    @RequestMapping("/")
    String home(Model model) {
        model.addAttribute("authors", authorService.getAll());
        return "home";
    }
}
