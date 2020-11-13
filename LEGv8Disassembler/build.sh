./gradlew build
./gradlew fatJar

cp -f build/libs/LEGv8Disassembler-all-1.0.jar hw2.jar

java -cp hw2.jar com.tylerj.LEGv8Disassembler.Main