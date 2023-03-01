package com.chen.controller;

import com.chen.service.UserService;
import com.chen.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//web
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello(Model m) {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "hello";
    }

    @GetMapping("/index")
    public String index(){
        return  "main";
    }

    @GetMapping("/toLogin")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest request, Model model) {
        User user = userService.getFromUsername(username);
        if(user != null){
            boolean success = userService.login(username, password);
            if (success) {
                // 将用户信息保存到session中
                request.getSession().setAttribute("user", user);
                // 登录成功，重定向到首页
                return "redirect:/users/index";
            } else {
                // 登录失败，返回错误提示信息
                System.out.println("登录失败");
                System.out.println("用户 " +username + " 密码错误");
                model.addAttribute("errorMessage", "用户 " +username + " 密码错误");
            }
        }else{
            // 登录失败，返回错误提示信息
            System.out.println("登录失败");
            System.out.println("用户 " +username + " 不存在");
            model.addAttribute("errorMessage", "用户 " +username + " 不存在");
        }
        // 登录失败跳转到login.jsp
        return "login";
    }

    /**
     * 获得指定id的用户
     *
     * @param id 用户id
     * @return id对应用户
     */
    @ResponseBody
    @GetMapping ("/id={id}")
    public User get(@PathVariable("id") Integer id) {
        return userService.getFromId(id);
    }

    /**
     *
     * @return 所有用户
     */
    @ResponseBody
    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    /**
     *
     * @param name Username-用户名
     * @return 用户名对应用户
     */
    @ResponseBody
    @GetMapping("/username={username}")
    public User get(@PathVariable("username") String name){
        return userService.getFromUsername(name);
    }

    /**
     * 往表中增加新user
     *
     * @param name username
     * @param pwd password
     * @param email email
     * @return new User
     */
    @ResponseBody
    @PostMapping("/add/username={username}&password={password}&email={email}")
    public String insert(@PathVariable("username") String name,
                       @PathVariable("password") String pwd,
                       @PathVariable("email") String email){
        User user = new User();
        user.setName(name).setPassword(pwd).setEmail(email);
        userService.insertUser(user);
        String msg = "success sign up, new user is ";
        System.out.print(msg + user.getName());
        return msg + user.getName();
    }

    /**
     * 更新用户的password
     *
     * @param name 用户名
     * @param pwd 新密码
     * @return {用户名}成功更改密码
     */
    @ResponseBody
    @PutMapping("/{username}&{password}")
    public String updatePassword(@PathVariable("username") String name,
                               @PathVariable("password") String pwd){
        User user = new User();
        user.setName(name).setPassword(pwd);
        userService.updatePwd(user);
        String msg = " password changed!";
        return "user " + user.getName() + msg;
    }

    /**
     * 删除对应id的user
     *
     * @param id
     * @return 返回成功信息
     */
    @ResponseBody
    @DeleteMapping("/id={id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return "Success deleted";
    }




}
