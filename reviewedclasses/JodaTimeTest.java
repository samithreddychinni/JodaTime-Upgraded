import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.Interval;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.MutableDateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeConstants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import static org.junit.Assert.*;

/**
 * Test suite to ensure tests run in the correct order
 */
@RunWith(Suite.class)
@SuiteClasses({
    JodaTimeTest.Test1DateTimeCreation.class,
    JodaTimeTest.Test2LocalDateTimeOperations.class,
    JodaTimeTest.Test3DurationCalculation.class,
    JodaTimeTest.Test4PeriodOperations.class,
    JodaTimeTest.Test5IntervalOperations.class,
    JodaTimeTest.Test6DateTimeZoneOperations.class,
    JodaTimeTest.Test7DateTimeFormatting.class,
    JodaTimeTest.Test8MutableDateTimeOperations.class,
    JodaTimeTest.Test9DateTimeFieldOperations.class,
    JodaTimeTest.Test10DateTimeConstants.class
})
public class JodaTimeTest {
    
    public static class Test1DateTimeCreation {
        @Test
        public void testDateTimeCreation() {
            System.out.println("\n=================================================================");
            System.out.println("Test Case 1: Birthday Calculation Example");
            System.out.println("=================================================================");
            
            // Example 1: First person born on March 15, 2000
            DateTime firstBirthday = new DateTime(2000, 3, 15, 0, 0);
            DateTime secondBirthday = new DateTime(2000, 5, 20, 0, 0);
            
            System.out.println("Sample Input 1: Compare birthdays of people born on 2000-03-15 and 2000-05-20");
            System.out.println("Output: firstBirthday should be before secondBirthday");
            assertTrue("First birthday should be before second birthday", firstBirthday.isBefore(secondBirthday));
            
            System.out.println("\nContradictory Example:");
            System.out.println("Sample Input 2: Compare birthdays of people born on 2000-05-20 and 2000-03-15");
            System.out.println("Output: secondBirthday should be after firstBirthday");
            assertTrue("Second birthday should be after first birthday", secondBirthday.isAfter(firstBirthday));
            System.out.println("-----------------------------------------------------------------");
        }
    }

    public static class Test2LocalDateTimeOperations {
        @Test
        public void testLocalDateTimeOperations() {
            System.out.println("\n=================================================================");
            System.out.println("Test Case 2: Conference Schedule Example");
            System.out.println("=================================================================");
            
            // Example 1: Conference starting at 9:00 AM
            LocalDateTime conferenceStart = new LocalDateTime(2023, 6, 15, 9, 0);
            System.out.println("Sample Input 1: Conference starting at 9:00 AM on June 15, 2023");
            System.out.println("Output: Conference hour should be 9");
            assertEquals("Conference should start at 9 AM", 9, conferenceStart.getHourOfDay());
            
            System.out.println("\nContradictory Example:");
            LocalDateTime differentTime = new LocalDateTime(2023, 6, 15, 14, 0);
            System.out.println("Sample Input 2: Conference at 2:00 PM");
            System.out.println("Output: Conference hour should not be 9");
            assertNotEquals("Conference should not be at 9 AM", 9, differentTime.getHourOfDay());
            System.out.println("-----------------------------------------------------------------");
        }
    }

    public static class Test3DurationCalculation {
        @Test
        public void testDurationCalculation() {
            System.out.println("\n=================================================================");
            System.out.println("Test Case 3: Flight Duration Example");
            System.out.println("=================================================================");
            
            // Example 1: 6-hour flight
            DateTime departure = new DateTime(2023, 7, 1, 10, 0);
            DateTime arrival = new DateTime(2023, 7, 1, 16, 0);
            Duration flightDuration = new Duration(departure, arrival);
            
            System.out.println("Sample Input 1: Flight from 10:00 AM to 4:00 PM");
            System.out.println("Output: Flight duration should be 6 hours (21600000 milliseconds)");
            assertEquals("Flight duration should be 6 hours", 21600000, flightDuration.getMillis());
            
            System.out.println("\nContradictory Example:");
            DateTime shortDeparture = new DateTime(2023, 7, 1, 10, 0);
            DateTime shortArrival = new DateTime(2023, 7, 1, 11, 0);
            Duration shortFlight = new Duration(shortDeparture, shortArrival);
            
            System.out.println("Sample Input 2: Flight from 10:00 AM to 11:00 AM");
            System.out.println("Output: Flight duration should not be 6 hours");
            assertNotEquals("Flight duration should not be 6 hours", 21600000, shortFlight.getMillis());
            System.out.println("-----------------------------------------------------------------");
        }
    }

