import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Leitor {

    public static ConfigIniciais lerArquivo(String nameArq) throws NotTxtException, IOException {
        String fileString = "";
        Scanner scanner;
        ConfigIniciais configIniciais = new ConfigIniciais();
        if (!nameArq.contains(".txt")) {
            throw new NotTxtException("Arquivo deve ser txt");
        }
        final Reader reader = new FileReader(nameArq);
        final BufferedReader bufferReader = new BufferedReader(reader);
        String currentLine;
        currentLine = bufferReader.readLine();
        scanner = new Scanner(currentLine);
        configIniciais.setNumProcessos(scanner.nextInt());
        currentLine = bufferReader.readLine();
        scanner = new Scanner(currentLine);
        configIniciais.setFatiaTempo(scanner.nextInt());
        for(int i = 0; i < configIniciais.getNumProcessos(); i++){
            Processo processo = new Processo();
            currentLine = bufferReader.readLine();
            scanner = new Scanner(currentLine);
            processo.setTempoChegada(scanner.nextInt());
            processo.setTempoExcecucao(scanner.nextInt());
            processo.setPrioridade(scanner.nextInt());
            configIniciais.addProcesso(processo);
        }
        reader.close();
        bufferReader.close();
        return configIniciais;
    }

}
