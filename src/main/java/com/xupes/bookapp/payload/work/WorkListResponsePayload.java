package com.xupes.bookapp.payload.work;

import java.util.List;

public class WorkListResponsePayload {

    private List<WorkResponsePayload> work;

    public List<WorkResponsePayload> getWork() {
        return work;
    }

    public void setWork(List<WorkResponsePayload> work) {
        this.work = work;
    }
}
