package cat.Controller;

import cat.dto.AttendDto;
import cat.dto.UserDto;
import cat.service.AttendService;
import cat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class AttendController {

    @Autowired
    AttendService attendService;

    @Autowired
    UserService userService;

    @RequestMapping(value="/attend")
    public String attend(UserDto user, AttendDto attendDto, Model model, HttpServletRequest request, HttpSession session) throws Exception {

        session = request.getSession(false);
        String userId = (String) session.getAttribute("id");
        System.out.println("userId = " + userId);
        if (userId != null) {

            UserDto userInfo = userService.read(userId);
            System.out.println("userInfo = " + userInfo);
            model.addAttribute("userInfo", userInfo);

            Date inTime = null;
            Date outTime = null;
            try {
                AttendDto attendInfo = attendService.readCheckIn(userId);
                AttendDto attendInfo2 = attendService.readCheckOut(userId);
                inTime = attendInfo.getInTime();
                outTime = attendInfo2.getOutTime();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(" 오늘날짜 inTime null ");
            }

            model.addAttribute("inTime", inTime);
            model.addAttribute("outTime", outTime);
            return "attend";
        }
        return "redirect:/loginpage";
    }

    @PostMapping("/attend/save")
    public String attendSave(AttendDto attendDto, Model model, HttpSession session, HttpServletRequest request) throws Exception {

        String attendId = (String)session.getAttribute("id");
        attendDto.setId(attendId);
        System.out.println("attendId = " + attendId);

        // '입실'버튼 클릭 시
        attendService.checkIn(attendDto);
        System.out.println(" attend in save " );

        return "redirect:/";
    }

    @PostMapping("/attend/out")
    public String outSave(String id, AttendDto attendDto, Model model, HttpSession session, HttpServletRequest request) throws Exception {

        // '퇴실'버튼 클릭 시
        attendService.checkOut(attendDto);
        System.out.println(" outSave " );

        return "redirect:/";
    }

}
