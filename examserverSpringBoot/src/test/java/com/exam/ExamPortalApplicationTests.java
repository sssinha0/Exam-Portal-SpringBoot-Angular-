package com.exam;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootTest
class ExamPortalApplicationTests {

	@Test
	void contextLoads() throws ParseException {
		SimpleDateFormat formatter6=new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss.SSS");
		Date localDateTime=formatter6.parse("20-10-2022T05:20:30.010");
		System.out.println(localDateTime);
	}

}
