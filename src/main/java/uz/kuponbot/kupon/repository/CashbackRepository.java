package uz.kuponbot.kupon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.kuponbot.kupon.entity.Cashback;
import uz.kuponbot.kupon.entity.User;

@Repository
public interface CashbackRepository extends JpaRepository<Cashback, Long> {
    
    List<Cashback> findByUserOrderByCreatedAtDesc(User user);
    
    List<Cashback> findByUserAndStatusOrderByCreatedAtDesc(User user, Cashback.CashbackStatus status);
    
    List<Cashback> findAllByOrderByCreatedAtDesc();
}
