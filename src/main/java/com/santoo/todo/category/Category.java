package com.santoo.todo.category;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Category {
    @Id
    private String categoryId;
    private String categoryName;

    public String getCategoryId() {
        return categoryId;
    }

    public Category(String categoryId,String categoryName){
        this.categoryId=categoryId;
        this.categoryName=categoryName;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
