# 기존 for,foreach 단점
자바 8에서 추가한 스트림(Streams)은 람다를 활용할 수 있는 기술 중 하나

자바 8 이전에는 배열 또는 컬렉션 인스턴스를 다루는 방법은 for 또는 foreach 문을 돌면서 요소 하나씩꺼내서 사용

간단한 경우라면 상관없지만 로직이 복잡해질수록 코드가 알아보기 힘들게 됨

---

# 스트림이란? 
- 데이터의 흐름
- 배열 또는 컬렉션 인스턴스에 함수 여러 개를 조합해서 원하는 결과를 필터링하고 가공된 결과를 얻을 수 있음
- 또한 람다를 이용해서 코드의 양을 줄이고 간결하게 표현할 수 있다. 즉, 배열과 컬렉션을 함수형으로 처리
- **간단하게 병렬처리 가능** (하나의 작업을 둘 이상의 작업으로 잘게 나눠서 동시에 진행하는 것)
- 즉 쓰레드를 이용해 많은 요소들을 빠르게 처리 가능

---

# 스트림 구조
1. 생성하기 : 스트림 인스턴스 생성
2. 중간 연산자 : 필터링,맵 등 원하는 결과를 만들어가는 과정
3. 결과 만들기 : 컬렉션으로 만든다거나 원하는 결과로 만들기

---

# 스트림 생성

1. 배열 스트림

```java
Arrays.class

public static <T> Stream<T> stream(T[] array, int startInclusive, int endExclusive) {
    return StreamSupport.stream(spliterator(array, startInclusive, endExclusive), false);
    }

    /***
     * Arrays.class 안에는 stream 을 생성하는 메서드가 정의되어 있다.
     */
 Stream<String> stream1 = Arrays.stream("a","b");
```


2. 컬렉션 스트림
```java
Collection.java
default Stream<E> stream() {
    return StreamSupport.stream(spliterator(), false);
    }
    /**
     * 컬렉션 또한 마찬가지다
     * **/
    List<String> list = Arrays.asList("1","2");
    Stream<String> stream1 = Arrays.stream(list);
    
```
3. 
