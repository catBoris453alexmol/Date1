package ru.sapteh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Program {
    public static void main(String[] args) throws IOException, ParseException {

        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        Date dateToday = calendar.getTime();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите дату экзамена в таком формате: dd.MM.yy");
        String strExam = reader.readLine();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
        Date dateExam = dateFormat.parse(strExam);
        int quantityDays = (int) ((dateExam.getTime() - dateToday.getTime()) / 24 / 60 / 60 / 1000);
        int quantityMonths = 0;
        int months = 0;
        int years = 0;

        System.out.println(quantityDays);

        if (quantityDays >= 30) {
            quantityMonths = quantityDays / 30;
            if (quantityMonths >= 12) {
                months = quantityMonths % 12;
                years = Math.abs(quantityMonths) / 12;
            }
        }

        if (quantityDays <= -30) {
            quantityMonths = quantityDays / 30;
            if (quantityMonths <= -12) {
                months = quantityMonths % 12;
                years = Math.abs(quantityMonths) / 12;
            }
        }

        String result = switch (dateExam.compareTo(dateToday)) {
            default -> "Неккоректные данные";
            case 0 -> "Экзамен сегодня";
            case 1 -> "Экзамен будет через " + quantityDays % 30 + " " + days(quantityDays) + ", " + months + strExa(quantityMonths) + ", " + years + strExam(years);
            case -1 -> "После экзамена прошло" + " " + Math.abs(quantityDays % 30) + " " + days(quantityDays) + ", " + Math.abs(months) + strExam(quantityMonths) + ", " + years + strExam(years);
        };
        System.out.println(result);
    }

    public static String days(int a) {
        return switch (Math.abs(a)) {
            case 1 -> "день";
            case 2, 3, 4 -> "дня";
            default -> "дней";
        };
    }
    public static String strExa(int month){
        return switch (Math.abs(month % 10)){
            case 1 -> " Месяц";
            case 2, 3, 4 -> " Месяца";
            default -> " Месяцев";
        };
    }
    public static String strExam(int year) {
        return switch (Math.abs(year % 10)) {
            case 1 -> " год";
            case 2, 3, 4 -> " года";
            default -> " лет";
        };
    }
}

