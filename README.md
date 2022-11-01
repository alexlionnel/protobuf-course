### Pour générer le fichier js à partir du proto

```bash
cd src/main/proto 
../../../target/protoc-plugins/protoc-3.19.2-osx-x86_64.exe --js_out=./ *.proto
```

On peut aussi utliliser protoc https://github.com/protocolbuffers/protobuf/releases