package com.xupes.bookapp.payload.author;

import java.util.List;

public class AuthorListResponsePayload {
    private List<AuthorResponsePayload> author;

    public List<AuthorResponsePayload> getAuthor() {
        return author;
    }

    public void setAuthor(List<AuthorResponsePayload> author) {
        this.author = author;
    }
}

