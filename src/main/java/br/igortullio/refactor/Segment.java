package br.igortullio.refactor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Segment {

  public final int distance;
  public final DayOfWeek dayOfWeek;
  public final LocalDate date;
  public final LocalTime time;
  public final int hour;

  public Segment(int distance, LocalDateTime dateTime) {
    if (isDistanceInvalid(distance)) throw new IllegalArgumentException("Distance is invalid");
    if (isDateInvalid(dateTime)) throw new IllegalArgumentException("Date is invalid");

    this.distance = distance;
    this.dayOfWeek = dateTime.getDayOfWeek();
    this.date = dateTime.toLocalDate();
    this.time = dateTime.toLocalTime();
    this.hour = dateTime.toLocalTime().getHour();
  }

  public boolean isOvernight() {
    return hour >= 22 || hour <= 6;
  }

  public boolean isNoon() {
    return hour >= 12 && hour <= 13;
  }

  public boolean isSunday() {
    return dayOfWeek.getValue() == 7;
  }

  public boolean isFriday() {
    return dayOfWeek.getValue() == 5;
  }

  public LocalDateTime getDateTime() {
    return LocalDateTime.of(date, time);
  }

  private static boolean isDistanceInvalid(int distance) {
    return distance <= 0;
  }

  private static boolean isDateInvalid(LocalDateTime dateTime) {
    return Objects.isNull(dateTime);
  }

}
