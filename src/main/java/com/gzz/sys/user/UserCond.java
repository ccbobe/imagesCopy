package com.gzz.sys.user;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;
import com.gzz.common.base.BaseCondition;
/**
 * @类说明 [user]查询条件实体
 * @author 高振中
 * @date 2019-11-30 13:07:55
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCond extends BaseCondition {

    /**
     * @方法说明: 拼加自定义条件
     **/
    @Override
    public void addCondition() {
		add(id, "AND t.id = ?");
		add(name, "AND t.name LIKE ?", 3);
		add(password, "AND t.password LIKE ?", 3);
    	// add(ids, "AND t.id IN ");
    }
    // 以下为查询条件
	private Integer id; // id
	private String name; // name
	private String password; // password
	// private List<Long> ids;// 主键列表
	// 以下为自定义查询条件
}