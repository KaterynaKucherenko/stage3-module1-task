package com.mjc.school.service.dto;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

public class NewsDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Min(value = 5, message = "Title should not be less than 5")
    @Max(value = 30, message = "Title should not be greater than 30")
    @NotBlank
    private String title;
    @Min(value = 5, message = "Content should not be less than 5")
    @Max(value = 255, message = "Content should not be greater than 255")
    @NotBlank
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private Long authorId;

    public NewsDto() {
    }

    public NewsDto(String title, String content, Long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }

    public NewsDto(Long id, String title, String content, Long authorId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String toString() {
        return "ID" + id + ", title: " + title + ", content: " + content + ", createDate: " + createDate + ", lastUpdateDate:" + lastUpdateDate + ", authorId: " + authorId;
    }


}
