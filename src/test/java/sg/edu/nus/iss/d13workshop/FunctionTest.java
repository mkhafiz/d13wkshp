package sg.edu.nus.iss.d13workshop;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class FunctionTest {
    private Logger logger = Logger.getLogger(FunctionTest.class.getName());

    private Path workingDir;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void readContact() throws IOException {
        this.workingDir = Path.of("", "c:/data");
        Path file = this.workingDir.resolve("f6af153c");
        String content = Files.readString(file);
        assertThat(content, is(notNullValue()));
    }

    @Test
    public void saveContact() throws Exception {
        MultiValueMap<String, String> payload = new LinkedMultiValueMap<String, String>();
        payload.add("name", "Mike");
        payload.add("email", "Mike@mail.com");
        payload.add("phone", "1245678");

        logger.log(Level.INFO, "" + objectMapper.writeValueAsString(payload));

    }

    // mvn clean test -> will run for test file in test folder
}
