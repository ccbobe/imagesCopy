package com.gzz.sys.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @类说明 [user]测试工具，将本类移到maven测试目录中或测试完成之后删除
 * @author 高振中
 * @date 2019-01-12 22:40:08
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcTestUser {
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private MockMvc mvc;
	/**
	 * @方法说明 测试 新增[user]记录,根据数据类型修改每个字段的值
	 */
 	@Test
	public void save() throws Exception {
 		User user = User.builder()
 		//.id("gaozz") // 设置【id】的值
 		//.name("gaozz") // 设置【name】的值
 		//.password("gaozz") // 设置【password】的值
 		.build();
		logger.info(doRequest("/user/save", user));
	}
	/**
	 * @方法说明 测试 查询[user]列表,条件可以为空,可直接运行
	 */
//	@Test
	public void queryList() throws Exception {
		UserCond cond = UserCond.builder()
 		//.id("gaozz")  // 设置查询条件【id】的值
 		//.name("gaozz")  // 设置查询条件【name】的值
 		//.password("gaozz")  // 设置查询条件【password】的值
		.build();
		logger.info(doRequest("/user/queryList", cond));
	}
	/**
	 * @方法说明 测试 查询[user]分页列表,条件可以为空,可直接运行
	 */
//	@Test
	public void queryPage() throws Exception {
		UserCond cond = UserCond.builder()
 		//.id("gaozz")  // 设置查询条件【id】的值
 		//.name("gaozz")  // 设置查询条件【name】的值
 		//.password("gaozz")  // 设置查询条件【password】的值
		.build();
		// cond.setPage(0); //当前页
		// cond.setSize(10); //页大小
		logger.info(doRequest("/user/queryPage", cond));
	}
	
	private <T> String doRequest(String url, T t) throws Exception {// restController专用测试方法
		return mvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(t))).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse().getContentAsString();
	}
}