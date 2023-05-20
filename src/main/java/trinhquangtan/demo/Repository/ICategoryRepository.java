package trinhquangtan.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trinhquangtan.demo.enity.Category;
@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
