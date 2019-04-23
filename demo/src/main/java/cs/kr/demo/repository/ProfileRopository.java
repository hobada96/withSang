package cs.kr.demo.repository;

import cs.kr.demo.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRopository extends JpaRepository<Profile,Long> {
}
