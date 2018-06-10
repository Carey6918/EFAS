package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author qianzhihao
 * @version 2018/6/9
 */
@RequestMapping("/graph")
@Controller
public class GraphController {
    @RequestMapping("/tree")
    public String tree(){
        return "tree";
    }

    @RequestMapping("/atlas")
    public String atlas(){
        return "atlas";
    }

    @RequestMapping("/relation")
    public String relation(){
        return "relation";
    }
}
