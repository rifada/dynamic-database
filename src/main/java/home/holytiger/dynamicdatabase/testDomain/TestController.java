package home.holytiger.dynamicdatabase.testDomain;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/com/{comCd}")
    @ResponseBody
    public String comInfo(@PathVariable("comCd") String comCd){
        log.info(comCd);
        return testService.comInfo();
    }

}
