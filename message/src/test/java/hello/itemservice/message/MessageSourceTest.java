package hello.itemservice.message;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource ms;

    @Test
    @DisplayName("Hello Message")
    public void helloMessage() throws Exception {
        // given
        String result = ms.getMessage("hello", null, null);
        assertThat(result).isEqualTo("안녕");

        // when

        // then
    }

    @Test
    @DisplayName("")
    public void notFoundMessageCode() throws Exception {
        // given
        assertThatThrownBy(() -> ms.getMessage("no_code", null, null)).isInstanceOf(NoSuchMessageException.class);
        // when

        // then
    }

    @Test
    @DisplayName("")
    public void notFoundMessageCode2() throws Exception {
        // given
        String result = ms.getMessage("no_code", null,"default Message", null);
        assertThat(result).isEqualTo("default Message");
        // when

        // then
    }

    @Test
    public void argumentMessage() {
        String message = ms.getMessage("hello.name", new Object[]{"Spring"}, null);
        System.out.println("message = " + message);
        assertThat(message).isEqualTo("안녕 Spring");
    }
}
