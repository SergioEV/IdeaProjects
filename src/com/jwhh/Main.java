package com.jwhh;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String [] args){
        String[] data = {
          "Line 1",
          "Line 2 2",
          "Line 3 3 3",
          "Line 4 4 4 4",
          "Line 5 5 5 5 5"
        };

        try(FileSystem zipFs = openZip(Paths.get("myData.zip"))){
            copyToZip(zipFs);
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
    private static FileSystem openZip(Path zipPath) throws IOException, URISyntaxException {
        Map<String, String> providerProps = new HashMap<>();
        providerProps.put("create", "true");

        URI zipURI = new URI("jar:file", zipPath.toUri().getPath(), null);
        FileSystem zipFS = FileSystems.newFileSystem(zipURI, providerProps);

        return zipFS;
    }
    private static void copyToZip (FileSystem zipFs) throws IOException {
        Path sourceFile = Paths.get("file1.txt");
        //Path sourceFile = FileSystems.getDefault().getPath("file1.txt")
        Path destFile = zipFs.getPath("/file1Copied.txt");

        Files.copy(sourceFile, destFile, StandardCopyOption.REPLACE_EXISTING);
    }

}