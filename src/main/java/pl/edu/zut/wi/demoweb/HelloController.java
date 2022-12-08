package pl.edu.zut.wi.demoweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    final PeopleService peopleService;

    @Autowired
    public HelloController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/people")
    public String people(Model model) {
        model.addAttribute("people", peopleService.getPeople());
        return "people";
    }

    @GetMapping("/people/{index}")
    public String start(@PathVariable int index, Model model)  {
        Person person = peopleService.getPerson(index);
        model.addAttribute("person", person);
        return "show";
    }

    @GetMapping("/add")
    public String add(@RequestParam(required=false,name="firstName") String firstName,
                      @RequestParam(required=false,name="familyName") String familyName,
                      Model model)  {
        Person person = new Person(firstName, familyName);
        model.addAttribute("person", person);
        return "edit";
    }

    @GetMapping("/save")
    public String save(Person person){
        peopleService.addPerson(person);
        return "redirect:/people";
    }

}
