package com.security.controller;

import com.security.domain.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @classDesc: 控制器
 * @author: Vipin Zheng
 * @createDate: 2018-04-15 20:02:00
 * @version: v1.0
 */
@Controller
public class SysUserController {

    @RequestMapping("/login")
    public String login(){
        return "login.html";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "index.html";
    }
}
