import java.util.ArrayList;

public class ConfigIniciais {

    private int numProcessos;
    private int fatiaTempo;
    private ArrayList<Processo> processos;

    public ConfigIniciais(int numProcessos, int fatiaTempo) {
        this.numProcessos = numProcessos;
        this.fatiaTempo = fatiaTempo;
        this.processos = new ArrayList<Processo>();
    }

    public ConfigIniciais(){
        this.processos = new ArrayList<Processo>();
    }

    public int getNumProcessos() {
        return numProcessos;
    }

    public int getFatiaTempo() {
        return fatiaTempo;
    }

    public ArrayList<Processo> getProcessos() {
        return processos;
    }

    public void setNumProcessos(int numProcessos) {
        this.numProcessos = numProcessos;
    }

    public void setFatiaTempo(int fatiaTempo) {
        this.fatiaTempo = fatiaTempo;
    }

    public void setProcessos(ArrayList<Processo> processos) {
        this.processos = processos;
    }

    public void addProcesso(Processo processo) {
        this.processos.add(processo);
    }
}
