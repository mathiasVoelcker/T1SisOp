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
        ArrayList<Processo> processos = configIniciais.getProcessos();
        int fatiaTempo = configIniciais.getFatiaTempo();
        ordenarProcessosPorPrioridade(processos);
        boolean executou = true;
        while(executou){
            executou = false;
            for (Processo processo: processos) {
                if(!processo.isFinalizado()){
                    executou = true;
                    processo.executar(fatiaTempo);
                }
            }
        }
    }

    //método bubble sort para ordenar processos de acordo com suas prioridades,
    public static void ordenarProcessosPorPrioridade(ArrayList<Processo> processos){
        for(int n = processos.size(); n >= 2; n--) {
            for(int i = 0; i < (n - 1); i++){
                if(processos.get(i).getPrioridade() > processos.get(i + 1).getPrioridade()){
                    int aux = processos.get(i).getPrioridade();
                    processos.get(i).setPrioridade(processos.get(i + 1).getPrioridade());
                    processos.get(i + 1).setPrioridade(aux);
                }
            }
        }
    }
}
