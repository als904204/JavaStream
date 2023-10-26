package member;

public class Member {

    private Long id;
    private String name;

    private int age;

    private Member(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getAge(){
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Member{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age='" + age + '\'' +
            '}';
    }

    // builder pattern
    public static class Builder{
        private String name;
        private int age;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Member build() {
            return new Member(this);
        }

    }

    public static Builder builder() {
        return new Builder();
    }
}