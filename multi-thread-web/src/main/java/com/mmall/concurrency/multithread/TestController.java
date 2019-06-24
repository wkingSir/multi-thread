package com.mmall.concurrency.multithread;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author baijianzhong
 * @ClassName TestController
 * @Date 2019-06-24 20:48
 * @Description TODO
 **/
@Controller
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }
}
