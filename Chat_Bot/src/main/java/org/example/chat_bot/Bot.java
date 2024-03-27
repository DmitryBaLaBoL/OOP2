package org.example.chat_bot;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

public class Bot {

    // Для проверки на разное приветствие
    private static final String CheckHello = ".*[П|п][Р|р][И|и][В|в].*[Б|б][О|о][Т|т].*";
    private static final String CheckBye = ".*[П|п][О|о][К|к][А|а].*[Б|б][О|о][Т|т].*";
    private static final String CheckTime = ".*[К|к][О|о][Т|т][О|о][Р|р].*[Ч|ч][А|а][С|с]\\??.*";
    private static final String CheckDate = ".*[К|к][А|а][К|к][О|о].*[Ч|ч][И|и][С|с][Л|л]\\??.*";
    private static final String CheckWeekDay = ".*[Д|д][Е|е][Н|н].*[Н|н][Е|е][Д|д][Е|е][Л|л]\\??.*";
    private static final String CheckAllMessages = ".*[С|с][К|к][О|о][Л|л][Ь|ь][К|к].*[М|м][Ы|ы].*[С|с][О|о][О|о][Б|б][Щ|щ][Е|е][Н|н]\\??.*";
    private static final String CheckIMessage = ".*[С|с][К|к][О|о][Л|л][Ь|ь][К|к].*[Я|я].*[С|с][О|о][О|о][Б|б][Щ|щ][Е|е][Н|н]\\??.*";
    private static final String CheckBotMessage = ".*[С|с][К|к][О|о][Л|л][Ь|ь][К|к].*[Т|т][Ы|ы].*][С|с][О|о][О|о][Б|б][Щ|щ][Е|е][Н|н]\\??.*";
    private static final String CheckMul = ".*[У|у][М|м][Н|н][О|о][Ж|ж].*[0-9\\.]+.*[Н|н][А|а].*[0-9\\.]+.*";
    private static final String CheckDiv = ".*[Р|р][А|а][З|з][Д|д][Е|е][Л|л].*[0-9\\.]+.*[Н|н][А|а].*[0-9\\.]+.*";
    private static final String CheckSum = ".*[С|с][Л|л][О|о][Ж|ж][И|и].*[0-9\\.]+.*[И|и].*[0-9\\.]+.*";
    private static final String CheckSub = ".*[Вв][Ыы][Чч][Тт].*[0-9\\.]+.*[Ии][Зз].*[0-9\\.]+.*";
    private static final String CheckNumber = "\\s?[0-9\\.]+\\s?";
    private static final String CheckWeather = ".*[К|к][А|а][К|к][А|а][Я|я].*[П|п][О|о][Г|г][О|о][Д|д].*";
    private static final String CheckCourseUSD = ".*[К|к][У|у][Р|р][С|с].*[Д|д][О|о][Л|л][Л|л][А|а][Р|р].*";
    private static final String CheckPicture = ".*[С|с][К|к][А|а][Ч|ч][А|а].*[К|к][А|а][Р|р][Т|т][И|и][Н|н][К|к].*";
    private static final String CheckHelp = ".*[П|п][О|о][М|м][О|о][Щ|щ].*";

    public static String BotThink(String message, Date date,int CountMessages) throws IOException {

        if (message.matches(CheckHelp)){
            return "'Бот может:\n" +
                    " - Сказать время\n" +
                    " - Сказать число\n" +
                    " - Сказать день недели\n" +
                    " - Сказать сколько всего сообщений было отправлено\n" +
                    " - Умножить, поделить, сложить и разделить\n" +
                    " - Сказать погоду\n" +
                    " - Сказать курс валюты доллара\n" +
                    " - Скачать картинку с APOD '";
        }

        if (message.matches(CheckHello)){
            return HelloBot();
        }

        if (message.matches(CheckBye)){
            return ByeBot();
        }

        if (message.matches(CheckTime)){
            return TimeBot(date);
        }

        if (message.matches(CheckDate)){
            return DateBot(date);
        }

        if (message.matches(CheckWeekDay)){
            return DayWeekBot(date);
        }

        if (message.matches(CheckAllMessages)){
            return Integer.toString(CountMessages + 1);
        }

        if (message.matches(CheckIMessage)){
            return Integer.toString(CountMessages / 2 + 1);
        }

        if (message.matches(CheckBotMessage)){
            return CountMessages / 2 + 1 + " включая это))";
        }

        if (message.matches(CheckMul)){
            return MultiplicationBot(message);
        }

        if (message.matches(CheckDiv)){
            return DivisionBot(message);
        }

        if (message.matches(CheckSum)){
            return SumBot(message);
        }

        if (message.matches(CheckSub)){
            return SubtractionBot(message);
        }

        if (message.matches(CheckWeather)){
            return WeatherBot(message);
        }

        if (message.matches(CheckCourseUSD)){
            return CourseBot();
        }

        if (message.matches(CheckPicture)){
            DownloadPictureApodBot(date);
            return "Скачано";
        }

        return "Что-то на непонятном, напиши помощь, чтобы узнать, что может этот бот!";
    }

    // Приветствие с ботом
    public static String HelloBot(){
        int i = (int)(Math.random() * 4);
        return switch (i) {
            case 1 -> "Привет, человек!";
            case 2 -> "Здравствуй";
            case 3 -> "Здравсвуй, дорогой!";
            case 4 -> "Приветствую";
            default -> "Привет!";
        };
    }

