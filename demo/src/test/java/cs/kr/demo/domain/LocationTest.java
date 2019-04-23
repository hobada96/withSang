package cs.kr.demo.domain;

import cs.kr.demo.repository.LocationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LocationTest {
    @Autowired
    LocationRepository locationRepository;
    Location saveLocation;

    @Before
    public void init(){
        Location location = Location.builder().address("부산광역시 OO구 OO번길 OOO")
                                              .postCode("12345")
                                              .build();
        saveLocation = locationRepository.save(saveLocation);
    }

    @Test
    public void testRoad(){
        Location location = locationRepository.findById(saveLocation.getIdx()).orElse(null);
        assertThat(saveLocation.getIdx()).isEqualTo(saveLocation.getIdx());
    }
}
