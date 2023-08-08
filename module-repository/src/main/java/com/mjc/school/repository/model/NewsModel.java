package com.mjc.school.repository.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class NewsModel {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private Long authorId;

    public NewsModel (Long id, String title, String content, LocalDateTime createDate, LocalDateTime lastUpdateDate, Long authorId){
        this.id=id;
        this.title=title;
        this.content=content;
        this.createDate=createDate;
        this.lastUpdateDate=lastUpdateDate;
        this.authorId=authorId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, createDate, lastUpdateDate, authorId);}

    @Override
    public boolean equals(Object obj) {
        if(this==obj)  {return true;}
        if (obj==null || getClass()!=obj.getClass()){ return false;}
        NewsModel nm = (NewsModel) obj;
        return Objects.equals(id, nm.id)&& Objects.equals(title, nm.title)&& Objects.equals(content, nm.content)&& Objects.equals(createDate, nm.createDate)&& Objects.equals(lastUpdateDate, nm.lastUpdateDate)&& Objects.equals(authorId, nm.authorId);
    }

    @Override
    public String toString() {
        return "id: " + id + ", title: "+ title +", content: " + content + ", createDate: " + createDate + ", lastUpdateDate:" + lastUpdateDate + ", authorId: " + authorId;
    }
}
