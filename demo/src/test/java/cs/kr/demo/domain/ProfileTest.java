package cs.kr.demo.domain;

import cs.kr.demo.repository.ProfileRopository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProfileTest {
    @Autowired
    ProfileRopository profileRopository;
    Profile saveProfile;

    @Before
    public void init(){
        Profile profile = Profile.builder().network("")
                                           .userName("")
                                           .url("")
                                           .build();
    }

    @Test
    public void testRoad(){
        Profile findProfile = profileRopository.findById(saveProfile.getIdx()).orElse(null);
        assertThat(findProfile.getIdx()).isEqualTo(saveProfile.getIdx());
    }
}
