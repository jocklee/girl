package com.klee.girl.controller;

import com.klee.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 */

@RestController
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;

    //    @RequestMapping(value="/hello",method = RequestMethod.GET)
    @PostMapping(value = "/hello")
    public String Say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer mid) {
        return "ID=" + mid;
    }
}
