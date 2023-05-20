package trinhquangtan.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trinhquangtan.demo.enity.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {
}
