package com.kp.algorithms;

import java.awt.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Objects;

import com.kp.objects.Car;
import com.kp.objects.Range;

public class Solution {

   public static void main(String[] args) throws CloneNotSupportedException {
      ArraysExample arraysExample = new ArraysExample();
      int[] nums = new int[0];
      arraysExample.findMaxConsecutiveOnes(nums);
      Range range = new Range(100);
      System.out.println(range.yMinusX(40, 30));

      Car card1 = new Car("Jetour", Color.blue);
      Car card2 = new Car("Jetour", Color.blue);

      if (Objects.equals(card1, card2)) {
         System.out.println("The same objects");
      }
      Car clone = card1.clone();
      if (Objects.equals(clone, card1)) {
         System.out.println("The same objects");
      }



      LocalDate localDate = LocalDate.now();
      LocalDate localDate1 = LocalDate.parse("2020-06-01");

      DateTimeFormatter zonedDateTimeFormatter
            = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm:ssXXXXX '['VV']'")
                               .withZone(ZoneId.of("Europe/Paris"));

      ZonedDateTime zonedDateTime
            = ZonedDateTime.parse("2020-06-01T10:15:30+09:00[Asia/Tokyo]");

      // yyyy-MM-dd
      LocalDate localDate3 = LocalDate.now();
      DateTimeFormatter formatterLocalDate
            = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      String stringLD = formatterLocalDate.format(localDate);

      // or shortly
      String stringLD5 = LocalDate.now()
                                 .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

      Instant twoHourLater = Instant.now().plus(2, ChronoUnit.HOURS);
      Instant tenMinutesEarlier = Instant.now()
                                         .minus(10, ChronoUnit.MINUTES);

      Instant timestamp1 = Instant.now();
      Instant timestamp2 = timestamp1.plusSeconds(10);
      // 10 seconds
      long difference = timestamp1.until(timestamp2, ChronoUnit.SECONDS);

      LocalDate date = LocalDate.of(2019, Month.FEBRUARY, 27);

      // 2019-02-01
      LocalDate firstDayOfFeb
            = date.with(TemporalAdjusters.firstDayOfMonth());

      // 2019-02-28
      LocalDate lastDayOfFeb
            = date.with(TemporalAdjusters.lastDayOfMonth());
   }
}