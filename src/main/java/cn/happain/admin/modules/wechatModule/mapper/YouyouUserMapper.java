package cn.happain.admin.modules.wechatModule.mapper;


import cn.happain.admin.modules.wechatModule.model.vo.YouyouUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface YouyouUserMapper extends BaseMapper<YouyouUser> {
}
