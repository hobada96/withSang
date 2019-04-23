package cs.kr.demo.domain;

import cs.kr.demo.repository.WorkRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WorkTest {
    @Autowired
    WorkRepository workRepository;
    Work saveWork;

    @Before
    public void init(){
        Work work = Work.builder().company()
                                  .endDate()
                                  .position()
                                  .startDate()
                                  .endDate()
                                  .summry()
                                  .build();
    }
    @Test
    public void loadWork(){
        Work
    }
}
