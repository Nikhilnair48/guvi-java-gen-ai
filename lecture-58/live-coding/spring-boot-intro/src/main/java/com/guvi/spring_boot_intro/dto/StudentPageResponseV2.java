package com.guvi.spring_boot_intro.dto;

import java.util.List;

public class StudentPageResponseV2<T> {
    private List<T> items;
    private Metadata meta;

    public StudentPageResponseV2(List<T> items, Metadata meta) {
        this.items = items;
        this.meta = meta;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Metadata getMeta() {
        return meta;
    }

    public void setMeta(Metadata meta) {
        this.meta = meta;
    }

    public static class Metadata {
        private int page;
        private int size;
        private long totalItems;
        private int totalPages;
        private String sortBy;
        private String sortDir;

        public Metadata(int page, int size, long totalItems, int totalPages, String sortBy,
                        String sortDir) {
            this.page = page;
            this.size = size;
            this.totalItems = totalItems;
            this.totalPages = totalPages;
            this.sortBy = sortBy;
            this.sortDir = sortDir;
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

        public long getTotalItems() {
            return totalItems;
        }

        public void setTotalItems(long totalItems) {
            this.totalItems = totalItems;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public String getSortBy() {
            return sortBy;
        }

        public void setSortBy(String sortBy) {
            this.sortBy = sortBy;
        }

        public String getSortDir() {
            return sortDir;
        }

        public void setSortDir(String sortDir) {
            this.sortDir = sortDir;
        }
    }
}
