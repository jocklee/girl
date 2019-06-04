package com.klee.girl.service;

import com.klee.girl.domain.Girl;
import com.klee.girl.enums.ResultEnums;
import com.klee.girl.exception.GirlException;
import com.klee.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setAge(18);
        girlA.setCupSize("B");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(19);
        girlB.setCupSize("B");
        girlRepository.save(girlB);

    }

    public void getAge(Integer id) throws Exception {
        Optional<Girl> girl = girlRepository.findById(id);
        Integer age = girl.get().getAge();
        if (age < 10) {
            //小学 code:100
            throw new GirlException(ResultEnums.PRIMARY_SCHOOL);

//            throw new GirlException(100,"小学");
        } else if (age > 10 && age < 16) {
            //初中 code:101
            throw new GirlException(ResultEnums.MIDDLE_SCHOOL);

//            throw new GirlException(101,"初中");
        }
    }

    /**
     * 通过id查询一个女生的信息
     *
     * @param id
     * @return
     */
    public Optional<Girl> findOne(Integer id) {

        return girlRepository.findById(id);
    }

}
