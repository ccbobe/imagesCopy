package com.gzz.sys.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.common.base.Page;

/**
 * @类说明 [user]控制器
 * @author 高振中
 * @date 2019-11-30 13:07:55
 **/
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService service; // 注入user数据逻辑层

	/**
	 * @方法说明 新增[user]记录
	 */
	@PostMapping("save")
	public int save(@RequestBody User user) {
		return service.save(user);
	}

	/**
	 * @方法说明 删除user记录(多条)
	 */
	@DeleteMapping("delete")
	public int delete(Integer ids[]) {
		return service.delete(ids);
	}

	/**
	 * @方法说明 修改user记录
	 */
	@PostMapping("update")
	public int update(@RequestBody User user) {
		return service.update(user);
	}

	/**
	 * @方法说明 按条件查询分页user列表
	 */
	@PostMapping("queryPage")
	public Page<User> queryPage(@RequestBody UserCond cond) {
		return service.queryPage(cond);
	}

	/**
	 * @方法说明 按条件查询不分页user列表
	 */
	@PostMapping("queryList")
	public List<User> queryList(@RequestBody UserCond cond) {
		return service.queryList(cond);
	}

	/**
	 * @方法说明 按主键查单个user记录
	 */
	@PostMapping("findById")
	public User findById(@RequestParam("id") Integer id) {
		return service.findById(id);
	}

	/**
	 * @方法说明 按条件查询user记录个数
	 */
	@PostMapping("queryCount")

	public long queryCount(@RequestBody UserCond cond) {
		return service.queryCount(cond);
	}

	/**
	 * @方法说明 通过设备ID修改分流站所ID
	 */
	@GetMapping("getUserById")
	public User getUserById(Integer id) {
		return service.getUserById(id);
	}
}