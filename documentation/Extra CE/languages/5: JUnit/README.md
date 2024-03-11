# Context
Java unit testing is made simple with Judge0 extra CE using JUnit Platform Console Standalone 1.6.2 natively. The only change we had to make was to run each submission as a "Multi-file program" that requires a compile and run command in the form of a bash script that are as follow:

### Compilation Command
```bash
/usr/local/openjdk14/bin/javac -cp /usr/local/junit-platform-console-standalone-1.6.2/launcher.jar $ARGS MainTest.java
```
Where ```$ARGS``` are any ```compiler_options``` that are passed in the body of the submission request.

### Run Command
```bash
/usr/local/openjdk14/bin/java -jar /usr/local/junit-platform-console-standalone-1.6.2/launcher.jar --disable-ansi-colors --disable-banner -cp . -c MainTest $ARGS
```
Where ```$ARGS``` are any ```command_line_arguments``` that are passed in the body of the submission request.

<!-- ## Defualt Expectations

The default compilation and run commands expect the ```source_code``` attribute to contain all classes you want to test. -->

## Response

### Status

If all tests pass, Judge0 will return a status of:

``` json
{
    "id": 3,
    "description": "Accepted"
}
```

If any tests fail, Judge0 returns a status of:
```json
{
    "id": 11,
    "description": "Runtime Error (NZEC)"
}
```

### Debugging
Sometimes Judge0 cannot decode base64 reponses. I have found by replacing all occuring `\n` with a return line, I can manually decode attributes.