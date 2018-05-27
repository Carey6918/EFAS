package demo.controller;

import demo.model.CorpPO;
import demo.util.ResultBundle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloWorldController {
    @RequestMapping("/index")
    public ResultBundle<CorpPO> index(HttpServletRequest request, HttpServletResponse response) {
        CorpPO po = new CorpPO();
        ResultBundle<CorpPO> resultBundle = new ResultBundle(po);
        return resultBundle;
    }

    @RequestMapping("/home")
    public String home(){
        return "index";
    }
}
