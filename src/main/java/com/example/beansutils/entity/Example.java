package com.example.beansutils.entity;

import com.example.beansutils.dto.ExampleDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Example {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    // dto to entity
    public Example(ExampleDto exampleDto) {
        BeanUtils.copyProperties(exampleDto, this);
    }

    // entity to dto
    public ExampleDto toDto() {
        ExampleDto exampleDto = new ExampleDto();
        BeanUtils.copyProperties(this, exampleDto);
        return exampleDto;
    }

    // entitys to dtos
    public static List<ExampleDto> toDtos(Iterable<Example> examples) {
        return StreamSupport.stream(examples.spliterator(), false).map((Example::toDto)).collect(Collectors.toList());
    }
}
