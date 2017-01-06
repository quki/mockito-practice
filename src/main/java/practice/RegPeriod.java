package practice;

import java.time.ZonedDateTime;

public class RegPeriod {
	private ZonedDateTime start;
	private ZonedDateTime end;

	public RegPeriod(ZonedDateTime start, ZonedDateTime end) {
		this.start = start;
		this.end = end;
	}

	public ZonedDateTime getStart() {
		return start;
	}

	public ZonedDateTime getEnd() {
		return end;
	}

}
