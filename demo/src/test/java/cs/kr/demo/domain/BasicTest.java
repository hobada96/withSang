package cs.kr.demo.domain;

import cs.kr.demo.repository.BasicRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BasicTest {
    @Autowired
    BasicRepository basicRepository;
    Basic saveBasic;
    @Before
    public void init(){
        Basic basic = Basic.builder()
                .name("홍길동")
                .label("웹 프로그래머")
                .email("홍길동@메일주소.도메인")
                .phone("010-1234-5678")
                .build();
        saveBasic = basicRepository.save(basic);
    }
    @Test
    public void testRoad(){
        Basic findBasic = basicRepository.findById(saveBasic.getIdx()).orElse(null);
        assertThat(findBasic.getIdx()).isEqualTo(saveBasic.getIdx());
        System.out.println(findBasic.getLabel());
        System.out.println(findBasic.getEmail());
        System.out.println(findBasic.getName());
        System.out.println(findBasic.getPhone());
    }
}
