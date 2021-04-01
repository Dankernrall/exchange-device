import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        ExchangeDevice exchangeDevice = new ExchangeDevice(1,5,10,25,100);
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число: ");
        int count = sc.nextInt();
        System.out.print(exchangeDevice.exchange(count));
    }
}