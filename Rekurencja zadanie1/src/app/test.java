package app;

import java.io.File;
 
public class test {
    public static void main(String[] args) {
        test dl = new test();
        File file = new File("D:\\eclipse");
        dl.showDirectories(file);
    }
 
    public void showDirectories(File file) {
        File[] files = file.listFiles();
 
        if (files != null)
            for (File f : files) {
                if (f.isDirectory()) {
                    System.out.println("folder " + f.getAbsolutePath());
                    showDirectories(f);
                } else {
                    System.out.println("  plik " + f.getAbsolutePath());
                }
            }
    }
}