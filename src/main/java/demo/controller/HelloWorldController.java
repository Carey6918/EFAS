package demo.controller;

import demo.model.CorpPO;
import demo.util.ResultBundle;
import org.hibernate.boot.jaxb.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/corpInfo")
    public String showEnterpriseInfoPage(){
        return "corpInfoPage";
    }
}
