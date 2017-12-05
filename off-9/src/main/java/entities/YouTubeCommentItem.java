package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YouTubeCommentItem {
    public YouTubeCommentSnippet snippet;
    public YouTubeReplies replies;
}
