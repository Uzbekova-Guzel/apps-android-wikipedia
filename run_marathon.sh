#!/usr/bin/env bash

set -e

# на случай запуска не из корня проекта
cd "$(dirname "$0")"

# ── Конфиг ─────────────────────────────────────────────
AVD_1="marathon-5584"
PORT_1=5584
AVD_2="marathon-5586"
PORT_2=5586
SYSTEM_IMAGE="system-images;android-34;google_apis;arm64-v8a"
DEVICE_PROFILE="pixel"
BOOT_WAIT=120   # 2 минуты на загрузку

# ── Пути к SDK-инструментам ────────────────────────────
SDK_ROOT="${ANDROID_SDK_ROOT:-${ANDROID_HOME:-$HOME/Library/Android/sdk}}"
# явно экспортируем, чтобы Marathon мог найти SDK
export ANDROID_SDK_ROOT="$SDK_ROOT"
export ANDROID_HOME="$SDK_ROOT"
AVDMANAGER="$SDK_ROOT/cmdline-tools/latest/bin/avdmanager"
EMULATOR="$SDK_ROOT/emulator/emulator"
ADB="$SDK_ROOT/platform-tools/adb"

# ── 1. Сборка APK ──────────────────────────────────────
echo "[1/5] Сборка app и test APK..."
./gradlew :app:assembleAlphaDebug :app:assembleAlphaDebugAndroidTest

# ── 2. Создание AVD ────────────────────────────────────
# --force перезаписывает AVD если уже существует
echo "[2/5] Создание AVD..."
echo "no" | "$AVDMANAGER" create avd --force --name "$AVD_1" --package "$SYSTEM_IMAGE" --device "$DEVICE_PROFILE"
echo "no" | "$AVDMANAGER" create avd --force --name "$AVD_2" --package "$SYSTEM_IMAGE" --device "$DEVICE_PROFILE"

# ── 3. Запуск эмуляторов ───────────────────────────────
echo "[3/5] Запуск эмуляторов на портах $PORT_1 и $PORT_2..."
"$EMULATOR" -avd "$AVD_1" -no-snapshot -wipe-data -no-boot-anim -port "$PORT_1" -gpu host >"/tmp/emulator-$PORT_1.log" 2>&1 &
PID_1=$!
"$EMULATOR" -avd "$AVD_2" -no-snapshot -wipe-data -no-boot-anim -port "$PORT_2" -gpu host >"/tmp/emulator-$PORT_2.log" 2>&1 &
PID_2=$!

echo "      Ожидание $BOOT_WAIT сек..."
sleep "$BOOT_WAIT"

# ── 4. Запуск Marathon ─────────────────────────────────
# конфигурация берётся из ./Marathonfile
# || true — не прерываемся по set -e, чтобы успеть остановить эмуляторы
echo "[4/5] Запуск Marathon..."
marathon || true

# ── 5. Остановка эмуляторов ────────────────────────────
echo "[5/5] Остановка эмуляторов..."
"$ADB" -s "emulator-$PORT_1" emu kill || true
"$ADB" -s "emulator-$PORT_2" emu kill || true
wait "$PID_1" 2>/dev/null || true
wait "$PID_2" 2>/dev/null || true

echo "Готово. Результаты в папке marathon/"