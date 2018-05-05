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
            if(this.etapaProcesso == tempoExcecucao) {
                finalizado = true;
                break;
            }
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.etapaProcesso++;
            tempoExecutando++;
        }
        System.out.println(etapaProcesso);
        System.out.println(tempoExcecucao);
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
