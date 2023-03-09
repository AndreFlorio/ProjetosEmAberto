package Dates;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.ValueRange;
import java.util.Locale;

public class Exemplo1 {
    public static void main(String[] args) {
        //LocalDate.now()
        LocalDate data = LocalDate.now();
        System.out.println("LocalDate.now(): "+data);
        //LocalDate.of(Year,Month,dayOfMonth)
        LocalDate data2 = LocalDate.of(2016, 1, 1);
        System.out.println("LocalDate.isLeapYear(): "+data2.isLeapYear());
        //LocalDate.parse(String)
        String dataString = "2001-12-02";
        LocalDate data4 = LocalDate.parse(dataString);
        System.out.println("LocalDate.Parse(String): "+data4);
        //LocalDate.plusDays(), .minusDays() {Years,Months,Days}
        LocalDate amanha = data.plusDays(1);
        System.out.println("LocalDate.plusDays(): "+data);
        //String = LocalDate.format(DateTimeFormatter.ISO_DATE)
        String formatado = data.format(DateTimeFormatter.ISO_DATE);
        System.out.println("LocalDate.format(DataTimeFormatter.): "+formatado);
        //LocalDateTime = LocalDate.atTime(hour,Minute,Second)
        LocalDateTime data3 = data2.atTime(1,50,9);
        System.out.println("LocalDate.atTime(): "+data3);

        //LocalTime.now()
        LocalTime tempo = LocalTime.now();
        System.out.println("LocalTime.now(): "+tempo);
        //LocalTime.of(hour,Minute,second)
        LocalTime tempo2 = LocalTime.of(1, 43, 30);
        System.out.println("LocalTime.of(): "+tempo2);
        //LocalTime.plusMinutes(), .minusMinutes() {Hours,Minutes,Seconds}
        LocalTime tempo3 = tempo2.plusHours(2); 
        System.out.println("LocalTime.plus_(): "+tempo3);
        //ZoneId.of(_)
        ZoneId zona = ZoneId.of("America/Sao_Paulo");
        System.out.println("ZoneId.of(): "+zona);
        LocalTime tempo4 = LocalTime.now(zona);
        System.out.println("LocalTime.now(ZoneID): "+tempo4);
        //Long = ChronoUnit.{}.Between(LocalTime,LocalTime) {HOURS,MINUTES,SECONDS}
        Long diferenca = ChronoUnit.HOURS.between(tempo3, tempo4);
        System.out.println("Long = ChronoUnit.{Hours}.Between(LocalTime,LocalTime):"+diferenca);

        //LocalDateTime.now()
        LocalDateTime dataTempo = LocalDateTime.now();
        System.out.println("LocalDateTime(): "+dataTempo);
        //LocalDateTime.of(Year,Month,Day,Hour,Minutes,Seconds)
        LocalDateTime dataTempo2 = LocalDateTime.of(2017, 2, 3, 16, 5,1);
        //LocalDateTime.get(Chronofield.)
        System.out.println("LocalDateTime.get(): "+dataTempo2.get(ChronoField.DAY_OF_WEEK)); //DayofThe_{Year,month,week} minuteofday,hourofday
        //LocalDateTime.plusDays()
        LocalDateTime dataTempo3 = dataTempo2.plusDays(12);
        System.out.println("LocalDateTime.plusDays(): "+dataTempo3);
        //DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss") || String = LocalDateTime.Format(String);
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String nowFormatado = dataTempo.format(formatador);
        System.out.println("String = LocalDateTime.format(): "+nowFormatado);

        //MonthDay.now()
        MonthDay diaDoMes = MonthDay.now();
        System.out.println("MonthDay.now(): "+diaDoMes);
        //LocalDate = MonthDay.AtYear()
        LocalDate data5 = diaDoMes.atYear(1999);
        System.out.println("LocalDate/ MonthDay.atYear(): "+data5);
        //boolean = MonthDay.isValidYear()
        boolean bol = diaDoMes.isValidYear(1999);
        System.out.println("boolean = MonthDay.isValidYear(): "+bol);
        //Long = MonthDay.get(Chronofield.)
        long l =diaDoMes.get(ChronoField.MONTH_OF_YEAR);
        System.out.println("long = MonthDay.get(ChronoField): "+l);
        //ValueRange = MonthDay.range(ChronoField.)
        ValueRange Vr = diaDoMes.range(ChronoField.DAY_OF_MONTH);
        System.out.println("ValueRange = MonthDay.range(): "+Vr);
        
        //OffsetTime.now()
        OffsetTime offset = OffsetTime.now();
        System.out.println("OffsetTime.now(): "+offset);
        //int = OffsetTime.get(Chronofield.)
        int hour = offset.get(ChronoField.HOUR_OF_DAY);
        System.out.println("OffsetTime.get(Chronofield.hour):"+hour);
        //int = OffsetTime.get{}() {Hour,Minute,Second}
        int gethour = offset.getHour();
        System.out.println("OffsetTime.getHour(): "+gethour);
        
        //OffSetDateTime.now()
        OffsetDateTime offsetDate = OffsetDateTime.now();
        System.out.println("OffsetDateTime.now(): "+offsetDate);
        //OffsetDateTime.getDayOf{}() {Month,Day,Week,year}
        System.out.println("OffsetDateTime.getDayOfMonth(): "+offsetDate.getDayOfMonth());
        //OffsetDateTime.ToLocalDate()
        System.out.println("OffsetDateTime.toLocalDate(): "+offsetDate.toLocalDate());
        //OffsetDateTime.plusDays() {Minus,plus}
        OffsetDateTime offsetDate2 = offsetDate.plusDays(24);
        System.out.println("OffsetDateTime.plusDays(): "+offsetDate2);

        //Clock.systemDefaultZone()
        Clock c = Clock.systemDefaultZone();
        //Cloc.getZone()
        System.out.println("Clock.getZone(): "+c.getZone());
        //Clock.instant()**
        System.out.println("Clock.instant(): "+c.instant());
        //Clock.system.UTC
        Clock c1 = Clock.systemUTC();
        System.out.println("Clock.systemUTC: "+c1.instant());
        //Clock.offset(Clock,Duration) {Duration.ofHours()}
        Duration d = Duration.ofHours(10);
        Clock c2 = Clock.offset(c, d);
        System.out.println("Clock.offset(): "+c2.instant());

        //ZonedDateTime.parse()
        ZonedDateTime zoned = ZonedDateTime.parse("2016-10-05T08:20:10+05:30[Asia/Kolkata]");
        System.out.println("ZonedDateTime.parse()"+zoned);
        //ZonedDateTime.of(LocalDateTime,ZoneId)
        LocalDateTime LDT = LocalDateTime.of(2017,Month.JANUARY,19,16,26);
        ZoneId zoneIdIndia = ZoneId.of("Asia/Kolkata");
        ZonedDateTime zoned2 = ZonedDateTime.of(LDT,zoneIdIndia);
        System.out.println("ZoneDateTime.of(LocalDateTime,ZoneId): "+zoned2);
        //ZoneDateTime.withZoneSameInstant(Lugar)
        ZonedDateTime zoned3 = zoned.withZoneSameInstant(zoneIdIndia);
        System.out.println("ZonedDateTime.WithZoneSameInstant(): "+zoned3);
        //ZonedDateTime.getZone()
        System.out.println("ZonedDateTime.getZone(): "+zoned.getZone());
        //ZonedDateTime.minus()/.plus()
        ZonedDateTime zoned4 = zoned.minus(Period.ofDays(122));
        System.out.println("ZonadDateTime.minus(Period.of_): "+zoned4);

        //ZoneId.of()
        ZoneId zona1 = ZoneId.of("Asia/Kolkata");
        LocalTime id1 = LocalTime.now(zona1);
        System.out.println("ZoneId.of(): "+id1);
        //(ZoneId) LocalTime.isBefore(LocalTime)
        ZoneId zona2 = ZoneId.of("Asia/Tokyo");
        LocalTime id2 = LocalTime.now(zona2);
        System.out.println("ZoneId.IsBefore(ZoneId): "+id2.isBefore(id1));
        //ZoneId.systemDefault()
        ZoneId zona3 = ZoneId.systemDefault();
        System.out.println("ZoneId.system.default(): "+zona3);
        //String = ZoneId.getId()
        String s1 = zona3.getId();
        System.out.println("String = ZoneId.getId(): "+s1);
        //ZoneId.getDisplayName()
        System.out.println("ZoneId.getDisplayName(TextStyle.,Locale.): "+zona3.getDisplayName(TextStyle.FULL, Locale.ROOT));

        //Temporal = ZoneOffset.UTC.adjustInto(ZoneDateTime)
        ZoneOffset zona4 = ZoneOffset.UTC;
        Temporal tempo5 = zona4.adjustInto(ZonedDateTime.now());
        System.out.println("ZoneOffset(): "+tempo5);
        //ZoneOffset.ofHours() || ofHoursMinutes
        ZoneOffset zona5 = ZoneOffset.ofHours(5);
        System.out.println("ZoneOffset.ofHours(): "+zona5);
        //boolean = ZoneOffset.isSupported(ChronoField.)
        boolean b1 = zona4.isSupported(ChronoField.SECOND_OF_MINUTE);
        System.out.println("ZoneOffset.isSupported(ChronoField.): "+b1);

        //Year.now()
        Year ano = Year.now();
        System.out.println("Year.now(): "+ano);
        //LocalDate = Year.atDay()
        Year ano2 = Year.of(2021);
        LocalDate data6 = ano2.atDay(123);
        System.out.println("Year.atDay(): "+data6);
        //Year.length()
        System.out.println("Year.length(): "+ano2.length());
        //Year.isLeap()
        System.out.println("Year.isLeap(): "+ano2.isLeap());

        //YearMonth.now()
        YearMonth anoMes = YearMonth.now();
        System.out.println("YearMonth.now(): "+ anoMes);
        //String = YearMonth.format()
        String s2 = anoMes.format(DateTimeFormatter.ofPattern("MM yyyy"));
        System.out.println("format(DateTimeFormatter.ofPattern()): "+s2);
        //long YearMonth.get(ChronoField.)
        long l1 = anoMes.get(ChronoField.YEAR);
        System.out.println("YearMonth.get(): "+l1);
        //YearMonth.plus() || .minus()
        YearMonth anoMes2 = anoMes.plus(Period.ofYears(2));
        System.out.println("YearMonth.plus(): "+anoMes2);

        //Period.of_(){Years,Months,Days}
        Period periodo = Period.ofDays(10);
        System.out.println("Period.ofDays(): "+periodo);
        //Temporal = Period.addTo()
        Temporal tempo6 = periodo.addTo(LocalDate.now());
        System.out.println("Period.addTo(): "+tempo6);
        //Period.of()
        Period periodo2 = Period.of(2017,02,01);
        System.out.println("Period.of(): "+periodo2);
        //Period.minus() ||.plus()
        Period periodo3 = Period.ofMonths(4);
        Period periodo4 = periodo3.minus(Period.ofMonths(2));
        System.out.println("Period.minus(): "+periodo4);

        //Duration.Between(LocalTime,LocalTime)
        Duration d1 = Duration.between(LocalTime.NOON, LocalTime.MAX);
        //Duration.get(ChronoUnit.)
        System.out.println("Duration.get(ChronoUnit): "+d1.get(ChronoUnit.SECONDS));
        //Duration.isNegative()
        System.out.println("Duration.isNegative(): "+d1.isNegative());
        //Duration.minus()|| .plus()
        Duration d2 = d1.minus(d1);
        //Duration.get_() {Seconds}
        System.out.println("Duration.getSeconds(): "+d2.getSeconds());

        //Instatn.now()
        Instant inst = Instant.now();
        System.out.println("Instant.now(): "+inst);
        //Instant.parse()
        Instant inst2 = Instant.parse("2019-02-03T10:30:30.00Z");
        System.out.println("Instant.parse(): "+inst);
        //Instant.minus() || .plus()
        Instant inst3 = inst2.minus(Duration.ofDays(123));
        System.out.println("Instant.minus(): "+inst3);
        //Instant.isSupported(ChronoUnit.)
        System.out.println("Instant.isSupported(): "+inst.isSupported(ChronoUnit.DAYS));

        //DayOfWeek.from(LocalDate)
        LocalDate dataLocal = LocalDate.of(2017,Month.JANUARY,25);
        DayOfWeek dayOfWeek = DayOfWeek.from(dataLocal);
        System.out.println("DayOfWeek.from(LocalDate): "+dayOfWeek);
        //DayOfWeek.get(Chronofield.DAY_OF_WEEK)
        System.out.println("DayOfWeek.get(Chronofield.DAY_OF_WEEK): "+dayOfWeek.get(ChronoField.DAY_OF_WEEK));
        //DayOfWeek.of()
        DayOfWeek day = DayOfWeek.of(4);
        //DayOfWeek.name() .ordinal() .getValue()
        System.out.println("DayOfWeek.name(): "+day.name());
        System.out.println("DayOfWeek.ordinal(): "+day.ordinal());
        System.out.println("DayOfWeek.getValue(): "+day.getValue());
        //DayOfWeek.plus() .minus
        day = day.plus(3);
        System.out.println("DayOfWeek.plus(): "+day.getValue());
        //int = DayOfWeek.getValue()
        int valor = day.getValue();
        System.out.println("DayOfWeek.getValue(): "+valor);
        
        //Month.ValueOf()
        Month month = Month.valueOf("january".toUpperCase());
        System.out.println("Month.valueOf(): "+month);
        //Month = LocalDate.getMonth()
        Month month2 = dataLocal.getMonth();
        System.out.println("Month = LocalDate.getMonth(): "+month2);
        //Month.from(LocalDate)
        Month month3 = Month.from(LocalDate.now());
        //Month.getValue() .name()
        System.out.println("Month.from(): "+month3.getValue());
        System.out.println("Month.name(): "+month3.name());
        //Month.minus() .plus()
        Month month4 = month.minus(2);
        System.out.println("Month.minus(): "+month4);
        //Month.length(true)
        System.out.println("Month.length(true): "+month.length(true));
        
        
        
         
        
    }
}
