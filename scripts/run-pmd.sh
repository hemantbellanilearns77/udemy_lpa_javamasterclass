#!/bin/bash

# === CONFIGURATION ===
PMD_BIN="/d/Tools/pmd-dist-7.15.0-bin/pmd-bin-7.15.0/bin/pmd"
RULESET="../config/pmd/pmd-ruleset.xml"
REPORT_DIR="../reports/pmd"
TIMESTAMP=$(date +"%Y-%m-%d_%H-%M-%S")
REPORT_TXT="$REPORT_DIR/pmd-$TIMESTAMP-report.txt"
REPORT_XML="$REPORT_DIR/pmd-$TIMESTAMP-report.xml"

# === DISCOVER MODULES ===
SOURCE_DIRS=""
# MODULE_PATHS=("misc_utils/src/main/java" "../src/main/java")
MODULE_PATHS=("../misc_utils/src/main/java" "../src/main/java")

echo "🔎 Checking available modules for PMD scan..."
for path in "${MODULE_PATHS[@]}"; do
  if [ -d "$path" ]; then
    echo "🟢 Found: $path"
    [ -z "$SOURCE_DIRS" ] && SOURCE_DIRS="$path" || SOURCE_DIRS="$SOURCE_DIRS,$path"
  else
    echo "⚪ Skipped (not found): $path"
  fi
done

# === VALIDATION ===
if [ ! -f "$RULESET" ]; then
  echo "❌ PMD ruleset not found at: $RULESET"
  exit 1
fi

if [ -z "$SOURCE_DIRS" ]; then
  echo "❌ No valid source directories found. Aborting PMD scan."
  exit 1
fi

mkdir -p "$REPORT_DIR"

# === EXECUTION ===
echo "🔍 Running PMD Text Scan..."
"$PMD_BIN" check \
  -d "$SOURCE_DIRS" \
  -R "$RULESET" \
  --no-progress \
  -f text \
  -r "$REPORT_TXT"
echo "✅ Text report saved: $REPORT_TXT"

echo "📄 Generating PMD XML Report..."
"$PMD_BIN" check \
  -d "$SOURCE_DIRS" \
  -R "$RULESET" \
  --no-progress \
  -f xml \
  -r "$REPORT_XML"
echo "📦 XML report saved: $REPORT_XML"

echo "🎯 PMD scan complete across valid modules."