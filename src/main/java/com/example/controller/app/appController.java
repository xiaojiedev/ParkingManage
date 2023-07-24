package com.example.controller.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller()
public class appController {

    @GetMapping("/login")
    public String login() {
        return "redirect:/login.html";
    }

//  登录验证现由Spring Security完成。

/*
    @Autowired
    private TUserService tUserService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public R login(@RequestBody TUser user){
        log.info("login user - > {}", user.toString());
        log.info(R.ok().toString());
        HashMap<String, Object> login = tUserService.login(user);
        if(Objects.equals(login.get("res"),0)){
            return R.error().data(login);
        }else{
            return R.ok().data(login);
        }
    }
*/
}
