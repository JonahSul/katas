package com.katas;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import com.katas.Password;

public class PasswordTest {

    private final Password password = new Password("password123");

    @Test
    void shouldThrowIllegalArgumentExceptionOnEmptyPassword() {
        assertThatThrownBy(() -> new Password(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Password cannot be empty");
    }

    @Test
    void shouldValidateCorrectPassword() {
        assertThat(password.validate("password123")).isTrue();
    }

    @Test
    void shouldInvalidateIncorrectPassword() {
        assertThat(password.validate("wrongpassword")).isFalse();
    }
}
