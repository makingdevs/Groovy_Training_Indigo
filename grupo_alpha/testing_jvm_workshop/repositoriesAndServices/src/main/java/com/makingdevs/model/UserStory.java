package com.makingdevs.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_story")
public class UserStory {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String description;
  private Integer priority;
  private Integer effort;
  @Column(name="date_created")
  private Date dateCreated;
  @Column(name="last_updated")
  private Date lastUpdated;
  @ManyToOne
  @JoinColumn(name="project_id")
  private Project project;
  @OneToMany(mappedBy = "userStory")
  private List<Task> tasks;
  
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
  public Integer getPriority() {
    return priority;
  }
  public void setPriority(Integer priority) {
    this.priority = priority;
  }
  public Integer getEffort() {
    return effort;
  }
  public void setEffort(Integer effort) {
    this.effort = effort;
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
  public List<Task> getTasks() {
    return tasks;
  }
  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }
  @Override
  public String toString() {
    return "UserStory [id=" + id + ", description=" + description + ", priority=" + priority + ", effort=" + effort
        + ", dateCreated=" + dateCreated + ", lastUpdated=" + lastUpdated + ", project=" + project + "]";
  }

}