import javax.swing.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
    //        TimeUtils time = new TimeUtils();
    //        FileUtils file = new FileUtils();
    //    file.checkDir();
    //    file.createTxt(  file.getDefaultDir() + time.getTime(), Collections.singletonList("Program Started" + time.getActionTime()));
    //    create(time, file);

        DirectoryUtils.deleteDirectoryRecursion(Path.of("./testFolderDelete"));

    }

    private static void create(TimeUtils time, FileUtils file) throws IOException, InterruptedException {
        // Declaração de Variaveis
        ArrayList<String> content = new ArrayList<>();

        // Digitar o nome do Arquivo para ser criado
        String name = JOptionPane.showInputDialog(null, "Digite o nome: ", "System", JOptionPane.INFORMATION_MESSAGE);

        // While para adicionar várias linhas
        while (true) {
            String produto = JOptionPane.showInputDialog(null, "Produto: ", "System", JOptionPane.INFORMATION_MESSAGE);
            if (produto.equals("sair"))
                break;
            content.add(produto);
        }

        // Adicionar Remessa ao Log
        file.writeFile("Saved Item Package", time);

        // Método para criar o arquivo com o conteúdo
        file.createTxt(name, content);

        // Espera para dar tempo de criar e depois ler
        Thread.sleep(1000);

        // Lê o arquivo
        file.readTxt("log-" + time.getTime());
    }
}