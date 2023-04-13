package cat.Controller;

import cat.dto.AttendDto;
import cat.dto.UserDto;
import cat.service.AttendService;
import cat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ManageController {
    @Autowired
    AttendService attendService;
    @Autowired
    UserService userService;

    @GetMapping("/manage")
        public String managePage(UserDto user, AttendDto attendDto, Model model) throws Exception {

            List<AttendDto> todayList = attendService.getTodayList();
            List<UserDto> attendList = userService.readAll();

            model.addAttribute("todayList",todayList);
            model.addAttribute("attendList",attendList);
            model.addAttribute("user",user);
              return "manage";
        }

    @PostMapping("/manage/commit")
    public String read(String id, AttendDto attendDto, Model model, HttpSession session, HttpServletRequest request) throws Exception {
        attendDto.setId(id);

        // 출결 판별 + 출결 정보 업데이트 메서드
        attendService.attendCommit();

        return "redirect:/manage";
    }


}
