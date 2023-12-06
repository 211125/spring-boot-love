package com.demo.demo.dto.response;

public class StudentResponse {

    private Long id;
    private String title;
    private String post;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
