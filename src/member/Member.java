package member;

public class Member {

    private Long id;
    private String name;

    private Member(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Member{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }

    // builder pattern
    public static class Builder{
        private Long id;
        private String name;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Member build() {
            // 필요한 경우, 여기서 객체의 유효성 검사를 수행할 수 있습니다.
            return new Member(this);
        }

    }

    public static Builder builder() {
        return new Builder();
    }
}