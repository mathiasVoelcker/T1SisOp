import java.util.ArrayList;

public class Processo {
    private int id;
    private int tempoChegada;
    private int tempoExcecucao;
    private int prioridade;
    private int etapaProcesso;
    private boolean finalizado;
    private int quandoHouveEntrada = 0;
    private int tempoOperacaoES;
    private ArrayList<Integer> operacoesEntradaSaida;

    public Processo(int id, int tempoChegada, int tempoExcecucao, int prioridade) {
        this.id = id;
        this.tempoChegada = tempoChegada;
        this.tempoExcecucao = tempoExcecucao;
        this.prioridade = prioridade;
        this.etapaProcesso = 0;
        this.tempoOperacaoES = 4;
    }

    public Processo(){
        this.etapaProcesso = 0;
        this.tempoOperacaoES = 4;
    }

    public void executar(int fatiaTempo) {
        int tempoExecutando = 0;
        while(tempoExecutando < fatiaTempo){
            Contador.passarUmSegundo();
            this.etapaProcesso++;
            tempoExecutando++;
            System.out.print(this.id);
            if(quandoHouveEntrada == 0 /*&& etapaProcesso == operacaoEntrada*/) {
                quandoHouveEntrada = Contador.tempo;
                break;
            }
            if(this.etapaProcesso == this.tempoExcecucao) {
                finalizado = true;
                break;
            }
        }
//        System.out.println(Contador.tempo);
//        System.out.println("Processo " + this.id + ": " + this.etapaProcesso);
//        System.out.println(this.tempoExcecucao);
//        System.out.println("-----------------");
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

    public void setTempoOperacaoES(int tempoOperacaoES) {
        this.tempoOperacaoES = tempoOperacaoES;
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
