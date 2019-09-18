package com.lambdaschool.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.service.CourseService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CourseController.class, secure = false)
public class CourseControllerUnitTest
{
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CourseService courseService;

	private List<Course> courseList;

//	@Before
//	public void setUp() throws Exception
//	{
//		courseList = new ArrayList<>();
//
//		Course c1 = new Course("Data Science", "Sally");
//		c1.setCourseid(30);
//
//		courseList.add(c1);
//
//		Course c2 = new Course("JavaScript", "Sally");
//		c2.setCourseid(31);
//
//		courseList.add(c2);
//
//	}

	@Test
	public void listAllCourses() throws Exception
	{
		String apiUrl = "/courses/courses";

//		Mockito.when(courseService.findAll()).thenReturn(courseList);

		RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);
		MvcResult r = mockMvc.perform(rb).andReturn();
		String tr = r.getResponse().getContentAsString();

		ObjectMapper mapper = new ObjectMapper();
		String er = mapper.writeValueAsString(courseList);

		assertEquals("Rest API returns List", er, tr);
	}
}
