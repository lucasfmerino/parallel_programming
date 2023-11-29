package database;

/**
 * TaskDatabaseAccessProcedure
 */
public class TaskDatabaseAccessProcedure implements Runnable {

    private ConnectionPool pool;
    private TransactionManager tx;

    public TaskDatabaseAccessProcedure(ConnectionPool pool, TransactionManager tx) {
        this.pool = pool;
        this.tx = tx;
    }

    @Override
    public void run() {

        // DESTA FORMA (UTILIZANDO A ORDEM INVERSA DAS OPERAÇÕES) OCORRE UM DEADLOCK
        /*
         * synchronized (tx) {
         * System.out.println("Procedure: Chave tx adquirida");
         * tx.begin();
         * 
         * synchronized (pool) {
         * System.out.println("Procedure: Chave pool adquirida");
         * pool.getConnection();
         * }
         * }
         */

        synchronized (pool) {
            System.out.println("Procedure: Chave pool adquirida");
            pool.getConnection();

            synchronized (tx) {
                System.out.println("Procedure: Chave tx adquirida");
                tx.begin();

            }
        }

    }
}