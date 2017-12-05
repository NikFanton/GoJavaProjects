import com.mashape.unirest.http.HttpResponse;
import entities.YouTubeComment;
import entities.YouTubeCommentItem;
import entities.YouTubeResponse;

public class Runner {


    public Runner() {
        HttpResponse<YouTubeResponse> response = YouTubeClient.getComments("VstRvlOgJqI");
        YouTubeResponse body = response.getBody();
        String info = "";
        for (YouTubeCommentItem item : body.items) {
            System.out.println(item.snippet.topLevelComment.snippet.authorDisplayName + ": "
                    + item.snippet.topLevelComment.snippet.textDisplay);
            if (item.replies != null) {
//                for (YouTubeComment comment : item.replies.comments) {
                for (int i = 0; i < item.replies.comments.size(); i++) {
                    System.out.println("\t-" + item.replies.comments.get(i).snippet.authorDisplayName + ": "
                            + item.replies.comments.get(i).snippet.textDisplay);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Runner();
    }
}
