package com.shaunz.webform.web.marketinfo.entity;

import javax.persistence.Entity;

import com.shaunz.framework.core.BaseEntity;
import com.shaunz.webform.web.author.entity.Author;
import com.shaunz.webform.web.button.entity.Button;
import com.shaunz.webform.web.image.entity.Image;

@Entity
public class MarketInfo extends BaseEntity{
    private String name;

    private String header;

    private String content;

    private String imgId;

    private String buttonId;

    private String postTime;

    private String authorId;
    
    private Image image;
    
    private Button button;
    
    private Author author;
    
    private String closeFlg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId == null ? null : imgId.trim();
    }

    public String getButtonId() {
        return buttonId;
    }

    public void setButtonId(String buttonId) {
        this.buttonId = buttonId == null ? null : buttonId.trim();
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

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getCloseFlg() {
		return closeFlg;
	}

	public void setCloseFlg(String closeFlg) {
		this.closeFlg = closeFlg;
	}
}