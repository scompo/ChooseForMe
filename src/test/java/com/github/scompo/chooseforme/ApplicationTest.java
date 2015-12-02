package com.github.scompo.chooseforme;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;

import com.github.scompo.chooseforme.commons.WebTest;

@WebTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicationTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Test
	public void test() {
		
		assertNotNull("web application context is null", webApplicationContext);
	}

}
