package member;

public class Member {

    private Long id;
    private String name;

    private Member(Builder builder) {
        this.name = builder.name;
    }

    public void setId(Long id) {
        this.id = id;
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
        private String name;

        public Builder name(String name) {
            this.name = name;
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