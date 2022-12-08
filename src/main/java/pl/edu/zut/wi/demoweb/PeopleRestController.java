package pl.edu.zut.wi.demoweb;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping ("/api")
public class PeopleRestController {
    final PeopleService service;

    public PeopleRestController(PeopleService service) {
        this.service = service;
    }

    @GetMapping("/people")
    public List<Person> getPeople(){
        return service.getPeople();
    }

    @GetMapping("/people/{index}")
    public ResponseEntity<Person> getPerson(@PathVariable int index){
        try{
            return ResponseEntity.ok(service.getPerson(index));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/people")
    public ResponseEntity<?> addPerson(@RequestBody Person person) {
        service.addPerson(person);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/people/{index}")
    public ResponseEntity<?> updatePerson(@PathVariable int index, @RequestBody Person person) {
        try{
            service.getPeople().set(index, person);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
