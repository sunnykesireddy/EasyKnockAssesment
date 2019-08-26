package Utlities;

import java.io.*;
import java.net.URL;

public class FileDataReader implements IDataReader{

    public String readData(String filePath) {


        try {

            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(filePath);
            String data = readFromInputStream(inputStream);
            return data;
        }
        catch ( FileNotFoundException ex)
        {
            System.out.println(String.format("Cannot find specified file %s, Stack trace %s",ex.getMessage(),ex.getStackTrace()));

        } catch (IOException e) {
            System.out.println(String.format("Unable to read data from  %s, Stack trace %s",e.getMessage(),e.getStackTrace()));
        }
        return "";

    }

    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println(String.format("Cannot find specified file %s, Stack trace %s",ex.getMessage(),ex.getStackTrace()));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return resultStringBuilder.toString();
    }
}
