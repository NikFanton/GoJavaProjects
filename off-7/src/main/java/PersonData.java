import java.util.HashMap;

public class PersonData {
    private String title;
    public HashMap<String, String> data = new HashMap<String, String>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PersonData(String title, HashMap<String, String> data) {
        this.title = title;
        this.data = data;
    }

    @Override
    public String toString() {
        String tmp = "";
        for (String key : data.keySet()) {
            tmp = tmp + "\t" + key + " - " + data.get(key) + "\n";
        }
        return "title: " + title
                + "\ndata {\n" + tmp + "}\n";
    }
}
