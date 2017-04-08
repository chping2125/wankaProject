package com.chping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="type")
@Scope("prototype")
public class Type {
	private String id;
	private String typeName;
	private String childrenType;
	
	public Type(){
		
	}
	
	public Type(String id, String typeName, String childrenType) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.childrenType = childrenType;
	}
	
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 100)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "typeName", unique=true, length = 255)
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	@Column(name = "childrenType", unique=true, length = 500)
	public String getChildrenType() {
		return childrenType;
	}
	public void setChildrenType(String childrenType) {
		this.childrenType = childrenType;
	}
	
	@Override
	public String toString() {
		return "Type [id=" + id + ", typeName=" + typeName + ", childrenType="
				+ childrenType + "]";
	}
}
