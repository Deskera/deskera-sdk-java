package com.deskera.sdk.common.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

@Log4j2
public final class DateUtil {

  public static final String DD_MM_YYYY = "dd-MM-yyyy";
  public static final String YYYY_MM_dd = "yyyy-MM-dd";
  public static final String DEFAULT_DATE_FORMAT = DD_MM_YYYY;

  public static final String HYPHEN_MMDDYYYY = "MM-dd-yyyy";
  public static final String HYPHEN_MMDDYYYY_REGEX = "(0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])[-](19|20)\\d\\d";

  public static final String SLASH_MMDDYYYY = "MM/dd/yyyy";
  public static final String SLASH_MMDDYYYY_REGEX = "(0[1-9]|1[012])[/](0[1-9]|[12][0-9]|3[01])[/](19|20)\\d\\d";

  public static final String DOT_MMDDYYYY = "MM.dd.yyyy";
  public static final String DOT_MMDDYYYY_REGEX = "(0[1-9]|1[012])[.](0[1-9]|[12][0-9]|3[01])[.](19|20)\\d\\d";

  public static final String HYPHEN_DDMMYYYY = DD_MM_YYYY;
  public static final String HYPHEN_DDMMYYYY_REGEX = "(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-](19|20)\\d\\d";

  public static final String SLASH_DDMMYYYY = "dd/MM/yyyy";
  public static final String SLASH_DDMMYYYY_REGEX = "(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19|20)\\d\\d";

  public static final String DOT_DDMMYYYY = "dd.MM.yyyy";
  public static final String DOT_DDMMYYYY_REGEX = "(0[1-9]|[12][0-9]|3[01])[.](0[1-9]|1[012])[.](19|20)\\d\\d";

  public static final String HYPHEN_YYYYMMDD = "yyyy-MM-dd";
  public static final String HYPHEN_YYYYMMDD_REGEX = "(19|20)\\d\\d[-](0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])";

  public static final String SLASH_YYYYMMDD = "yyyy/MM/dd";
  public static final String SLASH_YYYYMMDD_REGEX = "(19|20)\\d\\d[/](0[1-9]|1[012])[/](0[1-9]|[12][0-9]|3[01])";

  public static final String DOT_YYYYMMDD = "yyyy.MM.dd";
  public static final String DOT_YYYYMMDD_REGEX = "(19|20)\\d\\d[.](0[1-9]|1[012])[.](0[1-9]|[12][0-9]|3[01])";

  private static final Map<String, String> DATE_FORMAT_REGEXPS = new HashMap<String, String>() {{
    put(HYPHEN_MMDDYYYY_REGEX, HYPHEN_MMDDYYYY);
    put(SLASH_MMDDYYYY_REGEX, SLASH_MMDDYYYY);
    put(DOT_MMDDYYYY_REGEX, DOT_MMDDYYYY);

    put(HYPHEN_DDMMYYYY_REGEX, HYPHEN_DDMMYYYY);
    put(SLASH_DDMMYYYY_REGEX, SLASH_DDMMYYYY);
    put(DOT_DDMMYYYY_REGEX, DOT_DDMMYYYY);

    put(HYPHEN_YYYYMMDD_REGEX, HYPHEN_YYYYMMDD);
    put(SLASH_YYYYMMDD_REGEX, SLASH_YYYYMMDD);
    put(DOT_YYYYMMDD_REGEX, DOT_YYYYMMDD);

  }};

  @Deprecated
  public static Date getStartOfMonthOneYearAgo() {
    final Calendar c = Calendar.getInstance();
    c.set(Calendar.HOUR_OF_DAY, 0);
    c.set(Calendar.MINUTE, 0);
    c.set(Calendar.SECOND, 0);
    c.set(Calendar.MILLISECOND, 0);
    c.set(Calendar.DAY_OF_MONTH, 1);
    c.set(Calendar.MONTH, c.get(Calendar.MONTH) + 1);
    c.add(Calendar.YEAR, -1);
    return c.getTime();
  }


  public static Date getStartOfMonthOneYearAgoNew() {
    return convertLocalDateToDate(getStartOfMonthOneYearAgoLDNew());
  }

  private static LocalDate getStartOfMonthOneYearAgoLDNew() {
    return LocalDate.now()
        .withDayOfMonth(1)
        .plus(1, ChronoUnit.MONTHS)
        .minus(1, ChronoUnit.YEARS);
  }


  @Deprecated
  public static Date getStartOfCurrentMonth() {
    final Calendar c = Calendar.getInstance();
    c.set(Calendar.HOUR_OF_DAY, 0);
    c.set(Calendar.MINUTE, 0);
    c.set(Calendar.SECOND, 0);
    c.set(Calendar.MILLISECOND, 0);
    c.set(Calendar.DAY_OF_MONTH, 1);
    c.set(Calendar.MONTH, c.get(Calendar.MONTH));
    return c.getTime();
  }

  public static Date getStartOfCurrentMonthNew() {
    return convertLocalDateToDate(getStartOfCurrentMonthLDNew());
  }

  private static LocalDate getStartOfCurrentMonthLDNew() {
    return LocalDate.now().withDayOfMonth(1);
  }

  public static Date getStartOfCurrentYear() {
    return convertLocalDateToDate(LocalDate.now().withDayOfMonth(1).withMonth(1));
  }

