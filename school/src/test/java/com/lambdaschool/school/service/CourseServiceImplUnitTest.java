package com.lambdaschool.school.service;

import com.lambdaschool.school.SchoolApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SchoolApplication.class)
public class CourseServiceImplUnitTest
{
	// mocks - fake data
	// stubs - code that forces return value

	@Autowired
	private CourseService courseService;

	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown()
	{
	}

	@Test
	public void deleteFound()
	{
		courseService.delete(1);
		assertEquals(5, courseService.findAll().size());
	}

	@Test(expected = EntityNotFoundException.class)
	public void deleteNotFound()
	{
		courseService.delete(100);
		assertEquals(5, courseService.findAll().size());
	}
}
