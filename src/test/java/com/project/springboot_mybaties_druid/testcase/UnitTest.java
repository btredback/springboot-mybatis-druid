package com.project.springboot_mybaties_druid.testcase;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;

import com.project.springboot_mybatis_druid.App;
import com.project.springboot_mybatis_druid.controller.UserController;

/**
 * spring boot 单元测试
 * userconntroller
 * https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html
 * @author baitao
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=App.class,webEnvironment = WebEnvironment.RANDOM_PORT)
//@WebAppConfiguration
public class UnitTest {
	private MockMvc mvc;
	@Autowired
	private UserController userController;
	@Before
	public void setUp() throws Exception{
		mvc = MockMvcBuilders.standaloneSetup(userController).build();
	}
	//测试样例
	@Test
	public void getUserIndex() throws Exception{
		System.out.println("user index test");
		mvc.perform(MockMvcRequestBuilders.get("/user/index").accept(MediaType.TEXT_PLAIN))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("hello"));
	}
	@Test
	public void getUserByName() throws Exception{
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/user/search/name/testName").accept(MediaType.TEXT_PLAIN))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andReturn();
		System.out.println(result.getResponse().getContentAsString());
		TestCase.assertTrue("not success", result.getResponse().getContentAsString().indexOf("success") != -1);
	}
	@Test
	@Transactional
	@Rollback(true)
	public void addUser() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders.post("/user/add")
				.param("userId", "4")
				.param("userName", "testName4")
				.param("userAge", "14").contentType(MediaType.APPLICATION_JSON_UTF8);
		MvcResult result = mvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
		TestCase.assertTrue("not success", result.getResponse().getContentAsString().indexOf("success") != -1);		
	}
}
