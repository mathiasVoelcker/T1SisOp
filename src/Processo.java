public class Processo {
    private int id;
    private int tempoChegada;
    private int tempoExcecucao;
    private int prioridade;
    private int etapaProcesso;
    private boolean finalizado;
    private int quandoHouveEntrada = 0;
    private int quandoHouveSaida = 0;
    private int operacaoEntrada;
    private int operacaoSaida;

    public Processo(int id, int tempoChegada, int tempoExcecucao, int prioridade) {
        this.id = id;
        this.tempoChegada = tempoChegada;
        this.tempoExcecucao = tempoExcecucao;
        this.prioridade = prioridade;
        this.etapaProcesso = 0;
        this.operacaoEntrada = 4;
        this.operacaoSaida = 4;
    }

    public Processo(int id, int tempoChegada, int tempoExcecucao, int prioridade, int operacaoEntrada) {
        this.id = id;
        this.tempoChegada = tempoChegada;
        this.tempoExcecucao = tempoExcecucao;
        this.prioridade = prioridade;
        this.etapaProcesso = 0;
        this.operacaoEntrada = operacaoEntrada;
        this.operacaoSaida = 4;
    }

    public Processo(int id, int tempoChegada, int tempoExcecucao, int prioridade, int operacaoEntrada, int operacaoSaida) {
        this.id = id;
        this.tempoChegada = tempoChegada;
        this.tempoExcecucao = tempoExcecucao;
        this.prioridade = prioridade;
        this.etapaProcesso = 0;
        this.operacaoEntrada = operacaoEntrada;
        this.operacaoSaida = operacaoSaida;
    }

    public Processo(){ }

    public void executar(int fatiaTempo) {
        int tempoExecutando = 0;
        while(tempoExecutando < fatiaTempo && verificarSaida()){
            if(this.etapaProcesso == this.tempoExcecucao) {
                finalizado = true;
                break;
            }
            Contador.passarUmSegundo();
            this.etapaProcesso++;
            tempoExecutando++;
            if(quandoHouveEntrada == 0 && etapaProcesso == operacaoEntrada) {
                quandoHouveEntrada = Contador.tempo;
                break;
            }
        }
        System.out.println(Contador.tempo);
        System.out.println("Processo " + this.id + ": " + this.etapaProcesso);
        System.out.println(this.tempoExcecucao);
        System.out.println("-----------------");
    }

    private boolean verificarSaida(){
        return Contador.tempo - this.quandoHouveEntrada >= operacaoSaida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTempoChegada() {
        return tempoChegada;
    }

    public void setOperacaoEntrada(int operacaoEntrada) {
        this.operacaoEntrada = operacaoEntrada;
    }

    public void setOperacaoSaida(int operacaoSaida) {
        this.operacaoSaida = operacaoSaida;
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
