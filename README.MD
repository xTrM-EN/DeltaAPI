# DeltaAPI

Ce repository contient l'API publique de Delta Client. 

## Utiliser

Vous pouvez importer l'API en utilisant Gradle 
```gradle
repositories {
    jcenter()

    maven {
        url = "https://nkosmos.github.io/maven/" // DeltaAPI
    }
}

dependencies {
    compile("me.xtrm.delta:delta-api-deobf:2.0.4")  // Version deobf, à utiliser dans un environement de développement
//  compile("me.xtrm.delta:delta-api:2.0.4")        // Version obf, à utiliser dans un environement compilé
}
```

## Compiler

Si vous souhaitez le compiler vous-même:
```bash
# Clone the current repo
git clone https://github.com/xTrM-EN/DeltaAPI.git

# Enter the cloned repo
cd DeltaAPI/

# Build the artifacts
gradlew build
```