package org.springblade.anbiao.cheliangziping.vo;

import io.swagger.annotations.ApiModelProperty;
import org.springblade.anbiao.cheliangziping.entity.Zipingwenjian;

import java.util.List;

/**
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/9/519:31
 */
public class ZipingwenjianVO extends Zipingwenjian {

    @ApiModelProperty(value = "图片列表")
    private List<String> imgList;
}
