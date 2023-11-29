package ListaPadrao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// import java.util.Vector;

;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        

        List<String> lista = Collections.synchronizedList(new ArrayList<>());
        
        // List<String> lista = new Vector<String>();

        for (int i = 0; i < 1000; i++) {
            new Thread(new TarefaAdicionarElemento(lista, i)).start();
        }

        Thread.sleep(2000);

        for (int i=0; i < lista.size(); i++) {
            System.out.println(i + " - " + lista.get(i));
        }
    }
}
