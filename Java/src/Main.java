public class Main {
    public static void main(String[] args) {
        AvailableChecker availableChecker = new AvailableChecker();
        int[] nums = {2, 3, 5};
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
        availableChecker.AvailableChecker(11, nums);
        // availableChecker.AvailableChecker(1, nums); //- Вариант для отработки
        //невозможности размена.
        //value - Сумма для размена, nums - номиналы доступных монет для размена
    }
}
