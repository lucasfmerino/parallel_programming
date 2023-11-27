package buscaTextual;

public class Main {
    public static void main(String[] args) {
        
        String name = "da";

        Thread threadSignature = new Thread(new TaskTextSearch ("files/assinaturas1.txt", name));

        Thread threadSignature2 = new Thread(new TaskTextSearch ("files/assinaturas2.txt", name));

        Thread threadAuthor = new Thread(new TaskTextSearch ("files/autores.txt", name));

        threadSignature.start();
        threadSignature2.start();
        threadAuthor.start();

        // Desta forma não temos controle sobre a ordem de execução.
    }
}
