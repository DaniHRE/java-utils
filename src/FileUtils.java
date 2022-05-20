import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    // Variáveis de escopo Global
    private String nome;
    private List<String> lista;
    private String message;

    // Diretórios Padrões para o LOG e o Arquivo de Config
    private String defaultLog = "log-";
    private String defaultDir = "folderConfig.txt";
    private ArrayList<String> foldersList = new ArrayList<String>();

    public String getDefaultDir() {
        return defaultDir;
    }

    public void checkDir() throws IOException {
        if (!Files.exists(Path.of(defaultDir))) {
            Files.createFile(Path.of(defaultDir));
        } else {
            System.out.println("Already Exists");
        }

        var folders = Files.readAllLines(Path.of(defaultDir));

        foldersList.addAll(folders);
        for (int i = 0; i < foldersList.size(); i++) {
            if (!Files.exists(Path.of(foldersList.get(i)))) {
                DirectoryUtils.createDirectory(foldersList.get(i));
            } else {
                System.out.println(foldersList.get(i).toUpperCase() + " directory Exists.");
            }
        }
    }

    public void createTxt(String nome, List<String> lista) throws IOException {
        Path path = Paths.get(nome + ".txt");
        Files.write(path, lista, StandardCharsets.UTF_8);
    }

    public void readTxt(String nomeArquivo) throws IOException {
        Path path = Paths.get(nomeArquivo + ".txt");
        String dados = String.valueOf(Files.readAllLines(path));
        System.out.println(dados);
    }

    public void writeFile(String message, TimeUtils time) throws IOException {
        try {
            Files.write(Paths.get(defaultLog + time.getTime() + ".txt"),
                    (message + time.getActionTime()).getBytes(), StandardOpenOption.APPEND);
        }catch (
        IOException e) {
            Files.write(Paths.get(defaultLog + time.getTime() + ".txt"),
                    ("There was an error opening the file" + time.getActionTime()).getBytes(), StandardOpenOption.APPEND);
        }
    }
}