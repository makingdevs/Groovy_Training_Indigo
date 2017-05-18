package com.makingdevs.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Task {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String description;
  @Enumerated(EnumType.STRING)
  private TaskStatus status;
  @Column(name="date_created")
  private Date dateCreated;
  @Column(name="last_updated")
  private Date lastUpdated;
  @ManyToOne
  @JoinColumn(name="user_story_id")
  private UserStory userStory;
  @Transient
  private List<User> participants;
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public TaskStatus getStatus() {
    return status;
  }
  public void setStatus(TaskStatus status) {
    this.status = status;
  }
  public Date getDateCreated() {
    return dateCreated;
  }
  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }
  public Date getLastUpdated() {
    return lastUpdated;
  }
  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }
  public UserStory getUserStory() {
    return userStory;
  }
  public void setUserStory(UserStory userStory) {
    this.userStory = userStory;
  }
  public List<User> getParticipants() {
    return participants;
  }
  public void setParticipants(List<User> participants) {
    this.participants = participants;
  }
  @Override
  public String toString() {
    return "Task [id=" + id + ", description=" + description + ", status=" + status + ", dateCreated=" + dateCreated
        + ", lastUpdated=" + lastUpdated + ", userStory=" + userStory + "]";
  }

}