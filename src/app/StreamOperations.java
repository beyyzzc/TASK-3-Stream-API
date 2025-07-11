package app;
import java.util.List;
import java.util.Arrays;
import model.User;
import service.UserService;
import service.UserServiceImpl;

import java.util.*;
import java.util.stream.*;

public class StreamOperations {
    public static void main(String[] stmts) {
        // Kullanıcı listesi
        List<User> users = Arrays.asList(
                new User("Ali", 25),
                new User("Ayşe", 15),
                new User("Mehmet", 30)
        );

        // UserService kullanımı
        UserService service = new UserServiceImpl();
        List<String> adults = service.getNamesOfAdults(users);
        System.out.println("Adults: " + adults);

        // Sayı işlemleri
        List<Integer> numbers = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
        int max = numbers.stream().max(Integer::compare).get();
        int min = numbers.stream().min(Integer::compare).get();
        System.out.println("Max: " + max + ", Min: " + min);

        long listDivBy2and4 = numbers.stream().filter(n -> n % 2 == 0 && n % 4 == 0).count();
        System.out.println("Divisible by 2 and 4: " + listDivBy2and4);

        long totalEven = numbers.stream().filter(n -> n % 2 == 0).count();
        long sumEven = numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println("Even Count: " + totalEven + ", Even Sum: " + sumEven);

        long totalOdd = numbers.stream().filter(n -> n % 2 != 0).count();
        long sumOdd = numbers.stream().filter(n -> n % 2 != 0).mapToInt(Integer::intValue).sum();
        System.out.println("Odd Count: " + totalOdd + ", Odd Sum: " + sumOdd);

        // İsim işlemleri
        List<String> names = Arrays.asList("Jackson", "Edward", "Allie", "Sam", "Edie");
        long startsWithE = names.stream().filter(name -> name.startsWith("E")).count();
        System.out.println("Names starting with E: " + startsWithE);
    }
}
