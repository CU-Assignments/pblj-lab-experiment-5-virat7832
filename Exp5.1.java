import java.util.ArrayList;
import java.util.List;

public class SumCalculator {
    public static Integer parseStringToInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + str);
            return null; 
        }
    }

    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer num : numbers) {
            if (num != null) { 
                sum += num; 
            }
        }
        return sum;
    }


    public static void main(String[] args) {
      
        List<Integer> list1 = new ArrayList<>();
        list1.add(10); 
        list1.add(20);
        list1.add(30);
        list1.add(parseStringToInteger("40"));
        list1.add(parseStringToInteger("50"));

        System.out.println("Test Case 1 Output: The sum of the list is: " + calculateSum(list1));

        List<Integer> list2 = new ArrayList<>();
        list2.add(parseStringToInteger("100"));
        list2.add(parseStringToInteger("200"));
        list2.add(parseStringToInteger("300"));

        System.out.println("Test Case 2 Output: The sum of the list is: " + calculateSum(list2));

        List<Integer> list3 = new ArrayList<>();
        list3.add(parseStringToInteger("50"));
        list3.add(parseStringToInteger("invalid")); // Invalid input
        list3.add(parseStringToInteger("70"));

        System.out.println("Test Case 3 Output: The sum of the list is: " + calculateSum(list3));
    }
}


