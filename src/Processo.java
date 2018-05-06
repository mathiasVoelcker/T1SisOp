public class Processo {
    private int tempoChegada;
    private int tempoExcecucao;
    private int prioridade;
    private int etapaProcesso;
    private boolean finalizado;

    public Processo(int tempoChegada, int tempoExcecucao, int prioridade) {
        this.tempoChegada = tempoChegada;
        this.tempoExcecucao = tempoExcecucao;
        this.prioridade = prioridade;
        this.etapaProcesso = 0;
    }

    public Processo(){ }

    public void executar(int fatiaTempo) {
        int tempoExecutando = 0;
        while(tempoExecutando < fatiaTempo){
            if(this.etapaProcesso == this.tempoExcecucao) {
                finalizado = true;
                break;
            }
            Contador.passarUmSegundo();
            this.etapaProcesso++;
            tempoExecutando++;
        }
        System.out.println(Contador.tempo);
        System.out.println(this.etapaProcesso);
        System.out.println(this.tempoExcecucao);
        System.out.println("-----------------");
    }

    public int getTempoChegada() {
        return tempoChegada;
    }

    public int getTempoExcecucao() {
        return tempoExcecucao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public boolean isFinalizado() {
        return finalizado;
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
