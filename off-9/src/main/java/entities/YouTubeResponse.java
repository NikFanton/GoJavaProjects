package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YouTubeResponse {
    public ArrayList<YouTubeCommentItem> items = new ArrayList<YouTubeCommentItem>();
}
