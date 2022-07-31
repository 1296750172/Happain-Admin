package cn.happain.admin.modules.wechatModule.mapper;

import cn.happain.admin.modules.wechatModule.model.WxContent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface WxContentMapper extends BaseMapper<WxContent> {

}
