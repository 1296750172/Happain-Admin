package cn.happain.admin.modules.userModule.mapper;

import cn.happain.admin.modules.userModule.model.UserModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author happain
 * @since 2022-07-31
 */
@Mapper
@Component
public interface UserMapper extends BaseMapper<UserModel> {

}
