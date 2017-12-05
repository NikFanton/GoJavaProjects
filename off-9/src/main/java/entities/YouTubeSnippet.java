package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YouTubeSnippet {
    public String authorDisplayName;
    public int likeCount;
    public String textDisplay;
}
