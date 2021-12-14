package com.mycompany.testldit.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.mycompany.ldit.attendance.model.service.AttendanceServiceImpl;

@RunWith(MockitoJUnitRunner.class) 
@ContextConfiguration({ 
	 "classpath:WEB-INF/spring/root-context.xml", 
	 "classpath:WEB-INF/spring/appServlet/servlet-context.xml"})
public class TestAController {

	@Mock
	AttendanceServiceImpl attService;
	
	@InjectMocks
	private AttendanceController attendanceController;
	
	private MockMvc mockMvc; 
	 
	private static final Logger logger = LoggerFactory.getLogger(TestAController.class); 
	
	@Before
	public void beforeTest() {
		MockitoAnnotations.initMocks(this);
		
	//	this.mockMvc = MockMvcBuilders.standaloneSetup().build(); 
	}

}
