package library.core.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "LIBRARIES")
public class Library {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String city;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "library")
	private List<Book> books;

//	@OneToMany(fetch = FetchType.LAZY,cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
//	@JoinTable(name = "libraries_vs_customers", joinColumns = @JoinColumn(name = "library_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Library() {
	}

	public Library(String name) {
		super();
		this.name = name;
	}

	public Library(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean removeBook(Book book) {
		return this.books.remove(book);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Library [id=" + id + ", name=" + name + ", city=" + city + ", books=" + books + "]";
	}

	public void addBook(Book book) {
		if (this.books == null) {
			this.books = new ArrayList<Book>();
		}
		book.setLibrary(this);
		this.books.add(book);
	}

}
