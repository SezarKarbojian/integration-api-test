package com.karbo.mockoperator.recource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PingController {
    @GetMapping(value = "/ping", produces = "text/plain")
    public String ping() {
        return "I'm alive!!";
    }
}
