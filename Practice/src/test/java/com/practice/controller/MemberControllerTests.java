package com.practice.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class MemberControllerTests {

	@Setter(onMethod_= {@Autowired})
	private WebApplicationContext ctx;
	
	@Setter(onMethod_=@Autowired)
	private BCryptPasswordEncoder pwencoder;
	
	private MockMvc mockMvc;//mockMvc사용해서 가상으로 url호출 보낼 수 있음
	
	@Before
	public void setup() {
		this.mockMvc=MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	/*@Test
	public void testRegister() throws Exception{
		String resultPage=mockMvc.perform(MockMvcRequestBuilders.post("/member/memberRegister")
							.param("userid", "ljs")
							.param("userpw", pwencoder.encode("dkxltmxm135"))
							.param("email", "ljs921026@gmail.com")
							.param("userName", "이준선")
						).andReturn()
						.getModelAndView()
						.getViewName();
		
		log.info(resultPage);
	}*/
	
	@Test
	public void testUpdate() throws Exception{
		String resultPage=mockMvc.perform(MockMvcRequestBuilders.post("/member/resetPassword")
							.param("userid", "ljs921026")
							.param("userpw", pwencoder.encode("dkxltmxm135"))
						).andReturn()
						.getModelAndView()
						.getViewName();
		
		log.info(resultPage);
	}
}
