import java.util.HashMap;
import java.util.TreeSet;

public class ExchangeDevice {

    //введем список из неповторяющихся значений, который будет отсортирован для удобства
    TreeSet<Integer> dataSet = new TreeSet<>();

    //в конструктор передаем Любое количество целых чисел
    public ExchangeDevice(int ... count){
        //заполняем этими целыми числами dataSet
        for (int i:count){
            dataSet.add(i);
        }
        //сортируем dataSet в обратном порядке
        dataSet = (TreeSet<Integer>) dataSet.descendingSet();
    }

    //метод, в который передается рабочая сумма
    public String exchange(int money) {
        int countMoneyWork = 0; //количество монет на Данном проходе цикла
        int countMoneyResult = Integer.MAX_VALUE; // количество монет при минимальном проходе цикла
        int moneyWork = money; //условно делаем из money "константу"
        HashMap<Integer, Integer> hashMapResult = new HashMap<>(); //задаем итоговую мапу монет и их количества
        HashMap<Integer, Integer> hashMapWork = new HashMap<>(); //задаем "рабочую" мапу монет и их количества
        while (dataSet.size() != 0) { //пока dataSet не равен нулю
            for (int i : dataSet) { //перебираем значения dataSet, начиная с большего
                while (moneyWork - i > -1) { //вычитаем, пока число положительное
                    try {
                        hashMapWork.put(i, hashMapWork.get(i) + 1); //заполняем рабочую мапу
                    } catch (NullPointerException e) {
                        hashMapWork.put(i, 1); //заполняем рабочую мапу
                    }
                    moneyWork -= i; //вычитаем "по-настоящему"
                }
            }
            for (int i : hashMapWork.keySet()) { //узнаем текущее количество монет
                countMoneyWork += hashMapWork.get(i); // и записываем в рабочее число
            }
            //если в итоге у нас получилось получить "итоговое число" в этом проходе
            if (moneyWork == 0 & countMoneyWork < countMoneyResult) {
                hashMapResult.clear(); //очищаем прошлое заполнение мапы результата
                for (int i : hashMapWork.keySet()) { //заполняем мапу результата рабочей мапой
                    hashMapResult.put(i, hashMapWork.get(i));
                }
                countMoneyResult = countMoneyWork; //обновляем значение результата
            }
            dataSet.remove(dataSet.first()); // удаляем первый элемент, чтобы цикл работал
            moneyWork = money; //возвращаем исходное значение moneyWork
            hashMapWork.clear(); //очищаем рабочую мапу
            countMoneyWork = 0; //обнуляем рабочую переменную
        }

        if (hashMapResult.size() == 0){
            return "Невозможно получить из полученного набора введенное значение.";
        }

        StringBuilder output = new StringBuilder();
        for(int i : hashMapResult.keySet()) {
            int count = hashMapResult.get(i)%100;
            //склонения
            output.append(hashMapResult.get(i)).append(((count>4 & count<21) | (count%10 > 4))?(" монет по "):(count%10 == 1)?(" монета по "):(" монеты по ")).append(i).append(" руб.\n");
        }
        return output.toString();
    }
}
