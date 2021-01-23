find reports/*.json -exec python ../hypothesis/support/make_report.py {} \;

export FC_VERSION=$(node -p "require('fast-check').__version")
sed -i "s/Hypothesis .*\..*\..*/fast-check ${FC_VERSION}/g" reports/*.md
sed -i 's/Hypothesis/fast-check/g' reports/*.md