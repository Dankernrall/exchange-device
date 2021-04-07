import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AvailableChecker {
    List<Integer> delivery = new ArrayList<>();
    int count;

    public AvailableChecker(int value, Integer... arr) {
        Arrays.sort(arr, Collections.reverseOrder()); //Сортируем массив по убыванию,
        for (Integer integer : arr) { // для удобства
            count = value / integer; //Узнаем количество необходимых монет
            if (count != 0) {
                for (int j = 0; j < count; j++)
                    delivery.add(integer); //Записываем в массив подходящую для размена монету
            }
            value %= integer; //Остаток от предыдущего размена
        }
        if (value > 0) //Если пройдя по всем монетам, есть остаток, то размен невозможен
            System.out.println("Банкомат не может разменять данную сумму " +
                    "введенным номиналом монет!");
        else {
            System.out.println("Выдано монет:\n" + delivery
                    .toString().replace("[", "")
                    .replace("]", "") + ".");
        }
    }
}
