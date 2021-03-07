package library.core.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer age;
	private String email;
	private String password;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Book> books;

	public Customer() {
	}
	

	public Customer(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Customer(Integer id, String name, Integer age, List<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.books = books;
	}

	public Customer(String name, Integer age, String email, String password) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void addBook(Book book) {
		if(this.books==null) {
			this.books=new ArrayList<Book>();
		}
		this.books.add(book);
	}
	
	public void removeBook(Book book) {
		this.books.remove(book);
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
