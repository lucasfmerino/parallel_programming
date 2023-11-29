package bathroom;

public class TaskCleanse implements Runnable{
    private Bathroom bathroom;

    public TaskCleanse(Bathroom bathroom) {
        this.bathroom = bathroom;
    }

    @Override
    public void run() {

        while(true) {
            bathroom.clean();

            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
}}
