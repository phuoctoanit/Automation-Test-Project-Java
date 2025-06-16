package reporting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class AllureEnvironmentWriter {

    public static void writeEnvironmentInfo(String browser, String env, String baseUrl) {
        try {
            Properties props = new Properties();
            props.setProperty("Browser", browser);
            props.setProperty("Environment", env);
            props.setProperty("BaseURL", baseUrl);

            File resultsDir = new File("allure-results");
            if (!resultsDir.exists()) {
                resultsDir.mkdirs();
            }

            File file = new File(resultsDir, "environment.properties");
            try (FileWriter writer = new FileWriter(file)) {
                props.store(writer, "Allure Environment Properties");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
