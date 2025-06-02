import static org.junit.jupiter.api.Assertions.*;

import caunvde180736.example.AccountService;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class AccountServiceTest {

    private static AccountService service;
    private static final String RESULT_FILE = "UnitTest.csv";

    @BeforeAll
    public static void setup() {
        service = new AccountService();
    }

    @Test
    public void testRegisterAccountFromFile() {
        List<String> resultLines = new ArrayList<>();
        resultLines.add("username,password,email,expected,actual,result");

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test-data.csv");
            if (inputStream == null) {
                fail("Test data file not found in resources.");
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            List<String> lines = new ArrayList<>();
            reader.lines().forEach(lines::add);
            lines.remove(0);

            for (String line : lines) {
                String[] parts = line.split(",");
                String username = parts[0];
                String password = parts[1];
                String email = parts[2];
                boolean expected = Boolean.parseBoolean(parts[3]);

                boolean actual = service.registerAccount(username, password, email);
                boolean result = (expected == actual);

                resultLines.add(String.join(",", username, password, email,
                        String.valueOf(expected), String.valueOf(actual),
                        result ? "PASS" : "FAIL"));

                assertEquals(expected, actual, "Test failed for: " + line);
            }
            Files.write(new File(RESULT_FILE).toPath(), resultLines);

        } catch (IOException e) {
            fail("Failed to read or process test data file: " + e.getMessage());
        }
    }
}
