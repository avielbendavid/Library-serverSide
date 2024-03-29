package library.core.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import library.core.entities.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer> {

	public abstract boolean existsByName(String name);
//	public abstract List<Book> findById(Integer id);
}
