package com.gzz.sys.user;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.cache.Cache;
import com.gzz.common.base.Page;

import lombok.extern.slf4j.Slf4j;

/**
 * @类说明 [user]业务逻辑层
 * @author 高振中
 * @date 2019-11-30 13:07:55
 **/
@Service
@Slf4j
public class UserService {
	@Autowired
	@Qualifier("userCache")
	private Cache<Integer, Optional<User>> userCache;

	@Autowired
	private UserDao dao; // 注入user数据访问层

	/**
	 * @方法说明 通过设备ID修改分流站所ID
	 */
	public User getUserById(Integer id) {
		User user = null;

		Optional<User> userOptional = null;
		try {
			userOptional = userCache.get(id, new Callable<Optional<User>>() {
				@Override
				public Optional<User> call() {
					try {
						List<User> list = dao.queryList(UserCond.builder().id(id).build());
						Optional<User> first = list.stream().findFirst();
						return first;
					} catch (Throwable e) {
						return Optional.empty();
					}
				}
			});
		} catch (ExecutionException e) {
			 log.error("error->",e);
			e.printStackTrace();
		}
		if (userOptional.isPresent()) {
			user = userOptional.get();
		}
		if (user != null) {
			log.debug("数据分流{}", user);
		}
		return user;

	}

	/**
	 * @方法说明 新增[user]记录
	 */
	@Transactional
	public int save(User user) {
		return dao.save(user);
//		int i = 1 / 0;
//		log.info("go");
//		user.setName("gzz");
//
//		user.setId(9);
//		dao.update(user);
//		return 1;
	}

	/**
	 * @方法说明 删除user记录(多条)
	 */
	public int delete(Integer ids[]) {
		// return dao.deleteLogic(ids);//逻辑删除
		return dao.delete(ids);// 物理删除
	}

	/**
	 * @方法说明 更新user记录
	 */
	// @Transactional
	public int update(User user) {
		return dao.update(user);
	}

	/**
	 * @方法说明 按条件查询分页user列表
	 */
	public Page<User> queryPage(UserCond cond) {
		return dao.queryPage(cond);
	}

	/**
	 * @方法说明 按条件查询不分页user列表
	 */
	public List<User> queryList(UserCond cond) {
		return dao.queryList(cond);
	}

	/**
	 * @方法说明 按主键查找单个user记录
	 */
	public User findById(Integer id) {
		return dao.findById(id);
	}

	/**
	 * @方法说明 按条件查询user记录个数
	 */
	public long queryCount(UserCond cond) {
		return dao.queryCount(cond);
	}
}