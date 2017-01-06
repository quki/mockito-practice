package practice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ConferenceDao {
	
	public RegPeriod findById(int dayId) {
		// 진짜 DB 갔다옴
		System.out.println("진짜 DB 실행!");
		ZonedDateTime start = ZonedDateTime.of(2016, 10, 5, 13, 0, 0, 0, ZoneId.of("KST"));
		ZonedDateTime end = ZonedDateTime.of(2016, 10, 5, 18, 0, 0, 0, ZoneId.of("KST"));
		return new RegPeriod(start, end);
	}


}
