#!/bin/bash

# === CONFIGURATION ===
CHECKSTYLE_JAR="/d/Tools/checkstyle-10.26.1-all.jar"
RULESET="../config/checkstyle/checkstyle.xml"
REPORT_DIR="../reports/checkstyle"
TIMESTAMP=$(date +"%Y-%m-%d_%H-%M-%S")
REPORT_TXT="$REPORT_DIR/checkstyle-$TIMESTAMP-report.txt"

# === DISCOVER MODULES ===
SOURCE_DIRS=""
MODULE_PATHS=("../misc_utils/src/main/java" "../src/main/java")

echo "🔎 Checking available modules for Checkstyle scan..."
for path in "${MODULE_PATHS[@]}"; do
  if [ -d "$path" ]; then
    echo "🟢 Found: $path"
    [ -z "$SOURCE_DIRS" ] && SOURCE_DIRS="$path" || SOURCE_DIRS="$SOURCE_DIRS $path"
  else
    echo "⚪ Skipped (not found): $path"
  fi
done

# === VALIDATION ===
if [ ! -f "$RULESET" ]; then
  echo "❌ Checkstyle ruleset not found at: $RULESET"
  exit 1
fi

if [ -z "$SOURCE_DIRS" ]; then
  echo "❌ No valid source directories found. Aborting Checkstyle scan."
  exit 1
fi

mkdir -p "$REPORT_DIR"

# === EXECUTION ===
echo "🔍 Running Checkstyle Scan..."
java -jar "$CHECKSTYLE_JAR" \
  -c "$RULESET" \
  $SOURCE_DIRS \
  > "$REPORT_TXT"

echo "✅ Text report saved: $REPORT_TXT"
echo "🎯 Checkstyle scan complete across valid modules."