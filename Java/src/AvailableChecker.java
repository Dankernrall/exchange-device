import java.util.ArrayList;
import java.util.List;

public class AvailableChecker {
    List<Integer> delivery = new ArrayList<>();
    int count;
    int tmp; // Храним изначальное количество монет
    int whatDel = 0; // Переменная для поэтапного удаления чисел массива

    public void check(int value, int[] arr) {
        try {
            tmp = value;
            for (Integer integer : arr) {
                if (integer != 0) {
                    count = value / integer; //Узнаем количество необходимых монет
                    for (int j = 0; j < count; j++)
                        delivery.add(integer); //Записываем в массив подходящую для размена монету
                    value %= integer;
                }
            }
            if (value > 0) { // Если не удалось разменять, то пробуем заново, удаляя
                arr[whatDel] = 0; // максимальный элемент массива
                whatDel++;
                delivery.clear();  // Очищаем неправильный размен
                check(tmp, arr);
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
