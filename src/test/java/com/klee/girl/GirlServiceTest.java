package com.klee.girl;

import com.klee.girl.domain.Girl;
import com.klee.girl.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest() {
        Optional<Girl> girl = girlService.findOne(1);
        Assert.assertEquals(new Integer(10), girl.get().getAge());


    }
}
