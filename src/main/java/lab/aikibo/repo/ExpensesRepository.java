package lab.aikibo.repo;

import lab.aikibo.entity.Expense;
import lab.aikibo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by tamami on 31/12/16.
 */
public interface ExpensesRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByUserOrderByDateDesc(User user);

}
