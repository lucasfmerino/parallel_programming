package database;

public class TransactionManager {
    public void begin() {
        System.out.println("Iniciando a transação");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
