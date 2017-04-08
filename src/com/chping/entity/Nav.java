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
@Table(name="nav")
@Scope("prototype")
public class Nav {
	private String id;
	private String navName;
	private String children;
	
	public Nav(){
		
	}
	
	public Nav(String id, String navName, String children) {
		super();
		this.id = id;
		this.navName = navName;
		this.children = children;
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
	
	@Column(name = "navName", unique=true, length = 255)
	public String getNavName() {
		return navName;
	}
	public void setNavName(String navName) {
		this.navName = navName;
	}
	
	@Column(name = "children", unique=true, length = 500)
	public String getChildrenType() {
		return children;
	}
	public void setChildrenType(String children) {
		this.children = children;
	}
	
	@Override
	public String toString() {
		return "Nav [id=" + id + ", navName=" + navName + ", children="
				+ children + "]";
	}
}
