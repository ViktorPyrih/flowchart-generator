package ua.edu.cdu.vu;

import guru.nidi.graphviz.engine.Format;
import moe.leer.codeflowcore.CodeFlow;
import moe.leer.codeflowcore.exception.CodeFlowException;

import java.io.IOException;
import java.util.UUID;

public class Application {

    private static final String PATTERN = "%s.jpg";
    private static final String OUTPUT = "results";
    private static final String WORK_DIR = "D:\\Programming\\Java\\price-aggregator-api\\src\\main\\java\\ua\\edu\\cdu\\vu\\price\\aggregator\\api";
    private static final String FILE_PATH = "D:\\Programming\\Java\\price-aggregator-api\\src\\main\\java\\ua\\edu\\cdu\\vu\\price\\aggregator\\api\\properties\\MarketplaceConfigProperties.java";

    public static void main(String[] args) throws CodeFlowException, IOException {
        CodeFlow codeFlow = CodeFlow.builder()
                .failFast(true)
                .useNative(true)
                .workDir(WORK_DIR)
                .outDir(OUTPUT)
                .format(Format.PNG)
                .build();
        boolean result = codeFlow.parseFile(FILE_PATH)
                .toFile(PATTERN.formatted(UUID.randomUUID()))
                .createNewFile();
        System.out.println(result);
    }
}
