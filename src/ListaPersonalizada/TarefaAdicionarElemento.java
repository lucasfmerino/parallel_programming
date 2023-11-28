package ListaPersonalizada;
;

public class TarefaAdicionarElemento implements Runnable{
    private Lista lista;
    private int numeroDothread;

    public TarefaAdicionarElemento(Lista lista, int numeroDothread) {
        this.lista = lista;
        this.numeroDothread = numeroDothread;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
        lista.adicinaElementos("Thread " + numeroDothread + "-" + i);
        }
    }
}
