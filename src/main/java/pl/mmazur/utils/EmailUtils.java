package pl.mmazur.utils;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmailUtils {

    public static String generateEmail() {
        return new Faker().internet().emailAddress();
    }

}
