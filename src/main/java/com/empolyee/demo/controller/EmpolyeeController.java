package com.empolyee.demo.controller;

import com.empolyee.demo.entites.Empolyee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("empolyees")
public class EmpolyeeController {
    ArrayList<Empolyee> empolyees = new ArrayList<>(
            List.of(
                    new Empolyee(
                            UUID.randomUUID(),
                            "hossam",
                            "islam",
                            "sam@gmail.com",
                            "01212121",
                            LocalDate.of(2023,2,23),
                            "software engineer",
                            UUID.randomUUID()
                    ),
                    new Empolyee(
            UUID.randomUUID(),
                            "hossam",
                                    "islam",
                                    "sam@gmail.com",
                                    "01212121",
                                    LocalDate.of(2023,2,23),
                                    "software engineer",
                                    UUID.randomUUID()
                                    )
            )
    );
    @GetMapping
    public ArrayList<Empolyee> helloworld(){
        return empolyees;
    };
    @GetMapping("/{EmpolyeeId}")
    public UUID findone(@PathVariable UUID EmpolyeeId){
return EmpolyeeId;
    }
}
