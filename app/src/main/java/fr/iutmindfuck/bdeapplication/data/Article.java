package fr.iutmindfuck.bdeapplication.data;

import android.widget.ImageView;

public class Article {
    private final Integer articleID;
    private final String articleName;
    private final String articleContent;
    private ImageView articleVisualContent;

    public Article(Integer articleID, String articleName, String articleContent) {
        this.articleID = articleID;
        this.articleName = articleName;
        this.articleContent = articleContent;
    }

    public Integer getArticleID() {
        return articleID;
    }

    public String getArticleName() {
        return articleName;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public ImageView getArticleVisualContent() {
        return articleVisualContent;
    }

    public void setArticleVisualContent(ImageView articleVisualContent) {
        this.articleVisualContent = articleVisualContent;
    }
}
