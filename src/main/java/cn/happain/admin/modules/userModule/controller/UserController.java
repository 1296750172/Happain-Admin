package cn.happain.admin.modules.userModule.controller;

import cn.happain.admin.common.dto.Message;
import cn.happain.admin.modules.userModule.dto.UserDto;
import cn.happain.admin.modules.userModule.dto.valid.UserGroup;
import cn.happain.admin.modules.userModule.service.impl.UserServiceImpl;
import cn.happain.admin.modules.userModule.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author happain
 * @since 2022-07-31
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/login")
    public Message<UserVo> login(@Validated({UserGroup.login.class}) @RequestBody UserDto userDto, HttpServletRequest httpServletRequest) {

        return null;
    }

}
