package practice;

import java.time.Clock;
import java.time.ZonedDateTime;

public class RegService {
	private ConferenceDao dao;
	private Clock clock;

	public RegService(ConferenceDao dao, Clock clock) {
		this.dao = dao;
		this.clock = clock;
	}

	public boolean isAvailable(int dayId) {
		RegPeriod period = dao.findById(dayId);

		ZonedDateTime now = ZonedDateTime.now(clock);

		if (now.isAfter(period.getEnd())) {
			return false;
		}
		if (now.isBefore(period.getStart())) {
			return false;
		}
		return true;
	}
}