    public static class Test4PeriodOperations {
        @Test
        public void testPeriodOperations() {
            System.out.println("\n=================================================================");
            System.out.println("Test Case 4: Subscription Period Example");
            System.out.println("=================================================================");
            
            // Example 1: 1-year subscription
            DateTime startDate = new DateTime(2023, 1, 1, 0, 0);
            DateTime endDate = new DateTime(2024, 1, 1, 0, 0);
            Period subscriptionPeriod = new Period(startDate, endDate);
            
            System.out.println("Sample Input 1: Subscription from 2023-01-01 to 2024-01-01");
            System.out.println("Output: Subscription period should be 1 year");
            assertEquals("Subscription should be 1 year", 1, subscriptionPeriod.getYears());
            
            System.out.println("\nContradictory Example:");
            DateTime shortStart = new DateTime(2023, 1, 1, 0, 0);
            DateTime shortEnd = new DateTime(2023, 2, 1, 0, 0);
            Period shortPeriod = new Period(shortStart, shortEnd);
            
            System.out.println("Sample Input 2: Subscription from 2023-01-01 to 2023-02-01");
            System.out.println("Output: Subscription period should not be 1 year");
            assertNotEquals("Subscription should not be 1 year", 1, shortPeriod.getYears());
            System.out.println("-----------------------------------------------------------------");
        }
    }

    public static class Test5IntervalOperations {
        @Test
        public void testIntervalOperations() {
            System.out.println("\n=================================================================");
            System.out.println("Test Case 5: Event Schedule Example");
            System.out.println("=================================================================");
            
            // Example 1: 3-day music festival
            DateTime festivalStart = new DateTime(2023, 8, 1, 18, 0);
            DateTime festivalEnd = new DateTime(2023, 8, 4, 0, 0);
            Interval festival = new Interval(festivalStart, festivalEnd);
            
            System.out.println("Sample Input 1: Music festival from 2023-08-01 18:00 to 2023-08-04 00:00");
            System.out.println("Output: Festival duration should be approximately 2.25 days");
            assertTrue("Festival should be about 2.25 days", 
                festival.toDuration().getStandardDays() >= 2 && 
                festival.toDuration().getStandardDays() <= 3);
            
            System.out.println("\nContradictory Example:");
            DateTime shortStart = new DateTime(2023, 8, 1, 18, 0);
            DateTime shortEnd = new DateTime(2023, 8, 2, 0, 0);
            Interval shortFestival = new Interval(shortStart, shortEnd);
            
            System.out.println("Sample Input 2: Concert from 2023-08-01 18:00 to 2023-08-02 00:00");
            System.out.println("Output: Event duration should not be 2.25 days");
            assertTrue("Event should not be 2.25 days", 
                shortFestival.toDuration().getStandardHours() < 24);
            System.out.println("-----------------------------------------------------------------");
        }
    }

    public static class Test6DateTimeZoneOperations {
        @Test
        public void testDateTimeZoneOperations() {
            System.out.println("\n=================================================================");
            System.out.println("Test Case 6: International Meeting Example");
            System.out.println("=================================================================");
            
            // Example 1: Meeting in New York
            DateTimeZone newYorkZone = DateTimeZone.forID("America/New_York");
            DateTime newYorkTime = new DateTime(2023, 9, 1, 14, 0, newYorkZone);
            
            System.out.println("Sample Input 1: 2:00 PM meeting in New York");
            System.out.println("Output: London time should be 7:00 PM");
            DateTimeZone londonZone = DateTimeZone.forID("Europe/London");
            DateTime londonTime = newYorkTime.withZone(londonZone);
            assertEquals("London time should be 19:00", 19, londonTime.getHourOfDay());
            
            System.out.println("\nContradictory Example:");
            DateTimeZone tokyoZone = DateTimeZone.forID("Asia/Tokyo");
            DateTime tokyoTime = newYorkTime.withZone(tokyoZone);
            
            System.out.println("Sample Input 2: Same meeting in Tokyo timezone");
            System.out.println("Output: Tokyo time should not be 7:00 PM");
            assertNotEquals("Tokyo time should not be 19:00", 19, tokyoTime.getHourOfDay());
            System.out.println("-----------------------------------------------------------------");
        }
    }

