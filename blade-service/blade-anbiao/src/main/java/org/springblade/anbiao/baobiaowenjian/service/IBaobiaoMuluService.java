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
package org.springblade.anbiao.baobiaowenjian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.anbiao.baobiaowenjian.entity.BaobiaoMulu;
import org.springblade.anbiao.baobiaowenjian.page.BaobiaoWenjianPage;
import org.springblade.anbiao.baobiaowenjian.vo.BaobiaoMuluVO;

/**
 *  服务类
 *
 * @author elvis.he
 * @since 2019-05-16
 */
public interface IBaobiaoMuluService extends IService<BaobiaoMulu> {

	/**
	 *根据文件性质查询报告列表数据
	 * @author : elvis.he
	 * @since : 2019-05-18 11:04
	 * @param : baobiaoWenjianPage
	 * @return:
	 */
	BaobiaoWenjianPage<BaobiaoMuluVO> selectBaogaoPage(BaobiaoWenjianPage baobiaoWenjianPage);

}
