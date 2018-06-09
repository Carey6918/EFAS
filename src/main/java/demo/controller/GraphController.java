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
    public String tree(Integer org,Integer id,Integer seqId){
        return "tree";
    }
}
