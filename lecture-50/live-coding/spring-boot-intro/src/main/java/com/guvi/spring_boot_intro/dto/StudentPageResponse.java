package com.guvi.spring_boot_intro.dto;

import java.util.List;

import com.guvi.spring_boot_intro.model.Student;

public class StudentPageResponse {
    private List<Student> items;
    private int page;
    private int size;
    private int total;

    public StudentPageResponse(List<Student> items, int page, int size, int total) {
        this.items = items;
        this.page = page;
        this.size = size;
        this.total = total;
    }

    public List<Student> getItems() {
        return items;
    }

    public void setItems(List<Student> items) {
        this.items = items;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
