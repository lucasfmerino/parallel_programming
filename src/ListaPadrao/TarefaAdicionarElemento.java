package ListaPadrao;

import java.util.List;

;

public class TarefaAdicionarElemento implements Runnable{
    private List<String> lista;
    private int numeroDothread;

    public TarefaAdicionarElemento(List<String> lista, int numeroDothread) {
        this.lista = lista;
        this.numeroDothread = numeroDothread;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
        lista.add("Thread " + numeroDothread + "-" + i);
        }
    }
}
