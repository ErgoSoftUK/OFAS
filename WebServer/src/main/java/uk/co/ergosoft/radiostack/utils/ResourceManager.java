package uk.co.ergosoft.radiostack.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public class ResourceManager {
    public static byte[] getResourceBytes(String path) {
        byte[] fileInBytes = null;

        try {
            URL resource = ResourceManager.class.getClassLoader().getResource(path);
            if (resource == null)
                return null;

            URI fileLocation = resource.toURI();
            File file = new File(fileLocation);


            fileInBytes = new byte[(int) file.length()];

            InputStream inputStream = null;
            try {

                inputStream = new FileInputStream(file);

                inputStream.read(fileInBytes);

            } finally {
                inputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileInBytes;
    }
}
