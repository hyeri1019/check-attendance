package cat.Controller;

import cat.dto.UserDto;
import cat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/loginpage")
    public String loginpage() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        System.out.println("logout");
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping("/manage")
    public String manage() {
        return "manage";
    }

    @PostMapping("/loginpage/login")
    public String login(String id, String pwd, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        if(!checkInfo(id,pwd)) {
            String message = URLEncoder.encode("아이디 또는 비밀번호가 일치하지 않습니다.","utf-8");
            model.addAttribute("message",message);
            return "redirect:/loginpage";
        }

        HttpSession session = request.getSession();
        session.setAttribute("id",id);

        if(checkAdmin(id,pwd)) {
            return "redirect:/manage";
        }

        return "redirect:/attend";
    }

    private boolean checkInfo(String id, String pwd) throws Exception {
        UserDto user = userService.read(id);
        if(user==null) return false;

        System.out.println("user? = " + user);
        return user.getPwd().equals(pwd);
    }

    private boolean checkAdmin(String id, String pwd) throws Exception {
        UserDto admin = userService.readAdmin(id);
        if(admin==null) return false;
        return admin.getPwd().equals(pwd);


    }

}
