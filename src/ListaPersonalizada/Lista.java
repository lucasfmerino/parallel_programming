package ListaPersonalizada;

/**
 * Lista
 */
public class Lista {

    private String[] elementos = new String[1000];
    private int indice = 0;

    public synchronized void adicinaElementos(String elemento) {
        this.elementos[indice] = elemento;
        this.indice++;

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(this.indice == this.elementos.length) {
            System.out.println("Notificando que a lista está cheia!");
            this.notify();
        }
    }

    public int tamanho() {
        return this.elementos.length;
    }

    public String pegaElemento(int posicao) {
        return this.elementos[posicao];
    }

    public boolean estaCheia() {
        return this.indice == this.tamanho();
    }

}