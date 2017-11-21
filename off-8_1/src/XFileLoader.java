import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Scanner;

public class XFileLoader {

    public static ArrayList<String> load(String loadFrom, String loadTo) {
        ArrayList<String> fileNames = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(loadFrom));
            while (scanner.hasNext()) {
                URL url = new URL(scanner.nextLine());
                String strings[] = String.valueOf(url).split("/");
                String name = strings[strings.length - 1];
                ReadableByteChannel rbc = Channels.newChannel(url.openStream());
                FileOutputStream fos = new FileOutputStream(loadTo + name);
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                fileNames.add(name);
                System.out.println(url + " - ready");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileNames;
    }

    public static void main(String[] args) {
        XFileLoader.load("files/links.txt", "files/cache/");
    }
}
