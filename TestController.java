package cn.wzvtc.soft;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController("/" )
public class TestController {

    @RequestMapping(value = "userinfo")
    public Map<String, String> userinfo(HttpSession httpSession) {
        Map<String, String> resultMap = new HashMap<>();
        if(httpSession.getAttribute("loginnumber")!=null){
        resultMap.put("myname", "郑发进");
        resultMap.put("mynumber", "18002090239");
        }
        return resultMap;
    }

    @RequestMapping(value = "/login")
    public Map<String, String> login(@RequestBody Map<String, String> map, HttpSession httpSession) {
        String password = map.get("password");
        String number = map.get("number");
        Map<String, String> resultMap = new HashMap<>();
        if ("18002090239".equals(number) && "18002090239".equals(password)){
            httpSession.setAttribute("loginnumber",number);
            resultMap.put("result", "success");
        }
        return resultMap;

}

}