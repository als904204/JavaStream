# JavaStream

- filter

```java
    // 스트림을 사용한 회원 조회
    public List<Member> findMembersByName(String name) {
        System.out.println("DB : ("+name+") 모든 이름 조회");
        return memberStore.values().stream()
            .filter(m -> m.getName().equals(name))
            .toList();
    }
    
    // name 을 포함한 회원 Stream 조회
    public List<Member> findMembersByContainingName
        (String name) {
        return memberStore.values().stream()
        .filter(m -> m.getName().contains(name))
        .toList();
        }
    
    // age 보다 낮은 회원 목록 조회
    public List<Member> findMemberYoungerThan(int age) {
        System.out.println("DB : " + age +" 보다 나이가 낮은 회원 조회");
        return memberStore.values().stream()
        .filter(m -> m.getAge()< age)
        .toList();
        }
        
    // fromAge 부터 toAge 의 회원 조회
    public List<Member> findMemberBetweenByAge(int fromAge, int toAge) {
        System.out.println("DB : " + fromAge + "," + toAge+ "사이 나이 회원 조회");
    
        return memberStore.values().stream()
        .filter(m -> m.getAge() > fromAge && m.getAge() < toAge)
        .toList();
        }

```

- count
```java
    // 해당 이름을 가진 회원 수 조회
   public long countMembersWithSpecificName(String name) {
        return memberStore.values().stream()
            .filter(m -> m.getName().equals(name))
            .count();
    }
```

- map
```java
    // stream Map 을 이용하여 형 변환 후 리턴
    public List<String> getMemberNamesToUpperCased() {
        System.out.println("DB : 모든 회원의 이름을 대문자로 변경하여 조회");
        return memberStore.values().stream()
            .map(m -> m.getName().toUpperCase())
            .toList();
    }
```

- limit
```java
    // limit 만큼만 회원 조회
    public List<Member> getMembersByLimit(int limit) {
        System.out.println("DB : "+ limit+" 만큼만 회원 조회");
        return memberStore.values().stream()
            .limit(limit)
            .toList();
    }

    
    // 중복된 이름을 제거한 회원 이름 리스트
    public List<String> getDistinctMemberNames() {
        return memberStore.values().stream()
        .map(Member::getName) // .map(m->m.getName())
        .distinct()
        .toList();
        }
```