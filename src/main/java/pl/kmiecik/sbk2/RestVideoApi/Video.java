package pl.kmiecik.sbk2.RestVideoApi;

public class Video {

    Long id;
    String title;
    String link;

    public Video(Long id, String title, String link) {
        this.id = id;
        this.title = title;
        this.link = link;
    }

    public Video() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
