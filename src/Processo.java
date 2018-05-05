public class Processo {
    private int tempoChegada;
    private int tempoExcecucao;
    private int prioridade;

    public Processo(int tempoChegada, int tempoExcecucao, int prioridade) {
        this.tempoChegada = tempoChegada;
        this.tempoExcecucao = tempoExcecucao;
        this.prioridade = prioridade;
    }

    public Processo(){ }

    public int getTempoChegada() {
        return tempoChegada;
    }

    public int getTempoExcecucao() {
        return tempoExcecucao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setTempoChegada(int tempoChegada) {
        this.tempoChegada = tempoChegada;
    }

    public void setTempoExcecucao(int tempoExcecucao) {
        this.tempoExcecucao = tempoExcecucao;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}
