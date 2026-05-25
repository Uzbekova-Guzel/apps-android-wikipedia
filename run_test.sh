#!/usr/bin/env bash
set -e

AVD_NAME="emulator-5584"
AVD_PORT="5584"
SERIAL="emulator-${AVD_PORT}"

# 1. Create emulator
echo "Creating AVD..."
avdmanager create avd \
  --name "$AVD_NAME" \
  --package "system-images;android-34;google_apis;arm64-v8a" \
  --device "pixel"

# 2. Start emulator in background
echo "Starting emulator..."
emulator -avd "$AVD_NAME" \
  -no-snapshot \
  -wipe-data \
  -port "$AVD_PORT" \
  -skin 720x1280 \
  -gpu host &

EMULATOR_PID=$!

# 3. Wait for emulator to finish booting (up to 3 minutes)
echo "Waiting for emulator to boot..."
sleep 60
echo "Emulator booted."

# 4. Run test
echo "Running test..."
./gradlew app:connectedAlphaDebugAndroidTest \
  -Pandroid.testInstrumentationRunnerArguments.class=org.wikipedia.lesson26.homework.MyRunWatcherInterceptorTest#simpleTest

# 5. Kill emulator
echo "Stopping emulator..."
adb -s "$SERIAL" emu kill

# 6. Open Allure report
echo "Generating Allure report..."
allure serve app/build/allure-results