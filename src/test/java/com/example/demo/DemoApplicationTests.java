package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



class DemoApplicationTests {

	calculate calculat = new calculate();

	@Test
	void itshouldAddTwoNumbers() {
		//given
		int a=10;
		int b=20;

		// when
		int sum = calculat.add(10,20);

		// then
		assertThat(sum).isEqualTo(30);

	}

	class  calculate{

		public int add (int a, int b){
			return a+ b;
		}
	}

}
