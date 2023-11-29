package database;

public class ConnectionPool {

    public String getConnection() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Connection";
    }
}
