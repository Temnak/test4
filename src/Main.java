import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        // читаем данные файлов
        try {
            Scanner scanner = new Scanner(new File(args[0]), "UTF-8");
            while (scanner.hasNext()) {
                nums.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //сумма всех чисел массива
        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        // среднее арифметическое
        int average = Math.round((float) sum / nums.size());
        int countSteps = 0;
        //приводим все элементы к одному числу
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) != average) {
                while (nums.get(i) != average) {
                    if (nums.get(i) > average) {
                        nums.set(i, nums.get(i) - 1);
                    } else if (nums.get(i) < average) {
                        nums.set(i, nums.get(i) + 1);
                    }
                    countSteps++;
                }
            }
        }
        System.out.println(countSteps);
    }
}
