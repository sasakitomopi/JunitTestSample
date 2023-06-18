package com.junit.sample.test;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.junit.sample.controller.SampleController;
import com.junit.sample.dto.Result;
import com.junit.sample.dto.Sample;

public class SampleTest {

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

	@Test
	public void firstNameIsNull() {
		Sample sample = new Sample();
//		sample.setFirstName("taro");
		sample.setLastName("sample");
		sample.setTelNum("012-3456-7890");

		SampleController sampleController = new SampleController();
		Result response = sampleController.exexute(sample);
		boolean result = response.isResult();

		assertTrue(result);
	}
}
