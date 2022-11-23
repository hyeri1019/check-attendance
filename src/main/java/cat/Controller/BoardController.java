package cat.Controller;

import cat.dao.UserDAO;
import cat.dto.BoardDTO;
import cat.dto.PageHandler;
import cat.dto.User;
import cat.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class BoardController {


    @Autowired
    BoardService boardService;


    @PostMapping("/board/remove")
    public String remove(Integer board_num, Integer page, Integer pageSize, Model m, HttpSession session, RedirectAttributes rattr) {
        String writer = (String)session.getAttribute("id");
        try {
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);

            int rowCnt = boardService.remove(board_num, writer);
            if(rowCnt!=1)
                throw new Exception("board remove error");

            rattr.addFlashAttribute("msg","DEL_OK");
            // addFlashAttribute : 메세지가 1번만 나옴

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","DEL_ERR");
        }


        return "redirect:/board/list";
    }



    @RequestMapping("/board")
    public String list(User user, Integer page, Integer pageSize, Model m, HttpSession session, HttpServletRequest request) {
        if(noLogin(request))
            return "redirect:/loginpage?toURL="+request.getRequestURL();  // 로그인을 안했으면 로그인 화면으로 이동


        if(page==null) page=1;
        if(pageSize==null) pageSize=10;

        try {

            int totalCnt = boardService.getCount();
            PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize);

            Map map = new HashMap();
            map.put("offset", (page-1)*pageSize);
            map.put("pageSize", pageSize);

            List<BoardDTO> list = boardService.getPage(map);
            m.addAttribute("list",list);
            m.addAttribute("ph", pageHandler);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 세션객체에서 값 가져오기
        String userId = (String)session.getAttribute("id");
        System.out.println(" session_userId : "+userId);
        m.addAttribute("userId", userId);



        return "boardlist"; // 로그인을 한 상태이면, 게시판 화면으로 이동
    }

    private boolean noLogin(HttpServletRequest request) {
        // 저장된 세션이 있는지 체크(false:없으면 null반환)
        HttpSession session = request.getSession(false);
        return session == null;
    }
}


