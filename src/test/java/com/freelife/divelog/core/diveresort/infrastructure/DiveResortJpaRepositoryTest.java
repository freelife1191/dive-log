package com.freelife.divelog.core.diveresort.infrastructure;

import com.freelife.divelog.core.diveresort.domain.DiveResortRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@InMemoryDataJpaTest
class DiveResortJpaRepositoryTest {
    @Autowired
    DiveResortRepository diveResortRepository;

    @Test
    void test() {
//        DiveResort diveResort = DiveResort.create("Test", "강원도 동해시", "Tester", "82-010-0000-0000");
//        
//        diveResortRepository.save(diveResort);
//        
//        assertThat(diveResort.getId()).isNotNull();
    }
}
