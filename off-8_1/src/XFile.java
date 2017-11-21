import java.io.File;
import java.net.URL;

public class XFile {
    private File file;
    private boolean isCashed;
    private URL url;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public boolean isCashed() {
        return isCashed;
    }

    public void setCashed(boolean cashed) {
        isCashed = cashed;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public XFile() {
    }

    public XFile(File file) {
        this.file = file;
    }

    public XFile(File file, boolean isCashed) {
        this.file = file;
        this.isCashed = isCashed;
    }

    public XFile(URL url) {
        this.url = url;
    }
}
