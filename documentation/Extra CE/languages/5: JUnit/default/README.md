# Default

The defualt JUnit testing call should include all source files in the test source file and should look something like

> MainTest.java
```java
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MainTest {
    static class Calculator {
        public int add(int x, int y) {
            return x + y;
        }
    }

    private final Calculator calculator = new Calculator();

    @Test
    void addition() {
        assertEquals(2, calculator.add(1, 1));
    }
}
```

To pass this request to your Judge0 Extra CE api, first base64 encode the file by using

```bash
base64 -i "MainTest.java"
```
Where MainTest.java is the file name of your source file. Then simpily make a post request at `/submissions/?base64_encoded=true` like so:

```json
{
    "source_code": "{BASE64_SOURCE}",
    "language_id": "5"
}
```