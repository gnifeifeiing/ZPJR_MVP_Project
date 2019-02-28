package com.zpjr.cunguan.entity.module;

/**
 * Description:      描述
 * Autour：          LF
 * Date：            2017/8/22 11:41
 */

public class CMSResponseModule extends ApiResponseModule {


    private String id;

    private String channelId;

    private String title;

    private String content;

    private String category;

    private boolean hasImage;

    private boolean priority;

    private String newsId;

    private String url;

    private long pubDate;

    private String media;

    private String author;

    private long timeRecorded;

    private CMSResponseModule previous;

    private CMSResponseModule next;

    private Object parent;

    private String bgColor;

    /**
     * 自己添加的状态字段
     */
    private String status;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isHasImage() {
        return hasImage;
    }

    public void setHasImage(boolean hasImage) {
        this.hasImage = hasImage;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getPubDate() {
        return pubDate;
    }

    public void setPubDate(long pubDate) {
        this.pubDate = pubDate;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getTimeRecorded() {
        return timeRecorded;
    }

    public void setTimeRecorded(long timeRecorded) {
        this.timeRecorded = timeRecorded;
    }

    public CMSResponseModule getPrevious() {
        return previous;
    }

    public void setPrevious(CMSResponseModule previous) {
        this.previous = previous;
    }

    public CMSResponseModule getNext() {
        return next;
    }

    public void setNext(CMSResponseModule next) {
        this.next = next;
    }

    public Object getParent() {
        return parent;
    }

    public void setParent(Object parent) {
        this.parent = parent;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
