package com.mmall.concurrency.multithread.example.threadlocal;

import com.mmall.concurrency.multithread.RequestHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author baijianzhong
 * @ClassName ThreadLocalController
 * @Date 2019-06-27 15:29
 * @Description TODO
 **/
@Controller
@RequestMapping("/threadLocal")
public class ThreadLocalController {

    @RequestMapping("/test")
    @ResponseBody
    public Long test(){
        return RequestHolder.getId();
    }

}
