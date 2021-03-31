import java.util.HashMap;
import java.util.TreeSet;

public class ExchangeDevice {

    TreeSet<Integer> dataSet = new TreeSet<>();

    public ExchangeDevice(int ... count){
        for (int i:count){
            dataSet.add(i);
        }
        dataSet = (TreeSet) dataSet.descendingSet();
    }

    public String exchange(int money){
        int countMoneyWork = 0;
        int countMoneyResult = 0;
        int moneyWork = money;
        HashMap<Integer, Integer> hashMapResult = new HashMap<>();
        HashMap<Integer, Integer> hashMapWork = new HashMap<>();
        while (dataSet.size() != 0) {
            for (int i : dataSet) {
                for (int j : dataSet) {//dodelat
                    while (moneyWork - i > -1) {
                        try {
                            hashMapWork.put(i, hashMapWork.get(i) + 1);
                        } catch (NullPointerException e) {
                            hashMapWork.put(i, 1);
                        }
                        moneyWork -= i;
                    }
                }
            }
            for(int i : hashMapWork.keySet()) {
                if (hashMapWork.get(i) != 0) {
                    countMoneyWork += hashMapWork.get(i) * i;
                }
            }
            if (moneyWork == 0) {
                if (countMoneyResult == 0) {
                    for(int i : hashMapWork.keySet()) {
                        hashMapResult.put(i, hashMapWork.get(i));
                        countMoneyResult = countMoneyWork;
                    }
                } else if (countMoneyWork < countMoneyResult) {
                    hashMapResult.clear();
                    for(int i : hashMapWork.keySet()) {
                        hashMapResult.put(i, hashMapWork.get(i));
                    }
                }
            }
            dataSet.remove(dataSet.first());
            moneyWork = money;
            hashMapWork.clear();
            countMoneyWork = 0;
        }

        if (hashMapResult.size() == 0){
            return "Невозможно получить из полученного набора введенное значение.";
        }

        StringBuilder output = new StringBuilder();
        for(int i : hashMapResult.keySet()) {
            int count = hashMapResult.get(i)%100;
            if ((count>4 & count<21) | (count%10 > 4)) {
                output.append(hashMapResult.get(i)).append(" монет по ").append(i).append(" руб.\n");
            }
            else if (count%10 == 1){
                output.append(hashMapResult.get(i)).append(" монета по ").append(i).append(" руб.\n");
            }
            else{
                output.append(hashMapResult.get(i)).append(" монеты по ").append(i).append(" руб.\n");
            }
        }
        return output.toString();
    }
}
