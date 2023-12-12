import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CsvIO {
    public ArrayList<HashMap<String, String>> readFromCSV(String filename, String[] arrayOfFields) {
        ArrayList<HashMap<String, String>> data = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            // Skip the header line
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                HashMap<String, String> entry = new HashMap<>();

                for (int i = 0; i < arrayOfFields.length; i++) {
                    entry.put(arrayOfFields[i], values[i]);
                }

                data.add(entry);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public void writeToCSV(String filename, String[] columnTitleList, String[] columnValueList) {
        try {
            File file = new File(filename);
            boolean isNewFile = !file.exists() || file.length() == 0;

            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));

            // Check if the file is empty (new file), then write the column titles
            if (isNewFile) {
                for (String title : columnTitleList) {
                    writer.write(title);
                    writer.write(",");
                }
                writer.newLine();
            }

            // Write the column values
            for (String value : columnValueList) {
                writer.write(value);
                writer.write(",");
            }
            writer.newLine();

            writer.close();
            System.out.println("Data written to " + filename + " successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
