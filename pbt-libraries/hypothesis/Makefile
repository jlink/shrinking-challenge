venv/bin/python:
	virtualenv venv

venv/installed: venv/bin/python requirements.txt
	venv/bin/pip install -r requirements.txt
	touch venv/installed

.cache:
	mkdir .cache

.PHONY: update-requirements
update-requirements: venv/installed
	venv/bin/pip freeze > requirements.txt
	
.PHONY: format
format: venv/installed
	venv/bin/black support/*.py challenges/*.py
	venv/bin/isort support/*.py challenges/*.py

%.json: %.py venv/installed requirements.txt support/run_challenge.py
	venv/bin/python support/run_challenge.py $<

%.md: %.json venv/installed support/make_report.py support/report.md
	venv/bin/python support/make_report.py $<


BENCHMARKS=$(wildcard challenges/*.py)
DATA=$(patsubst %.py,%.json,$(BENCHMARKS))
REPORTS=$(patsubst %.py,%.md,$(BENCHMARKS))

.PRECIOUS: $(DATA)

.PHONY: all
all: $(REPORTS)
