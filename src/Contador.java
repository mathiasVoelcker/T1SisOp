public class Contador {

    public static int tempo;

    public Contador(int tempo){
        this.tempo = tempo;
    }

    public static void passarUmSegundo(){
        try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tempo++;
    }

}
