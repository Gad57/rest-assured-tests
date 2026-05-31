package Api.testData;

import Api.models.User;
import net.datafaker.Faker;

public class UserFactory {
    private static final Faker faker = new Faker();

    public static User randomUser(){
        return User.builder().
                name(faker.name().firstName())
                .job(faker.job().title())
                .build();

    }
    public static User qaUser(){
        return User.builder()
                .name("Danil")
                .job("QA")
                .build();
    }
    public static User developerUser(){
        return User.builder()
                .name("Alex")
                .job("Developer")
                .build();
    }
    public static User randomQaUser(){
        return User.builder()
                .name(faker.name().firstName())
                .job("QA")
                .build();
    }
}
