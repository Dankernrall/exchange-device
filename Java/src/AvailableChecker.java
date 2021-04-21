import java.util.ArrayList;
import java.util.List;

public class AvailableChecker {
    List<Integer> delivery = new ArrayList<>();
    int count;
    int tmp;
    int k = 0;
    int[] test;

    public void AvailableChecker(int value, int[] arr) {
        try {
            test = arr;
            tmp = value;
            for (Integer integer : arr) {
                if (integer != 0) {
                    count = value / integer; //Узнаем количество необходимых монет
                    for (int j = 0; j < count; j++)
                        delivery.add(integer); //Записываем в массив подходящую для размена монету
                    value %= integer;
                }
            }
            if (value > 0) {
                test[k] = 0;
                k++;
                delivery.clear();
                AvailableChecker(tmp, test);
            } else {
                System.out.println("Выдано монет:\n" + delivery
                        .toString().replace("[", "")
                        .replace("]", "") + ".");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Невозможно разменять " + tmp + "Р набранными монетами.");
        }
    }
}
