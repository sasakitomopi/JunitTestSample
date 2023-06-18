package com.junit.sample.controller;

import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junit.sample.dto.Result;
import com.junit.sample.dto.Sample;

@RestController
@RequestMapping("/")
public class SampleController {


	@GetMapping("/test")
	public Result exexute(@RequestBody Sample sample) {

		// バリデーションチェック
		boolean validateResult = hasError(sample);

		// バリデーションエラーの場合
		if(validateResult) {
			System.out.println("ValidationError");
			Result response = new Result();
			response.setResult(false);
			response.setErrorReason("ValidationError");
			return response;
		}

		System.out.println("Sample Dto is" + sample);

		// 正常終了した場合
		Result response = new Result();
		response.setResult(true);
		return response;
	}

	/**
	 * バリデーションチェックを実行する<br>
	 * 　バリデーションエラーの場合：<b>false</b> <br>
	 * 　エラーを通過した場合：<b>true</b> <br>
	 * @param sample
	 * @return
	 */
	private boolean hasError(Sample sample) {
		if(Objects.isNull(sample.getFirstName())) {
			System.out.println("FirstName is Null");
			return true;
		} else if(Objects.isNull(sample.getLastName())) {
			System.out.println("LastName is Null");
			return true;
		} else if (Objects.isNull(sample.getTelNum())) {
			System.out.println("TelNum is Null");
		}
		return false;
	}
}
