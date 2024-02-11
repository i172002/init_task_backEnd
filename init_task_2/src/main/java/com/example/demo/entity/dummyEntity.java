package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class dummyEntity {
  @Id	
  private int id;
  @Column(nullable=false)
  private String name; 
}
