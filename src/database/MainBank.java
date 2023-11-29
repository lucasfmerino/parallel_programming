package database;

public class MainBank {
    
    public static void main(String[] args) throws InterruptedException {
        TransactionManager tx = new TransactionManager();
        ConnectionPool pool = new ConnectionPool();

        new Thread(new TaskDatabaseAccess(pool, tx)).start();
        new Thread(new TaskDatabaseAccessProcedure(pool, tx)).start();
    }
}
