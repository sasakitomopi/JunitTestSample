package com.junit.sample;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.junit.sample.controller.SampleController;
import com.junit.sample.dto.Result;
import com.junit.sample.dto.Sample;

@SpringBootTest
class JunitTestSampleApplicationTests {

	@Test
	void contextLoads() {
	}

	@Before
	public void setUp() {
	}

	@Test
	public void firstNameIsNotNull() {
		Sample sample = new Sample();
		sample.setFirstName("taro");
		sample.setLastName("sample");
		sample.setTelNum("012-3456-7890");

		SampleController sampleController = new SampleController();
		Result response = sampleController.exexute(sample);
		boolean result = response.isResult();

		assertTrue(result);
	}

//	@Test
//	public void firstNameIsNull() {
//		Sample sample = new Sample();
////		sample.setFirstName("taro");
//		sample.setLastName("sample");
//		sample.setTelNum("012-3456-7890");
//
//		SampleController sampleController = new SampleController();
//		Result response = sampleController.exexute(sample);
//		boolean result = response.isResult();
//
//		assertTrue(result);
//	}
}
