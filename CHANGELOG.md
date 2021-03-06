# Changelog
This file documents noteworthy changes to the `jfr-core` projects.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## Coming soon

* tbd

## Version 0.5.0 (2020-09-30)
* Update telemetry sdk to 0.8.0.
* Minor documentation/readme [change](https://github.com/newrelic/newrelic-jfr-core/pull/83).
* Small [change](https://github.com/newrelic/newrelic-jfr-core/pull/86) to how the JFR profile is configured.

## Version 0.4.0 (2020-09-22)

* JFR Daemon - If the agent is present, no longer wait for the agent to connect to obtain an entity guid.
Instead, buffer the data and wait to send it until the entity guid is available.
* JFR Daemon - Omit the app name from the common attributes when the entity guid is present

## Version 0.3.0 (2020-07-31)

* JFR Daemon - change main class from `JFRController` to `JFRDaemon`
* JFR Daemon - now supports fetching `entity.guid` common attribute from remote MBean
* JRR Daemon - startup delays until service startup is complete
* JFR Daemon - make determining localhost address more robust
* JFR Daemon - retry with backoff when recordings fail
* JFR Mappers - null guard against null thread in `ThreadAllocationStatistics` events
* JFR Mappers - fix stack overflow boundary case when truncating stack frames