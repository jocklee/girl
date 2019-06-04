package com.klee.girl.controller;

import com.klee.girl.domain.Girl;
import com.klee.girl.domain.Result;
import com.klee.girl.repository.GirlRepository;
import com.klee.girl.service.GirlService;
import com.klee.girl.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * @return List
     * @GET 查询所有女生列表
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {

        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     *
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
//    public Girl girlAdd(@RequestParam("cupSize") String mycupSize,
//                        @RequestParam("age") Integer myage) {
        if (bindingResult.hasErrors()) {

            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 查询指定ID的信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Optional<Girl> queryId(@PathVariable("id") Integer id) {

        return girlRepository.findById(id);
    }

    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupsize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setID(id);
        girl.setCupSize(cupsize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {

        girlRepository.deleteById(id);

    }

    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

    @GetMapping(value = "/girl/query")
    public List<Girl> mQuery(@RequestParam("age") Integer age,
                             @RequestParam("cupSize") String cup) {

        return girlRepository.withAgeAndCupSize(age, cup);

    }

    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);

    }


}
