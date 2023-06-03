# JSON Serialization example

This example uses Google's [Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.10.1#gradle) for JSON serialization. See the `build.gradle` file for how to include the dependency. There may be an equivalent for LibGDX but I find Gson the easiest to work with. You can likely include Gson as a dependency in your project.

## How it works

### Project structure

The project structure looks like this:

```
.
├── HELP.md
├── README.md
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── settings.gradle
└── src
    └── main
        ├── java
        │   ├── models
        │   │   └── Dialogue.java
        │   └── stream
        │       └── techygrrrl
        │           └── jsonserialization
        │               ├── FileUtils.java
        │               ├── JsonSerializationApplication.java
        │               └── JsonUtils.java
        └── resources
            ├── application.properties
            ├── static
            │   └── data.json
            └── templates

12 directories, 14 files
```

### Your data

See the `src/main/resources/static/data.json` file. I added some fields explicitly as null to keep the data structure consistent.


### Dialogue model

There is a class in `src/main/java/models/Dialogue.java` that is the POJO (plain old Java object) representation of your dialogue. It has methods to help make it easy to work with.


### Main application

The application is a Java Spring Boot app (for no reason in particular, just that was an option I knew in the Intellijelly config).

The file `src/main/java/stream/techygrrrl/jsonserialization/JsonSerializationApplication.java` has the main code.

What's happening:

1. JSON is being read from file as raw JSON on lines 18-25. The `JsonArray` class is from Gson, which is different than the one you're using.
2. Line 28 we use Gson and reflection to create a type token for the `Dialogue` class, which is the POJO described above.
3. Line 29, Gson will attempt to deserialize the data from the JsonArray into the type defined `ArrayList<Dialogue>`.
4. If this deserialization is successful, lines 32 and onward should run and you should see output about your dialogues printed to the console.


### JSON utils

The Gson implementation is abstracted into this file, which lives at `src/main/java/stream/techygrrrl/jsonserialization/JsonUtils.java`.


### File utils

Reading the static JSON file from the resources directory has been abstracted into this file at `src/main/java/stream/techygrrrl/jsonserialization/FileUtils.java`.


### Project dependencies

As mentioned above, Gson was added to the project and can be seen on line 21 as `implementation 'com.google.code.gson:gson:2.10.1'`.

The dependencies are specified in the Gradle file at `./build.gradle`.


## Console output

When running, you should see the following console output:

<details>
<summary>Console output </summary>


```

🟣🟣🟣🟣🟣🟣🟣🟣🟣🟣🟣🟣🟣🟣

id: 1
next: 2
text: I am the dialogue
The whole dialogue: id = 1 , next = 2 , text = I am the dialogue
Number of response items: 4
-------------------------------------
id: 6
next: null
text: You picked dialogue option 1
The whole dialogue: id = 6 , next = null , text = You picked dialogue option 1
Number of response items: 0
-------------------------------------
id: 7
next: 10
text: You picked dialogue option 2
The whole dialogue: id = 7 , next = 10 , text = You picked dialogue option 2
Number of response items: 0
-------------------------------------
id: 8
next: null
text: You picked dialogue option 3
The whole dialogue: id = 8 , next = null , text = You picked dialogue option 3
Number of response items: 0
-------------------------------------
id: 9
next: null
text: You picked dialogue option 4
The whole dialogue: id = 9 , next = null , text = You picked dialogue option 4
Number of response items: 0
-------------------------------------
id: 10
next: null
text: You are at dialogue of id 10
The whole dialogue: id = 10 , next = null , text = You are at dialogue of id 10
Number of response items: 0
-------------------------------------


🟢🟢🟢🟢🟢🟢🟢🟢🟢🟢🟢🟢🟢🟢








  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.1.0)

2023-06-03T01:13:56.399-07:00  INFO 64782 --- [           main] s.t.j.JsonSerializationApplication       : Starting JsonSerializationApplication using Java 17.0.7 with PID 64782 (path/to/project/json-serialization/build/classes/java/main started by techygrrrl in path/to/project/json-serialization)
2023-06-03T01:13:56.403-07:00  INFO 64782 --- [           main] s.t.j.JsonSerializationApplication       : No active profile set, falling back to 1 default profile: "default"
2023-06-03T01:13:57.064-07:00  INFO 64782 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2023-06-03T01:13:57.072-07:00  INFO 64782 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-06-03T01:13:57.072-07:00  INFO 64782 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.8]
2023-06-03T01:13:57.137-07:00  INFO 64782 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-06-03T01:13:57.137-07:00  INFO 64782 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 700 ms
2023-06-03T01:13:57.414-07:00  INFO 64782 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-06-03T01:13:57.422-07:00  INFO 64782 --- [           main] s.t.j.JsonSerializationApplication       : Started JsonSerializationApplication in 1.318 seconds (process running for 2.242)
```

</details>
