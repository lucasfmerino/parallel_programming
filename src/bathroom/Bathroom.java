package bathroom;

public class Bathroom {

    public void numberOne() {

        String name = Thread.currentThread().getName();

        System.out.println(String.format("%s: Batendo na porta".toUpperCase(), name));

        synchronized (this) {

            System.out.println(String.format("%s: Entrando no banheiro".toUpperCase(), name));
            System.out.println(String.format("%s: Fazendo número 1".toUpperCase(), name));

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(String.format("%s: Descarga".toUpperCase(), name));
            System.out.println(String.format("%s: Lavando a mão".toUpperCase(), name));
            System.out.println(String.format("%s: Saindo do banheiro".toUpperCase(), name));
        }

    }

    public void numberTwo() {

        String name = Thread.currentThread().getName();

        System.out.println(String.format("%s: Batendo na porta".toUpperCase(), name));

        synchronized (this) {
            System.out.println(String.format("%s: Entrando no banheiro".toUpperCase(), name));
            System.out.println(String.format("%s: Fazendo número 2".toUpperCase(), name));

            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(String.format("%s: Descarga".toUpperCase(), name));
            System.out.println(String.format("%s: Lavando a mão".toUpperCase(), name));
            System.out.println(String.format("%s: Saindo do banheiro".toUpperCase(), name));
        }

    }
}

// Como alternativa, podemos também conseguir esse bloqueio de forma explícita (programaticamente) através de uma classe chamada ReentrantLock.