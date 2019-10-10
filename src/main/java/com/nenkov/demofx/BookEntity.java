package com.nenkov.demofx;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class BookEntity {
  @Generated(GenerationTime.INSERT)
  @Column(
      name = "added_on",
      nullable = false,
      updatable = false,
      insertable = false,
      columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private java.sql.Timestamp addedOn;

  @Id @GeneratedValue private Long id;
  private String title;
  private String isbn;

  public BookEntity() {
    // this is needed
  }

  public BookEntity(String title, String isbn) {
    this.isbn = isbn;
    this.title = title;
  }

  public Timestamp getAddedOn() {
    return addedOn;
  }

  public void setAddedOn(Timestamp addedOn) {
    this.addedOn = addedOn;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }
}
