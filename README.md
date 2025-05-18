## demofx

This project demonstrates how to combine **JavaFX 21** with **Spring Boot 3.2.5** for modern desktop applications, including PostgreSQL integration and native packaging for Ubuntu.

### Key Steps

- **Spring Boot 3.x** is used for backend and dependency injection.
- **JavaFX 21** is used for the GUI.
- **PostgreSQL** is the database (see `application.properties` for config).
- **Maven** manages dependencies and build.
- **jpackage** is used to create a native Ubuntu `.deb` installer.

---

### Prerequisites

- JDK 21 (with `jpackage` tool)
- Maven
- JavaFX SDK 21 (if not bundled with your JDK)
- PostgreSQL running locally
- Ubuntu Linux

---

### Build & Run (Development)

1. **Install dependencies:**
   ```sh
   sudo apt update
   sudo apt install fakeroot binutils
   ```

2. **Configure your database in** `src/main/resources/application.properties`:
   ```
   spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
   spring.datasource.username=myuser
   spring.datasource.password=mypassword
   ```

3. **Build and run with Maven:**
   ```sh
   mvn clean javafx:run
   ```

---

### Build a Native Ubuntu Executable (.deb)

1. **Package your app:**
   ```sh
   mvn clean package
   ```

2. **Create a .deb installer using jpackage:**
   ```sh
   jpackage \
     --type deb \
     --input target/ \
     --name demofx \
     --main-jar demofx-0.1.0.jar \
     --main-class com.nenkov.demofx.DemoFxApplication \
     --icon books.png \
     --dest dist/
   ```

   - Make sure `books.png` exists or remove the `--icon` option.

3. **Install the generated .deb:**
   ```sh
   sudo dpkg -i dist/demofx_*.deb
   ```

---

### Troubleshooting

- If you see errors about missing JavaFX modules, ensure your JDK includes JavaFX or add the JavaFX SDK to your module path.
- For missing tools (`fakeroot`, `objcopy`), install `fakeroot` and `binutils` as shown above.
- If you get resource bundle errors, ensure `src/main/resources/application.properties` exists.

---

### References

- [JavaFX Maven Plugin](https://github.com/openjfx/javafx-maven-plugin)
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [jpackage Documentation](https://docs.oracle.com/en/java/javase/21/docs/specs/man/jpackage.html)

---

### Original Student Talk

- [Slides](https://docs.google.com/presentation/d/16hXscc03pJCwr5SNsfy5kQE9_MlyHHrnWfGY39nm6II/edit?usp=sharing)