  /**
   * Get start of the month one year ago in requested data format.
   *
   * @param dateFormat Date format.
   * @return Date in the requested format.
   * @throws IllegalAccessException Will throw the exception in case date format not provided.
   */
  @Deprecated
  public static String getStartOfMonthOneYearAgo(final String dateFormat)
      throws IllegalAccessException {
    if (StringUtils.isEmpty(dateFormat)) {
      throw new IllegalAccessException("Date format cannot be null");
    }

    final DateFormat format = new SimpleDateFormat(dateFormat);
    return format.format(getStartOfMonthOneYearAgo());
  }


  public static String getStartOfMonthOneYearAgoNew(final String dateFormat) {
    Assert.notNull(dateFormat, "Date format cannot be null");
    return getStartOfMonthOneYearAgoLDNew().format(DateTimeFormatter.ofPattern(dateFormat));
  }

  /**
   * Get start of the month one year ago. Date string format is dd-MM-yyyy
   *
   * @return Date in dd-MM-yyyy format.
   */
  @Deprecated
  public static String getStartOfMonthOneYearAgoDefaultFormat() {
    final DateFormat format = new SimpleDateFormat(DD_MM_YYYY);
    return format.format(getStartOfMonthOneYearAgo());
  }

  public static String getStartOfMonthOneYearAgoDefaultFormatNew() {
    return getStartOfMonthOneYearAgoNew(DEFAULT_DATE_FORMAT);
  }

  public static Date convertLocalDateToDate(final LocalDate localDateToConvert) {
    return Date.from(localDateToConvert.atStartOfDay(ZoneId.systemDefault()).toInstant());
  }

  public static Date convertDateWithFormat(final String date, final String dateFormat) {
    return convertLocalDateToDate(LocalDate.parse(date, DateTimeFormatter.ofPattern(dateFormat)));
  }

  public static LocalDate convertDateToLocalDate(final Date dateToConvert) {
    return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  }

  public static String formatDateWithFormat(final Date date, final String dateFormat)
      throws IllegalAccessException {
    if (StringUtils.isEmpty(dateFormat)) {
      throw new IllegalAccessException("Date format cannot be null");
    }

    if (date == null) {
      throw new IllegalAccessException("Date cannot be null");
    }

    final DateFormat format = new SimpleDateFormat(dateFormat);
    return format.format(date);
  }

  public static Date getStartOfCurrentQuarter() {
    final LocalDate localDate = LocalDate.now();
    return convertLocalDateToDate(localDate.with(localDate.getMonth().firstMonthOfQuarter())
        .with(TemporalAdjusters.firstDayOfMonth()));
  }

  public static Date getStartOfCurrentWeek() {
    return convertLocalDateToDate(
        LocalDate.now().with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1L));
  }

  /**
   * Determine SimpleDateFormat pattern matching with the given date string. Returns null if format
   * is unknown.
   *
   * @param dateString The date string to determine the SimpleDateFormat pattern for.
   * @return The matching SimpleDateFormat pattern, or null if format is unknown.
   */
  public static String determineDateFormat(final String dateString) {
    for (String regexp : DATE_FORMAT_REGEXPS.keySet()) {
      if (dateString.toLowerCase().matches(regexp)) {
        return DATE_FORMAT_REGEXPS.get(regexp);
      }
    }
    return null; // Unknown format.
  }

  /**
   * Determine regex pattern matching with the given date format. Returns null if format
   * is unknown.
   *
   * @param dateFormat The date format.
   * @return The regex of format string, or null if format is unknown.
   */
  public static String determineRegexFromDateFormat(final String dateFormat){
    final Optional<String> format =  DATE_FORMAT_REGEXPS.entrySet()
        .stream()
        .filter(e -> dateFormat.equals(e.getValue()))
        .map(Entry::getKey)
        .findFirst();
    return format.isPresent() ? format.get() : null;
  }

  /**
   * Determine most common date format used in set of dates.
   *
   * @param dates The dates set
   * @return most common used date format.
   */

  public static String determineDateFormatFromDates(final List<String> dates) {
    final List<String> identifiedDateFormats = dates.stream()
        .map(s -> DateUtil.determineDateFormat(s))
        .collect(Collectors.toList());
    final String dateFormat = DateUtil.mostCommon(identifiedDateFormats);
    return ObjectUtils.isNotEmpty(dateFormat) ? dateFormat : HYPHEN_DDMMYYYY;

  }

  /**
   * This method return the most common item in a List
   *
   * @param list Input list
   * @return most common item.
   */
  public static <T> T mostCommon(final List<T> list) {
    final Map<T, Integer> map = new HashMap<>();

    for (T t : list) {
      Integer val = map.get(t);
      map.put(t, val == null ? 1 : val + 1);
    }

    Entry<T, Integer> max = null;

    for (Entry<T, Integer> e : map.entrySet()) {
      if (max == null || e.getValue() > max.getValue()) {
        max = e;
      }
    }
    return max.getKey();
  }


  /**
   * This method format the date in required date format and return date as string.
   *
   * @param inputDate          Input date as string
   * @param inputDateFormat    date format of input date string
   * @param requiredDateFormat required date format
   * @return date as string.
   */
  public static String formatDateString(final String inputDate, final String inputDateFormat,
      final String requiredDateFormat) {
    try {
      final Date date = new SimpleDateFormat(inputDateFormat).parse(inputDate);
      return new SimpleDateFormat(requiredDateFormat).format(date);
    } catch (final ParseException e) {
      log.error("Exception occurred at formatDateString : {{}}", e);
      return StringUtils.EMPTY;
    }
  }

}
