package com.hc.web;

import com.hc.domain.User;
import com.hc.exception.ServiceException;
import com.hc.service.UserService;
import com.hc.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @date 2015/7/26
 */
@Controller
@RequestMapping("/admin")
public class MainController {

    private final static Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public String main(){
        return "/view/admin/main.html";
    }

    @GetMapping(value = "/info")
    @ResponseBody
    public Map info() {
        String username = CommonUtil.getCurrentUserName();
        User user = userService.findUserByUsername(username);
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("role", user.getRole());
        return map;
    }

    @PostMapping(value = "/updateCurrentPwd")
    @ResponseBody
    public Map updateCurrentUserPwd(@RequestBody Map<String, String> params) {
        if (params.size() != 3) {
            return CommonUtil.response(false, "密码修改失败,参数不全");
        }
        String oldPwd = params.get("oldPwd");
        String newPwd = params.get("newPwd");
        String newPwdAgain = params.get("newPwdAgain");
        if (!newPwd.equals(newPwdAgain)) {
            return CommonUtil.response(false, "密码修改失败,新密码不一致");
        }
        String username = CommonUtil.getCurrentUserName();
        User user = userService.findUserByUsername(username);
        userService.updateUserPwd(user, oldPwd, newPwd);
        return CommonUtil.response(true, "密码修改成功");
    }

    /**
     * -------------handleException-------------
     * @param e exception
     * @return map
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Map<String, Object> serviceExceptionHandler(ServiceException e) {
        return CommonUtil.response(false, e.getMessage());
    }

}
