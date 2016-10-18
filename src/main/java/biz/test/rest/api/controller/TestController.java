package biz.test.rest.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/test")
public class TestController
{
    @RequestMapping(method = RequestMethod.GET, path = "/get")
    public String getTestString()
    {
        return "Test String";
    }
}
