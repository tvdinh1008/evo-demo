package com.evo.storage.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class FileResource {
    @GetMapping("")
    LocalDate test() {
        return LocalDate.now();
    }

    @GetMapping("api/test")
    LocalDate test2() {
        return LocalDate.now();
    }
}
