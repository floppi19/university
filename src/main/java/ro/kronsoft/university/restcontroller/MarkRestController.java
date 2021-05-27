package ro.kronsoft.university.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.kronsoft.university.entity.Mark;
import ro.kronsoft.university.repository.MarkRepository;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MarkRestController {

    @Autowired
    private MarkRepository markRepository;

    @GetMapping("/mark")
    public Response findAll() {
        List<Mark> markList = new ArrayList<>();
        markList = (List<Mark>) markRepository.findAll();
        return Response.ok(markList).build();
    }

    @PostMapping("/mark/add")
    public Response insertIntoDatabase(@RequestBody final Mark mark) {
        markRepository.save(mark);
        return Response.ok(mark).build();

    }

    @PutMapping("mark/{id}")
    public Response markUpdate(@RequestBody Mark mark, @PathVariable int id) {

        markRepository.findById(id)
                .map(newMark -> {
                    newMark.setCourse(newMark.getCourse());
                    newMark.setPerson(newMark.getPerson());
                    newMark.setMark(newMark.getMark());
                    newMark.setDateOfMark(newMark.getDateOfMark());
                    return markRepository.save(newMark);
                });
        return Response.ok().build();
    }

    @DeleteMapping("mark/delete/{id}")
    public Response markDelete(@PathVariable int id) {
        markRepository.deleteById(id);
        return Response.ok().build();
    }
}
