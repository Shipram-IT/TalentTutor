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
            } else {
                // Find the index of the column to be incremented
                int columnIndex = -1;
                for (int i = 0; i < columnTitleList.length; i++) {
                    if (columnTitleList[i].equals("id")) {
                        columnIndex = i;
                        break;
                    }
                }

                if (columnIndex != -1) {
                    // Get the last inserted value in the specified column
                    String lastInsertedValue = getLastInsertedValue(filename, columnIndex);
                    int nextId = Integer.parseInt(lastInsertedValue) + 1;

                    // Replace the value in the columnValueList with the incremented value
                    columnValueList[columnIndex] = String.valueOf(nextId);
                }
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

    private String getLastInsertedValue(String filename, int columnIndex) {
        String lastValue = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            // Skip the header line
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length > columnIndex) {
                    lastValue = values[columnIndex];
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lastValue;
    }
}
