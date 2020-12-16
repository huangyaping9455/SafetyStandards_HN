/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.anbiao.shigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.anbiao.shigu.entity.Shiguchuli;
import org.springblade.anbiao.shigu.page.ShiguchuliPage;
import org.springblade.anbiao.shigu.vo.ShiguchuliVO;

/**
 * 事故报告调查处理-事故处理 服务类
 *
 * @author elvis.he
 * @since 2019-04-29
 */
public interface IShiguchuliService extends IService<Shiguchuli> {

    /**
     * 自定义分页
     *
     * @param shiguchuliPage
     * @return
     */
    ShiguchuliPage<ShiguchuliVO> selectShiguchuliPage(ShiguchuliPage shiguchuliPage);

    /**
     * 根据id获取数据
     * *@param id
     *
     * @return
     */
    ShiguchuliVO selectByKey(String id);

    /**
     * 自定义 假删除
     *
     * @param id
     * @author :elvis.he
     */
    boolean deleleShiguchuli(String id);

}
