package database;

public class TaskDatabaseAccess implements Runnable{

    private ConnectionPool pool;
    private TransactionManager tx;

    public TaskDatabaseAccess(ConnectionPool pool, TransactionManager tx) {
        this.pool = pool;
        this.tx = tx;
    }
    
    @Override
    public void run() {

        synchronized (pool) {
            System.out.println("Chave do pool adquirida");
            pool.getConnection();

            synchronized (tx) {
                System.out.println("Chave tx adquirida");
                tx.begin();
            }
        }

    }
}
