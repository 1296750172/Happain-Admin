package cn.happain.admin.modules.userModule.service.impl;

import cn.happain.admin.modules.userModule.model.UserModel;
import cn.happain.admin.modules.userModule.mapper.UserMapper;
import cn.happain.admin.modules.userModule.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author happain
 * @since 2022-07-31
 */
@Service
@Transactional
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, UserModel> implements IUserService {

}
