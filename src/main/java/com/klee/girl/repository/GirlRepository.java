package com.klee.girl.repository;

import com.klee.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <类名，Id类型></>
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {


    public List<Girl> findByAge(Integer age);

    Girl findByCupSizeAndAge(String cupSize, Integer age);

    @Query("select g from Girl g where  g.age=:age and g.cupSize=:cup")
    List<Girl> withAgeAndCupSize(@Param("age") Integer age, @Param("cup") String cup);

//    @Query("select g from Girl g where  g.ID=:id ")
//    Girl findById(@Param("id") Integer id);

}
