package by.sterlikov.helloservletrun;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode


//@RequiredArgsConstructor // добовляет поля final


@Data
public class Person {
    private int age;
    private String name;
    private String login;
    private String password;

}
