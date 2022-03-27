package com.xupes.bookapp.payload.author;

import java.util.List;

public class AuthorResponsePayload {
    private Long authorid;
    private String authorlastfirst;
    private Work works;

    public Long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Long authorid) {
        this.authorid = authorid;
    }

    public String getAuthorlastfirst() {
        return authorlastfirst;
    }

    public void setAuthorlastfirst(String authorlastfirst) {
        this.authorlastfirst = authorlastfirst;
    }

    public Work getWorks() {
        return works;
    }

    public void setWorks(Work works) {
        this.works = works;
    }

    public static class Work{
        private List<String> works;

        public List<String> getWorks() {
            return works;
        }

        public void setWorks(List<String> works) {
            this.works = works;
        }
    }

}

