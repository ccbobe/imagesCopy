package com.gzz.sys.user;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;
/**
 * @类说明 [user]实体类
 * @author 高振中
 * @date 2019-11-30 13:07:55
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder	
@AllArgsConstructor
@NoArgsConstructor
public class User {
    // 以下为数据库中 字段
	private Integer id; // id
	private String name; // name
	private String password; // password
    // 以下为查询显示辅助属性
}