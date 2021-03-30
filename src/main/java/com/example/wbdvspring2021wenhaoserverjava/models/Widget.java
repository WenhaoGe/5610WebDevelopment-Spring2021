package com.example.wbdvspring2021wenhaoserverjava.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="widgets")
public class Widget {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String type;
  private Integer size;
  private String text;
  private String topicId;
  private Integer width;
  private Integer height;
  private String src;
  private Boolean ordered;

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public Boolean getOrdered() {
    return ordered;
  }

  public void setOrdered(Boolean ordered) {
    this.ordered = ordered;
  }


  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Widget() {
  }

  public String getTopicId() {
    return topicId;
  }

  public void setTopicId(String topicId) {
    this.topicId = topicId;
  }

  public Widget(Long id, String type, Integer size, String text, String topicId) {
    this.id = id;
    this.type = type;
    this.size = size;
    this.text = text;
    this.topicId = topicId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}

/*
create table widget (
       id bigint not null,
        height integer,
        size integer,
        text varchar(255),
        topic_id varchar(255),
        type varchar(255),
        width integer,
        primary key (id)
    ) engine=InnoDB
 */

/*
create table widgets (
       id bigint not null auto_increment,
        height integer,
        ordered bit,
        size integer,
        src varchar(255),
        text varchar(255),
        topic_id varchar(255),
        type varchar(255),
        width integer,
        primary key (id)
    ) engine=InnoDB
 */