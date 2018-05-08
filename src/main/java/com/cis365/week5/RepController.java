package com.cis365.week5;

import com.cis365.week5.models.Rep;
import org.springframework.web.bind.annotation.*;

@RestController
public class RepController {

    @GetMapping("/rep/{id}")
    public Rep getRepById(@PathVariable(value = "id") String repNum) {
        return DataStore.findRepById(repNum);
    }
}
