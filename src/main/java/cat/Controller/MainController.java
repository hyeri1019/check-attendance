package cat.Controller;

import cat.Service.UserListServiceImpl;
import cat.dto.UserListResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    UserListServiceImpl userListService;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView home(ModelAndView mv) {

        //Service  call//
        List<UserListResponseDTO> userlist = userListService.getUserListService();


        for(int i=0; i<userlist.size(); i++) {
            System.out.println("name : "+userlist.get(i).getUserName());
        }
        mv.addObject("listuser", userlist);
        mv.setViewName("list");

        System.out.println("야호");
        return mv;
    }
}
