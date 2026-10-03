# AA DateTime

AA DateTime is a custom Automation Anywhere package that adds Date Time actions for bots:

- **Get current UTC time** returns the current UTC DateTime.


## Requirements

- Java 11
- The package SDK libraries required by the Gradle build in the `libs` directory

## Build

From the repository root, run:

```text
./gradlew.bat clean build shadowJar
```

In PowerShell, the equivalent command is:

```powershell
.\gradlew.bat clean build shadowJar
```

The Gradle wrapper downloads and uses the configured Gradle version. The build and Shadow JAR outputs are written under `build/`.
