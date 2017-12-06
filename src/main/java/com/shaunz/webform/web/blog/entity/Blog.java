package com.shaunz.webform.web.blog.entity;

import com.shaunz.webform.web.autor.entity.Author;

public class Blog {
    private String id;

    private String name;

    private String headerType;

    private String header;

    private String content;

    private String postTime;

    private String authorId;
    
    private Author author;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getHeaderType() {
        return headerType;
    }

    public void setHeaderType(String headerType) {
        this.headerType = headerType == null ? null : headerType.trim();
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header == null ? null : header.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime == null ? null : postTime.trim();
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId == null ? null : authorId.trim();
    }

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
    
}