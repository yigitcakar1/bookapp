package com.xupes.bookapp.payload.work;

public class WorkResponsePayload {
    private Long workid;
    private String authorweb;
    private String titleweb;

    public Long getWorkid() {
        return workid;
    }

    public void setWorkid(Long workid) {
        this.workid = workid;
    }

    public String getAuthorweb() {
        return authorweb;
    }

    public void setAuthorweb(String authorweb) {
        this.authorweb = authorweb;
    }

    public String getTitleweb() {
        return titleweb;
    }

    public void setTitleweb(String titleweb) {
        this.titleweb = titleweb;
    }

    @Override
    public String toString() {
        return "WorkResponsePayload{" +
                "workid=" + workid +
                ", authorweb='" + authorweb + '\'' +
                ", titleweb='" + titleweb + '\'' +
                '}';
    }
}
