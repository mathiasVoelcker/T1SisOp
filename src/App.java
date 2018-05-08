import javafx.concurrent.Task;

import java.io.IOException;
import java.util.ArrayList;

public class App {

    public static void main(String args[]){
        ConfigIniciais configIniciais = new ConfigIniciais();
        try {
            configIniciais = Leitor.lerArquivo("teste.txt");
        } catch (NotTxtException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Contador contador = new Contador(0);
        ArrayList<Processo> processos = configIniciais.getProcessos();
        int fatiaTempo = configIniciais.getFatiaTempo();
        ordenarProcessosPorPrioridade(processos);
        boolean finalizado = false;
        boolean nadaExecutou;
        int trocaContexto = 1;
        while(!finalizado) {
            finalizado = true;
            nadaExecutou = true;
            for (Processo processo: processos) {
                if(!processo.isFinalizado()){
                    finalizado = false;
                    if(processo.getTempoChegada() <= Contador.tempo){
                        processo.executar(fatiaTempo);
                        nadaExecutou = false;
                        for(int i = 0; i < trocaContexto; i++){
                            Contador.passarUmSegundo();
                            System.out.println("Trocando Contexto " + Contador.tempo);
                        }
                    }
                }

            }
            if(nadaExecutou){
                Contador.passarUmSegundo();
            }
        }
    }

    //método bubble sort para ordenar processos de acordo com suas prioridades,
    public static void ordenarProcessosPorPrioridade(ArrayList<Processo> processos){
        for(int n = processos.size(); n >= 2; n--) {
            for(int i = 0; i < (n - 1); i++){
                if(processos.get(i).getPrioridade() > processos.get(i + 1).getPrioridade()){
                    Processo aux = processos.get(i);
                    processos.set(i, processos.get(i + 1));
                    processos.set(i + 1, aux);
                }
            }
        }
    }
}
