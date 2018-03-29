package org.neo4j.ogm.env.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class User {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private int age;

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public User() {
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
