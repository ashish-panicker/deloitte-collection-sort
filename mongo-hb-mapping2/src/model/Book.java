package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Book {

	@Id
	@GeneratedValue(generator = "uid")
	@GenericGenerator(name = "uid", strategy = "uuid2")
	private String id;

	private String title;

	@OneToOne
	private Publisher publisher;

	@OneToMany
	private Set<Category> categories = new HashSet<>();

	@ManyToMany
	private Set<Author> authors = new HashSet<>();

	public Book() {
	}

	public Book(String title, Publisher publisher, Set<Category> categories) {
		this.title = title;
		this.publisher = publisher;
		this.categories = categories;
	}

	public Book(String title, Publisher publisher, Set<Category> categories, Set<Author> authors) {
		this.title = title;
		this.publisher = publisher;
		this.categories = categories;
		this.authors = authors;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

}
