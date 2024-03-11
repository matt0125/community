# Seperate Files

To run JUnit tests where your code and your tests are in seperate files, you have to modify your request a bit.

 The only change you have to make is to run each submission as a "Multi-file program" that requires a compile and run command in the form of a bash script that are as follow:

### Compilation Command
```bash
/usr/local/openjdk14/bin/javac -cp /usr/local/junit-platform-console-standalone-1.6.2/launcher.jar:. MainTest.java
```

### Run Command
```bash
/usr/local/openjdk14/bin/java -jar /usr/local/junit-platform-console-standalone-1.6.2/launcher.jar --disable-ansi-colors --disable-banner -cp . -c MainTest
```

This is the exact run command Judge0 extra CE originally uses, it just doesn't compile with the other classes in the current directory as this does due to the addition of `:.` after the jar source in the compilation command. This allows code to remain unaltered when being tested - preserving all original run expectations and allowing you to not have to worry about modifying code to work within a test class.

## API Request

To pass this request to your Judge0 Extra CE api, first base64 encode a the `additional_files` direcotry by using

```bash
cd ./additional_files
zip -r - . | base64
```

Then simpily make a post request at `/submissions/?base64_encoded=true` like so:

```json
{
    "language_id": "89",
    "additional_files": "{BASE64_ZIP}"
}
```