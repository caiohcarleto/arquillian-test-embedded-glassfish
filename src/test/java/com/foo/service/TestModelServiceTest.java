package com.foo.service;

import com.foo.model.TestModel;
import java.io.File;
import static org.junit.Assert.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.asset.FileAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class TestModelServiceTest  {

	Logger logger = LoggerFactory.getLogger(TestModelServiceTest.class);

	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addClass(TestModel.class)
            .addClass(TestModelService.class)
            .addAsManifestResource(new FileAsset(new File("src/test/resources/META-INF/persistence.xml")), "persistence.xml")
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
	
	public TestModelServiceTest() throws Exception {

	}

	@Inject
	TestModelService testService;

	@Test
	public void testValidUser() throws Exception {

		// TestModel a valid basic user
		{
			try {
				TestModel test = new TestModel();

				test.setTest("foo");

				testService.addTest(test);

			} catch(Exception e) {
				fail(e.toString());
			}
		}

	}	
}