package bathroom;

public class Bathroom {

    private boolean isDirty = true;

    public void numberOne() {

        String name = Thread.currentThread().getName();

        System.out.println(String.format("%s: Batendo na porta".toUpperCase(), name));

        synchronized (this) {

            System.out.println(String.format("%s: Entrando no banheiro".toUpperCase(), name));

            while (isDirty) {
                waitOutside(name);
            }

            System.out.println(String.format("%s: Fazendo número 1".toUpperCase(), name));

            bathroomTime(4000);

            this.isDirty = true;

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

            while (isDirty) {
                waitOutside(name);
            }

            System.out.println(String.format("%s: Fazendo número 2".toUpperCase(), name));

            bathroomTime(8000);

            this.isDirty = true;

            System.out.println(String.format("%s: Descarga".toUpperCase(), name));
            System.out.println(String.format("%s: Lavando a mão".toUpperCase(), name));
            System.out.println(String.format("%s: Saindo do banheiro".toUpperCase(), name));
        }

    }

    public void clean() {
        String name = Thread.currentThread().getName();

        System.out.println(String.format("%s: Batendo na porta".toUpperCase(), name));

        synchronized (this) {
            System.out.println(String.format("%s: Entrando no banheiro".toUpperCase(), name));

            if (!isDirty) {
                System.out.println((String.format("%s: O banheiro ainda está limpo".toUpperCase(), name)));
                return;
            }

            System.out.println(String.format("%s: Limpando o banheiro.".toUpperCase(), name));
            this.isDirty = false;

            bathroomTime(10000);

            this.notifyAll();

            System.out.println(String.format("%s: Saindo do banheiro".toUpperCase(), name));
        }
    }

    private void waitOutside(String name) {
        System.out.println(String.format("%s: O banheiro está sujo".toUpperCase(), name));
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void bathroomTime(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Como alternativa, podemos também conseguir esse bloqueio de forma explícita
// (programaticamente) através de uma classe chamada ReentrantLock.