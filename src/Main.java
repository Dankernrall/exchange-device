public class Main {

    public static void main(String[] args){
        ExchangeDevice exchangeDevice = new ExchangeDevice(5,2,3); //Какие монеты доступны для размена
        //ExchangeDevice exchangeDevice = new ExchangeDevice(3,4); //Для отработки невозможности размена
        int value = 13; // Для размена
        exchangeDevice.exchange(value);
    }
}