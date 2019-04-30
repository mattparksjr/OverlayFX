package codes.matthewp.overlayfx.data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

public class SettingsFile {

    private File settingsFile;
    private HashMap<String, Object> properties;

    public SettingsFile() {
        settingsFile = new File("settings.cnf");
        properties = new HashMap<>();
        testIntegrity();
        load();
    }

    private void testIntegrity() {
        if (!settingsFile.exists()) {
            try {
                settingsFile.createNewFile();
                InputStream in = getClass().getResourceAsStream("/settings.cnf");
                Files.copy(in, settingsFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                System.out.println("IOException caught while creating config");
                ex.printStackTrace();
            }
        }
    }

    private void load() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(settingsFile));

            String st;
            // Read each line
            while ((st = br.readLine()) != null) {
                if (st.contains(":")) {
                    String[] parts = st.split(":");
                    properties.put(parts[0], parts[1]);
                }
            }

        } catch (IOException ex) {
            System.out.println("IOException caught while loading settings");
        }
    }

    public Integer getInt(String key) {
        return Integer.valueOf(properties.get(key).toString());
    }

    public void setValue(String key, Object value) {
        properties.put(key, value);
    }

    public void save() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(settingsFile));
            for (String key : properties.keySet()) {
                writer.write(key + ":" + properties.get(key));
                writer.write("\n");
            }

            writer.close();
        }catch (IOException ex) {
            System.out.println("IOException caught while saving settings");
            ex.printStackTrace();
        }
    }
}
