import java.util.HashMap;
import java.util.TreeSet;

public class ExchangeDevice {

    TreeSet<Integer> nums = new TreeSet<>();
    public ExchangeDevice(int... count) {
        for (int i : count) {
            nums.add(i);
        }
        nums = (TreeSet<Integer>) nums.descendingSet();
    }

    public void exchange(int money) {
        int howMuch = 0;
        int moneyResult = Integer.MAX_VALUE;
        int moneyForSwap = money;
        HashMap<Integer, Integer> result = new HashMap<>();
        HashMap<Integer, Integer> forSwap = new HashMap<>();
        while (nums.size() != 0) {
            for (int i : nums) {
                while (moneyForSwap - i > -1) {
                    try {
                        forSwap.put(i, forSwap.get(i) + 1);
                    } catch (NullPointerException e) {
                        forSwap.put(i, 1);
                    }
                    moneyForSwap -= i;
                }
            }
            for (int i : forSwap.keySet()) {
                howMuch += forSwap.get(i);
            }
            if (moneyForSwap == 0 & howMuch < moneyResult) {
                result.clear();
                for (int i : forSwap.keySet()) {
                    result.put(i, forSwap.get(i));
                }
                moneyResult = howMuch;
            }
            nums.remove(nums.first());
            moneyForSwap = money;
            forSwap.clear();
            howMuch = 0;
        }
        if (result.size() == 0)
            System.out.println("Невозможно разменять " + money + "Р заданным числом монет!");
        else
            System.out.println("Количество разменных монет (Какая монета - ее количество):\n" + result);

    }
}
