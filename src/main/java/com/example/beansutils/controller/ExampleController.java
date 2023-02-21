package com.example.beansutils.controller;

import com.example.beansutils.dto.ExampleDto;
import com.example.beansutils.service.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/beanutils")
public class ExampleController {
    @Autowired
    ExampleService exampleService;

    /**
     * 전체 조회
     *
     * @return
     */
    @GetMapping("/")
    @ResponseBody
    public List<ExampleDto> findAll() {
        return exampleService.findAll();
    }

    /**
     * id 조회
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ResponseBody
    public ExampleDto findById(@PathVariable("id") String id) {
        return exampleService.findById(id);
    }

    /**
     * 저장
     *
     * @param exampleDto
     */
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ExampleDto save(@RequestBody ExampleDto exampleDto) {
        return exampleService.save(exampleDto);
    }

    /**
     * 수정
     *
     * @param exampleDto
     */
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ExampleDto put(@PathVariable("id") String id, @RequestBody ExampleDto exampleDto) {
        exampleDto.setId(id);
        return exampleService.put(exampleDto);
    }

    /**
     * 삭제
     *
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") String id) {
        exampleService.deleteById(id);
    }
}