    // Прощание с ботом
    public static String ByeBot(){
        int i = (int)(Math.random() * 4);
        return switch (i) {
            case 1 -> "Пока, человек!";
            case 2 -> "До свидания";
            case 3 -> "До свидания, дорогой!";
            case 4 -> "Бай бай)";
            default -> "Пока(((";
        };
    }

    // Возвращает сколько сейчас времени по шаблону "HH:mm"
    public static String TimeBot(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(date);

    }

    // Возвращает дату по шаблону "dd.MM.YY"
    public static String DateBot(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy");
        return formatter.format(date);

    }

    // Возвращает день недели по шаблону "dd EEEE"
    public static String DayWeekBot(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
        return "Сегодня " + formatter.format(date);

    }

    // Операция умножения ботом
    public static String MultiplicationBot(String message){
        StringTokenizer tokenizer = new StringTokenizer(message);
        double result = 1;
        String BetWeen = "";

        int CountTokens = tokenizer.countTokens();

        for (int i = 1;i <= CountTokens;i++){
            BetWeen = tokenizer.nextToken();
            if (BetWeen.matches(CheckNumber)){
                result = result * Double.parseDouble(BetWeen);
            }
        }
        return Double.toString(result);
    }

    // Операция деления ботом
    public static String DivisionBot(String message){
        StringTokenizer tokenizer = new StringTokenizer(message);
        double second = 0,ferst = 0,check = 0;
        String BetWeen = "";

        int CountTokens = tokenizer.countTokens();

        for (int i = 1;i <= CountTokens;i++){
            BetWeen = tokenizer.nextToken();
            if (BetWeen.matches(CheckNumber)){
                if (check == 0){
                    ferst = Double.parseDouble(BetWeen);
                    check++;
                }else{
                    second = Double.parseDouble(BetWeen);
                }
            }
        }
        return Double.toString(ferst/second);
    }

    // Операция суммы ботом
    public static String SumBot(String message){
        StringTokenizer tokenizer = new StringTokenizer(message);
        double result = 0;
        String BetWeen = "";

        int CountTokens = tokenizer.countTokens();
        //http://api.openweathermap.org/data/2.5/find?q=Petersburg&type=like&APPID=8521803bf05ecdbc06f418e022fbe365
        for (int i = 1;i <= CountTokens;i++){
            BetWeen = tokenizer.nextToken();
            if (BetWeen.matches(CheckNumber)){
                result = result + Double.parseDouble(BetWeen);
            }
        }
        return Double.toString(result);
    }

    // Операция вычитания ботом
    public static String SubtractionBot(String message){
        StringTokenizer tokenizer = new StringTokenizer(message);
        double second = 0,ferst = 0,check = 0;
        String BetWeen = "";

        int CountTokens = tokenizer.countTokens();

        for (int i = 1;i <= CountTokens;i++){
            BetWeen = tokenizer.nextToken();
            if (BetWeen.matches(CheckNumber)){
                if (check == 0){
                    ferst = Double.parseDouble(BetWeen);
                    check++;
                }else{
                    second = Double.parseDouble(BetWeen);
                }
            }
        }
        return Double.toString(second - ferst);
    }

    // Считывание погоды
    public static String WeatherBot(String message){
        String BetWeen = getUrlContent("http://api.openweathermap.org/data/2.5/find?q=Chita&type=like&APPID=8521803bf05ecdbc06f418e022fbe365");
        String Result = "";
        if (!BetWeen.isEmpty()){
            JSONObject object = new JSONObject(BetWeen);
            double temp = object.getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp");
            double feels_temp = object.getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("feels_like");
            Result = "Температура: " + temp + " Ощущается: " + feels_temp;
        }

        return Result;
    }

    // Обработка URL адреса и получение данных с него
    private static String getUrlContent(String urlAdress) {
        StringBuilder content = new StringBuilder();

        try {
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;

            while((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch(Exception e) {
            System.out.println("Такой город был не найден!");
        }
        return content.toString();
    }

    // Считывание курса доллара
    private static String CourseBot(){
        String Courses = getUrlContent("https://www.cbr-xml-daily.ru/daily_json.js");
        String ResultCourse= "";
        if (!Courses.isEmpty()){
            JSONObject MainObjectCourses = new JSONObject(Courses);
            ResultCourse = ResultCourse + MainObjectCourses.getJSONObject("Valute").getJSONObject("USD").getDouble("Value");
        }
        return "Курс доллара: " + ResultCourse + " руб.";

    }

    // Скачивание картинки с Apod
    private static void DownloadPictureApodBot(Date date) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        //String a = formatter.format(date);
        String a = "240327";
        String Result = getUrlContent("https://apod.nasa.gov/apod/ap" + a + ".html");

        Pattern pattern = Pattern.compile("<a href=\"image.+\"");
        Matcher matcher = pattern.matcher(Result);
        String End = "";
        while (matcher.find()) {
            End = Result.substring(matcher.start(), matcher.end());
        }

        URL url = new URL("https://apod.nasa.gov/apod/"+End.substring(9,End.length() - 1));
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Дмитрий\\OOP\\Chat_Bot\\logo.png");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);//C:\Users\Дмитрий\OOP\Test
        fos.close();
        rbc.close();

    }

}
