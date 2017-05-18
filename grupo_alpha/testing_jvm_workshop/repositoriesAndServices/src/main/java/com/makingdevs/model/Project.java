package com.makingdevs.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  @Column(name = "code_name")
  private String codeName;
  private String description;
  @Column(name = "date_created")
  private Date dateCreated;
  @Column(name = "last_updated")
  private Date lastUpdated;
  @OneToMany(mappedBy = "project")
  private List<UserStory> userStories;
  @Transient
  private List<User> participants;

  public Project() {
    super();
  }

  public Project(String name, String codeName, String description) {
    super();
    this.name = name;
    this.codeName = codeName;
    this.description = description;
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

  public String getCodeName() {
    return codeName;
  }

  public void setCodeName(String codeName) {
    this.codeName = codeName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

  public List<UserStory> getUserStories() {
    return userStories;
  }

  public void setUserStories(List<UserStory> userStories) {
    this.userStories = userStories;
  }

  public List<User> getParticipants() {
    return participants;
  }

  public void setParticipants(List<User> participants) {
    this.participants = participants;
  }

  @Override
  public String toString() {
    return "Project [id=" + id + ", name=" + name + ", codeName=" + codeName
        + ", description=" + description + ", dateCreated=" + dateCreated
        + ", lastUpdated=" + lastUpdated + "]";
  }

}