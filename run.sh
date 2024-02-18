#!/bin/bash
# Program:
#	构建 Maven 生命周期，以及运行 jar 包。
# History:
# 17/02/2024    meyok     First release

if [ $# -ne 1 ]; then
    echo "Usage: $0 {phase|run}"
else
    case $1 in
        "clean")
            mvn clean >> /dev/null
            ;;
        "compile"|"test"|"package"|"install"|"deploy")
            mvn clean $1 >> /dev/null
            ;;
        "site")
            echo "Not yet supported."
            ;;
        "run")
            mvn clean package
            JAR_NAME=$(ls -l ./target | grep -m 1 '^.*\.jar$' | cut -d ' ' -f 9-9)
            java -jar ./target/${JAR_NAME}
            ;;
        *)
            echo "Illegal or unsupported option. Only support clean, compile, test, package, install, deploy, site and run."
            ;;
    esac
fi
