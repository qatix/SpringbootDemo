package com.qatix.hello.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.math.BigDecimal;

@TableName("product")
public class Product extends SuperEntity<Product> {

    @TableId(type = IdType.AUTO) //修改了这个以后需要重新运行才会生效
    private Long id;
    private String name;
    private String model;
    private String no;
    private String description;
    private BigDecimal price;

//    @TableField(value = "category_id")
    private Long categoryId;

    @TableField(exist = false)
    private Category category;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Product[id=%d,name=%s,model=%s,no=%s,price=%f,description=%s]", id, name, model, no, price, description);
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
