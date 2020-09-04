# deskera-books-sdk-java

This is Java SDK for [Deskera Books](https://www.deskera.com/books/)

# How to Use

## Maven

Add the repository path in `pom.xml`

```xml
<repositories>
  ...	
  <repository>
    <id>repository.deskera</id>
    <name>Deskera SDK Repository</name>
    <url>https://nexus.deskera.com/repository/deskera-sdk-java-snapshot/</url>
  </repository>
</repositories>
```

Add the dependency
```xml
<dependencies>
  ...	
  <dependency>
    <groupId>com.deskera.sdk.common</groupId>
    <artifactId>deskera-sdk-java</artifactId>
    <version>0.0.2-SNAPSHOT</version>
  </dependency>
<dependencies>  
```

## Gradle

Add the repository path in `build.gradle`
```
repositories {
  mavenCentral()
  maven {
    url 'https://nexus.deskera.com/repository/deskera-sdk-java-snapshot'
  }
}
```

Add the dependency
```
dependencies {
  ...
  implementation("com.deskera.sdk.common:deskera-sdk-java:0.0.2-SNAPSHOT") { changing = true }
  ...
}
```

## License

[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://github.com/Deskera/deskera-books-sdk-java/raw/master/LICENSE)
