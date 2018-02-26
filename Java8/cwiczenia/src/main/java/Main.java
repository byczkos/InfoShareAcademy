import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Main {

    public static class CandyJar {
        private String name;
        private List<String> candies;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getCandies() {
            return candies;
        }

        public void setCandies(List<String> candies) {
            this.candies = candies;
        }

        public CandyJar(String name, List<String> candies) {
            this.name = name;
            this.candies = candies;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("CandyJar{");
            sb.append("name='").append(name).append('\'');
            sb.append(", candies=").append(candies);
            sb.append('}');
            return sb.toString();
        }
    }


    public static void main(String[] args) {


        CandyJar jar1 = new CandyJar("sloik 1",Arrays.asList("Michalki", "Raczki", "Trio", "Dumle"));
        CandyJar jar2 = new CandyJar("sloik 2", Arrays.asList("Malaga", "Tiki-taki", "Kasztanki", "Krowki"));



//        runTask(new MyTask());
//        runTask(() ->  System.out.println("Hello from MyTask"));
//        List<Integer> ints = Arrays.asList(100, 128, 512, 320, 0, -40);
//        //   WARTOSCI MAKSYMALNE
//        MathOperation maxValue = new MaxOperation();
//        System.out.printf("Max value (512) : ");
//        System.out.println(maxValue.calculate(ints));
////        getResult(ints,new MaxOperation());
////        //wyrazenia lambda wywoluje metode calculate z interfejsu MAthOperation
////        getResult(ints, (list) -> Collections.max(list));
////        // inne rozwiazanie lambdy
////        getResult(ints, integers -> {
////            Integer max = Integer.MIN_VALUE;
////            for (Integer i : integers) {
////                if(i > max) {
////                    max = i;
////                }
////            }
////            return max;
////        });
//
//        // WARTOSCI MINIMALNE
//        MathOperation minValue = new MinOperation();
//        System.out.printf("Min value (-40) : ");
//        System.out.println(minValue.calculate(ints));
//       // getResult(ints, new MinOperation());
//        // wyrazenie lambda
//       // getResult(ints, lista -> Collections.min(lista));
//
//        // usuwanie z listy elementow zawierajacych "x"
//        List<String> stringList1 = new ArrayList<>(Arrays.asList("Kurs","Java","x","jest","x","x","OK"));
//        System.out.println(stringList1);
//        stringList1.removeIf( (n) -> n =="x");
//        System.out.println(stringList1);
//
//        // usuwanie wszystkich pustych elementow listy
//        List<String> stringList = new ArrayList<>(Arrays.asList("Kurs","Java","","jest","","","OK"));
//        System.out.println(stringList);
//        stringList.removeIf( (n) -> n.isEmpty() );
//        System.out.println(stringList);
//
//        // wypisanie wszystkich elementow wielkimi literami
//        List<String> stringList2 = new ArrayList<>(Arrays.asList("Kurs","Java","jest","OK"));
//        stringList2.forEach( (element) -> System.out.println(element.toUpperCase()));
//        // odwołanie bezposrednio do metody,   REFERENCJE DO METODY
//        stringList2.forEach(System.out::println);
//
//        // wypisanie listy dlugosci stringow w innej liscie
//        Function<List<String>, List<Integer>> lengths = list -> {
//            List<Integer> result = new ArrayList<>();
//            list.forEach(s -> result.add(s.length()));
//            return result;
//        };
//        System.out.println(lengths.apply(stringList2));
//
//        // drukuje max liczbe z listy z magicznej funkcji getResult
//        getResult(Arrays.asList(23, 25, -9, 6), (list) -> Collections.max(list), (i) -> System.out.println(i));
//        // wartosc min
//        getResult(Arrays.asList(23, 25, -9, 6), (list) -> Collections.min(list), (i) -> System.out.println(i));
//
//        Samochod s = new Sedan();
//        System.out.println(" Liczba drzwi: "+s.liczbaDrzwi());

       // Dish dish = new Dish();
        List<Dish> listDish = Arrays.asList(
                new Dish("Pizza",false, 900),
                new Dish("Burrito", false, 650),
                new Dish("Kurczak z ryżem", false, 714),
                new Dish("Kaszanka", false, 469),
                new Dish("Hummus", true, 230),
                new Dish("Makaron Andrea", true, 15),
                new Dish("Apple Pie", true, 200),
                new Dish("Chleb ze smalcem", false, 350)
        );
//
        // wypisuje tylko dania wegetarianskie
        listDish.stream()
                .filter(s -> s.vegetarian == true)
                .collect(toList())
                .forEach(System.out::println);
        System.out.println( "------------");

        // zwraca trzy najbardziej kaloryczne dania  zad14
        listDish.stream()
                .sorted((s1,s2) -> s2.calories - s1.calories)
                .collect(toList())
                .subList(0,3) // mozna tez zrobic tak .limit(3)
                .forEach(System.out::println);
        // zwraca dania, ktore maja wiecej niz 500 kalorii  zad15
        System.out.println( "------------");
        listDish.stream()
                .sorted((s1,s2) -> s2.calories-s1.calories)
                .filter(d -> d.calories > 500)
                .collect(toList())
                .forEach(System.out::println);

        System.out.println( "------------");

        // Zad 16
        List<String> academyWords = Arrays.asList("hello", "academy", "java", "junior");

        List<Character> chars = academyWords
                .stream()
                .flatMapToInt(s -> s.chars())
                .mapToObj(i -> Character.valueOf((char)i))
                .distinct()
                .collect(toList());
                //.forEach(System.out::println);
        System.out.println(chars);
        System.out.println(chars.size());

        LocalDate today = LocalDate.now();
        LocalDate valentinesDay = LocalDate.parse("2018-02-14");
        System.out.println(valentinesDay);
        System.out.println(valentinesDay.toString());
        System.out.println(valentinesDay.getDayOfWeek());
        System.out.println(valentinesDay.getMonth());
        System.out.println(valentinesDay.getYear());

        LocalTime time = LocalTime.of(7,15,0);
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());
        System.out.println(time);
        System.out.println(time.toString());
        LocalTime time1 = LocalTime.parse("12:47:35");
        System.out.println(time1);

        LocalDateTime newDate = LocalDateTime.of(2017,Month.DECEMBER,21,2,34,23);
        LocalDateTime newDate1 = LocalDateTime.of(today,time);
        System.out.println(newDate.toLocalTime());
        System.out.println(newDate.toLocalDate());
        System.out.println(newDate.toString());
        System.out.println(newDate1);

        ZoneId zoneId = ZoneId.of("Africa/Cairo");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(newDate, zoneId);


        //obliczanie przedzialu czasu pomiedzy dwiema datami
        LocalDate date1 = LocalDate.of(2018,1,23);
        LocalDate date2 = LocalDate.now();

        Period period = Period.between(date1,date2);
        System.out.println("Liczba dni : "+period.getDays());
//        Duration duration = Duration.between(date1,date2);
//        System.out.println("Liczba godzin : "+duration);

        //czas wykonywania petli

//        Clock clock = Clock.systemDefaultZone();
//        long start = clock.millis();
//        for (int i = 0; i <1000000 ; i++) {
//            double d = Math.sqrt(Math.sin(i)*Math.tan(i)* new Random().nextGaussian());
//            System.out.println(d);
//        }
//        long stop = clock.millis();
//        long d = stop-start;
//        System.out.println(d+" ms");

         LocalDateTime now = LocalDateTime.of(2025,3,1,23,15,0);
         LocalDateTime saturday = now.with(TemporalAdjusters.dayOfWeekInMonth(5, DayOfWeek.SATURDAY));
         System.out.println(saturday);




        // listDish.forEach(System.out::println);
//        // sortowanie po ilosci kalorii
//        listDish.stream()
//                .sorted((s1,s2) -> s1.calories - s2.calories )
//                .collect(toList())
//                .forEach(System.out::println);
//        List<Dish> lista = listDish
//                .stream()
//                .sorted((s1,s2) -> s1.calories - s2.calories )
//                .collect(toList());
//        System.out.println(lista);
//        System.out.println(showNames(listDish));
//        System.out.println(sumOfCalories(listDish));
//
//
//
//    }
//
//    public static void getResult(List<Integer> ints, Function<List<Integer>, Integer> list, Consumer<Integer> consumer){
//        Integer result = list.apply(ints);
//        consumer.accept(result);
//    }
//
//    public static void runTask(Runnable r) {
//        r.run();
//    }
//
//    // zwraa liste nazw dań
//    public static List<String> showNames(List<Dish> dishes) {
//        return dishes.stream()
//                .map(Dish::getName)
//                // .map( s -> s.getName())
//                .sorted()
//                .collect(toList());
//    }
//
//    public static int sumOfCalories(List<Dish> dishes) {
//        return dishes.stream()
//                .map(Dish::getCalories)
//                .reduce(0,(s1,s2)-> s1+s2);
//        // mapToInt    ciekawa funkcja
    }
    // ta funkcja tez wypisuje tablice dlugosci integerow
    //    public static List<Integer> getLenghts (List<String> stringList2) {
    //        List<Integer> result = new ArrayList<>();
    //        stringList2.forEach(s -> result.add(s.length()));
    //        return result;
    //    }

}
