#!/bin/bash

# ------ ENVIRONMENT --------------------------------------------------------
# The script depends on various environment variables to exist in order to
# run properly. The java version we want to use, the location of the java
# binaries (java home), and the project version as defined inside the pom.xml
# file, e.g. 1.0-SNAPSHOT.
#
# PROJECT_VERSION: version used in pom.xml, e.g. 1.0-SNAPSHOT
# APP_VERSION: the application version, e.g. 1.0.0, shown in "about" dialog

MAIN_JAR="onepage-fx-$PROJECT_VERSION.jar"
APPLICATION_NAME=OnePageFx
MAIN_CLASS=com.github.namuan.onepagefx.MainApplicationKt
VENDOR="DeskRiders"
PACKAGE_NAME=OnePageFx

# Set desired installer type: "dmg", "pkg".
INSTALLER_TYPE=dmg

echo "java home: $JAVA_HOME"
echo "project version: $PROJECT_VERSION"
echo "app version: $APP_VERSION"
echo "main JAR file: $MAIN_JAR"

# ------ SETUP DIRECTORIES AND FILES ----------------------------------------
# Remove previously generated java runtime and installers. Copy all required
# jar files into the input/libs folder.

rm -rfd ./target/java-runtime/
rm -rfd target/installer/

mkdir -vp target/installer/input/libs/

cp -R target/app/lib/* target/installer/input/libs/
cp target/${MAIN_JAR} target/installer/input/libs/

# ------ PACKAGING ----------------------------------------------------------
echo "Creating installer of type $INSTALLER_TYPE"

$JAVA_HOME/bin/jpackage \
  --type dmg \
  --dest target/installer \
  --input target/installer/input/libs \
  --name OnePageFx \
  --main-class com.github.namuan.onepagefx.MainApplicationKt \
  --main-jar onepage-fx-1.0-SNAPSHOT.jar \
  --java-options -Xmx2048m \
  --runtime-image target/app \
  --icon src/main/resources/app.icns \
  --app-version 1.0.0 \
  --vendor "DeskRiders" \
  --copyright "Copyright © 2022-23 DeskRiders" \
  --mac-package-identifier com.github.namuan.onepagefx \
  --mac-package-name DeskRiders
