# Spring Boot BeanUtils

## 1. 설명
Spring Boot BeanUtils 예제이며 Dto에서 Entity 변환은 BeanUtils를 사용하였다. 포트는 8080을 사용한다.

## 2. 개발환경

* OpenJDK 17

* spring-boot 3.0.2

## 3. DTO ↔ Entity
BeanUtils를 이용하여 DTO ↔ Entity 변환

```java
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
```

## 4. API 실행

### 1) 전체 조회

* GET
  - http://localhost:8080/beanutils/

### 2) ID 조회

* GET
  - http://localhost:8080/beanutils/1

### 3) 저장

* POST
  - http://localhost:8080/beanutils/

### 4) 수정

* PUT
  - http://localhost:8080/beanutils/1

### 5) 삭제

* DELETE
  - http://localhost:8080/beanutils/1
