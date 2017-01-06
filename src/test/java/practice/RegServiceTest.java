package practice;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

public class RegServiceTest {
	private static final ZoneId SEOUL = ZoneId.of("Asia/Seoul");
	ConferenceDao dao = mock(ConferenceDao.class);

	@Test
	public void canRegister() {
		// Given
		given(dao.findById(1)).willReturn(new RegPeriod(time(2007, 1, 6, 9), time(2007, 1, 6, 13)));
		Clock clock = fixedClock(2007, 1, 6, 12);

		// When
		RegService service = new RegService(dao, clock);
		boolean avail = service.isAvailable(1);

		// Then
		assertThat(avail, is(true));
	}

	@Test
	public void cannotRegister_before() {
		// Given
		given(dao.findById(1)).willReturn(new RegPeriod(time(2007, 1, 6, 9), time(2007, 1, 6, 13)));
		Clock clock = fixedClock(2007, 1, 6, 8);

		// When
		RegService service = new RegService(dao, clock);
		boolean avail = service.isAvailable(1);

		// Then
		assertThat(avail, is(false));
	}

	@Test
	public void cannotRegister_after() {
		// Given
		given(dao.findById(1)).willReturn(new RegPeriod(time(2007, 1, 6, 9), time(2007, 1, 6, 13)));
		Clock clock = fixedClock(2007, 1, 6, 14);

		// When
		RegService service = new RegService(dao, clock);
		boolean avail = service.isAvailable(1);

		// Then
		assertThat(avail, is(false));
	}

	private ZonedDateTime time(int year, int month, int day, int hour) {
		return ZonedDateTime.of(year, month, day, hour, 0, 0, 0, ZoneId.of("Asia/Seoul"));
	}

	private Clock fixedClock(int year, int month, int day, int hour) {
		return Clock.fixed(time(year, month, day, hour).toInstant(), SEOUL);
	}

}