package Java_Core.Annotations.Lombok;


import lombok.*;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    private String login;
    private int age;
    @ToString.Exclude
    private String password;


}
