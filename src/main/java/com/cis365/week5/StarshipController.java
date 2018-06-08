package com.cis365.week5;

import com.cis365.week5.models.Rep;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
public class StarshipController {

    @GetMapping("/rep")
    public List<Rep> reps() {
        return DataStore.listReps();
    }

    @GetMapping("/rep/{id}")
    public Rep getRepById(@PathVariable(value = "id") String repNum) {
        return DataStore.findRepById(repNum);
    }

    @PostMapping(value="/rep/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE})
    public Rep addRep(@PathVariable(value = "id") String repNum,@RequestBody Rep repToUpdate) {
        return DataStore.updateRep(repNum, repToUpdate);
    }
}