    public static class Test7DateTimeFormatting {
        @Test
        public void testDateTimeFormatting() {
            System.out.println("\n=================================================================");
            System.out.println("Test Case 7: Event Announcement Example");
            System.out.println("=================================================================");
            
            // Example 1: Event date formatting
            DateTime eventDate = new DateTime(2023, 10, 31, 19, 30);
            DateTimeFormatter formatter = DateTimeFormat.forPattern("EEEE, MMMM d, yyyy 'at' h:mm a");
            
            System.out.println("Sample Input 1: Event on October 31, 2023 at 7:30 PM");
            System.out.println("Output: Formatted date should be 'Tuesday, October 31, 2023 at 7:30 PM'");
            String formattedDate = formatter.print(eventDate);
            assertEquals("Formatted date should match expected pattern", 
                "Tuesday, October 31, 2023 at 7:30 PM", formattedDate);
            
            System.out.println("\nContradictory Example:");
            DateTimeFormatter shortFormatter = DateTimeFormat.forPattern("MM/dd/yy");
            String shortFormat = shortFormatter.print(eventDate);
            
            System.out.println("Sample Input 2: Same date in short format (MM/dd/yy)");
            System.out.println("Output: Formatted date should not be 'Tuesday, October 31, 2023 at 7:30 PM'");
            assertNotEquals("Formatted date should not match long pattern", 
                "Tuesday, October 31, 2023 at 7:30 PM", shortFormat);
            System.out.println("-----------------------------------------------------------------");
        }
    }

    public static class Test8MutableDateTimeOperations {
        @Test
        public void testMutableDateTimeOperations() {
            System.out.println("\n=================================================================");
            System.out.println("Test Case 8: Calendar Event Rescheduling Example");
            System.out.println("=================================================================");
            
            // Example 1: Rescheduling a meeting
            MutableDateTime meetingTime = new MutableDateTime(2023, 11, 15, 10, 0, 0, 0);
            System.out.println("Sample Input 1: Meeting originally at 10:00 AM on November 15, 2023");
            System.out.println("Output: Meeting should be rescheduled to 2:00 PM");
            
            meetingTime.setHourOfDay(14);
            assertEquals("Meeting should be at 14:00", 14, meetingTime.getHourOfDay());
            
            System.out.println("\nContradictory Example:");
            MutableDateTime differentTime = new MutableDateTime(2023, 11, 15, 10, 0, 0, 0);
            differentTime.setHourOfDay(16);
            
            System.out.println("Sample Input 2: Meeting rescheduled to different time");
            System.out.println("Output: Meeting time should not be 2:00 PM");
            assertNotEquals("Meeting should not be at 14:00", 14, differentTime.getHourOfDay());
            System.out.println("-----------------------------------------------------------------");
        }
    }

    public static class Test9DateTimeFieldOperations {
        @Test
        public void testDateTimeFieldOperations() {
            System.out.println("\n=================================================================");
            System.out.println("Test Case 9: Business Hours Check Example");
            System.out.println("=================================================================");
            
            // Example 1: Checking business hours
            DateTime checkTime = new DateTime(2023, 12, 1, 14, 30);
            int hour = checkTime.getHourOfDay();
            
            System.out.println("Sample Input 1: Checking if 2:30 PM is within business hours (9 AM - 5 PM)");
            System.out.println("Output: 2:30 PM should be within business hours");
            assertTrue("2:30 PM should be within business hours", 
                hour >= 9 && hour <= 17);
            
            System.out.println("\nContradictory Example:");
            DateTime afterHours = new DateTime(2023, 12, 1, 18, 30);
            int afterHour = afterHours.getHourOfDay();
            
            System.out.println("Sample Input 2: Checking if 6:30 PM is within business hours");
            System.out.println("Output: 6:30 PM should not be within business hours");
            assertFalse("6:30 PM should not be within business hours", 
                afterHour >= 9 && afterHour <= 17);
            System.out.println("-----------------------------------------------------------------");
        }
    }

    public static class Test10DateTimeConstants {
        @Test
        public void testDateTimeConstants() {
            System.out.println("\n=================================================================");
            System.out.println("Test Case 10: Calendar Constants Example");
            System.out.println("=================================================================");
            
            // Example 1: First day of week
            System.out.println("Sample Input 1: Checking first day of week");
            System.out.println("Output: First day of week should be Monday (1)");
            assertEquals("First day of week should be Monday", 1, DateTimeConstants.MONDAY);
            
            System.out.println("\nContradictory Example:");
            System.out.println("Sample Input 2: Checking if Sunday is first day of week");
            System.out.println("Output: Sunday should not be first day of week");
            assertNotEquals("Sunday should not be first day of week", 1, DateTimeConstants.SUNDAY);
            System.out.println("-----------------------------------------------------------------");
        }
    }
} 