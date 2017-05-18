package com.makingdevs.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Sprint {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String description;
  @Column(name = "start_date")
  private Date startDate;
  @Column(name = "end_date")
  private Date endDate;
  @Column(name = "date_created")
  private Date dateCreated;
  @Column(name = "last_updated")
  private Date lastUpdated;
  @ManyToOne
  @JoinColumn(name = "project_id")
  private Project project;
  @OneToMany
  @JoinTable(name = "sprint_user_story", joinColumns = @JoinColumn(name = "sprint_id"), inverseJoinColumns = @JoinColumn(name = "user_story_id"))
  private List<UserStory> sprintBacklog;

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
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

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public List<UserStory> getSprintBacklog() {
    return sprintBacklog;
  }

  public void setSprintBacklog(List<UserStory> sprintBacklog) {
    this.sprintBacklog = sprintBacklog;
  }

  @Override
  public String toString() {
    return "Sprint [id=" + id + ", name=" + name + ", description=" + description + ", startDate=" + startDate
        + ", endDate=" + endDate + ", dateCreated=" + dateCreated + ", lastUpdated=" + lastUpdated + ", project="
        + project + "]";
  }
}
