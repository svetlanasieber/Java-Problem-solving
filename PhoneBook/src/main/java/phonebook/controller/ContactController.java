import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import phonebook.entity.Contact;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {   //This class will list and save contacts
    private List<Contact> contacts;

    public ContactController() {
        this.contacts = new ArrayList<>();
    }

    @GetMapping("/")   //tells Spring that this method cannot be called if the user wants to submit data. It should be only used for viewing data.
    // ModelAndView allows us to pass all the information required by Spring MVC in one return
    public ModelAndView index(ModelAndView modelAndView) {  //add contacts to the modelAndView and return it as a result
        modelAndView.setViewName("index");
        modelAndView.addObject("contacts", contacts);
        return modelAndView;
    }

    @PostMapping("/")           //told Spring that this method expects data that it needs to autofill in contact object
    public String add (Contact contact) {  //add the contact in our list and give a response to the user
        //validation
        this.contacts.add(contact);
        return "redirect:/";    //redirect the user back to index page as response
    }
}
