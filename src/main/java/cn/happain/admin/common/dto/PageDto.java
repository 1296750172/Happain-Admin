package cn.happain.admin.common.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class PageDto {

    @NotNull(message = "不能为空")
    @Min(message = "最小为0",value = 0)
    private Integer pageNum;
    @NotNull(message = "不能为空")
    @Min(message = "最小为10",value = 10)
    @Max(message = "最大为30",value = 30)
    private Integer pageSize;
}
