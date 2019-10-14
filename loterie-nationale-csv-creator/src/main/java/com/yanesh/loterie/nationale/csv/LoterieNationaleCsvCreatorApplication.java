package com.yanesh.loterie.nationale.csv;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoterieNationaleCsvCreatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoterieNationaleCsvCreatorApplication.class, args);
		getDates(2018);
	}

	private static void getDates(int year) {
		LocalDate today = LocalDate.of(year, 1, 1);
		
		LocalDate firstOfThisYear = today.with(TemporalAdjusters.firstDayOfYear( ));
		LocalDate firstOfNextYear = today.with(TemporalAdjusters.firstDayOfNextYear( ));
		LocalDate firstSunday  = firstOfThisYear.with(TemporalAdjusters.dayOfWeekInMonth( 1, DayOfWeek.SUNDAY ));
		
		List<LocalDate> sundays = new ArrayList<>();
		LocalDate sunday = firstSunday;
		
		while(sunday.isBefore(firstOfNextYear)) {
			sundays.add(sunday);
			sunday = sunday.plusWeeks(1);
			System.out.println(formatDate(sunday));
		}
	}
	
	private static String formatDate(LocalDate date) {
		String sunday = date.format(DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.FRENCH));
		return updateMonth(sunday);
	}
	
	private static String updateMonth(String date) {
		date = date.replaceAll("janv.", "Jan");
		date = date.replaceAll("févr.", "Fév");
		date = date.replaceAll("mars", "Mars");
		date = date.replaceAll("avr.", "Avr");
//		date = date.replaceAll("mai", "mai");
		date = date.replaceAll("juin", "Juin");
		date = date.replaceAll("juil.", "Jui");
		date = date.replaceAll("août", "Août");
		date = date.replaceAll("sept.", "Sep");
		date = date.replaceAll("oct.", "Oct");
		date = date.replaceAll("nov.", "Nov");
		date = date.replaceAll("déc.", "Dec");
		return date;
	}
	
}
