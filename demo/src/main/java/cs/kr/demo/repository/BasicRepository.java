package cs.kr.demo.repository;

import cs.kr.demo.domain.Basic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicRepository extends JpaRepository<Basic,Long> {
}
