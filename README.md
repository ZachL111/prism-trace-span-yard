# prism-trace-span-yard

`prism-trace-span-yard` explores observability in Scala. The repository keeps the core rule set compact, then surrounds it with examples that show how the decisions move.

## Prism Trace Span Yard Notes

The quickest review path is the verifier first, then the fixtures, then the operations note. That order makes it easy to see whether the code, data, and explanation still agree.

## Why This Exists

This project keeps the domain idea close to the tests. That makes it useful as a reference implementation, a small experiment, or a starting point for a more specialized tool.

## Implementation Notes

The project is organized around a compact model rather than a large framework. Inputs are scored, classified, and checked against golden fixtures. The constants live in code and are mirrored in metadata so documentation drift is easy to catch. The Scala code uses case classes and a compact object API to keep the test path direct.

## Example Scenarios

`examples/extended_cases.csv` adds six named cases. I kept the names plain so failures are easy to read in a terminal: baseline, pressure, surge, degraded, recovery, and boundary.

## Feature Notes

- Uses fixture data to keep log shape changes visible in code review.
- Includes extended examples for latency summaries, including `surge` and `degraded`.
- Documents incident slices tradeoffs in `docs/operations.md`.
- Runs locally with a single verification command and no external credentials.
- Stores project constants and verification metadata in `metadata/project.json`.

## Local Setup

Use a normal shell with Scala available on `PATH`. The verifier is written as a PowerShell script because the portfolio was assembled on Windows.

## Tests

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File scripts/audit.ps1
```

The audit command checks repository structure and README constraints before it delegates to the verifier.

## Code Tour

- `src`: primary implementation
- `tests`: verification harness
- `fixtures`: compact golden scenarios
- `examples`: expanded scenario set
- `metadata`: project constants and verification metadata
- `docs`: operations and extension notes
- `scripts`: local verification and audit commands

## Boundaries

The repository favors determinism over breadth. It does not pull live data, keep secrets, or depend on network access for verification.

## Roadmap

- Add a comparison mode that shows how decisions change when one signal is adjusted.
- Add a loader for `examples/extended_cases.csv` and promote selected cases into the language test suite.
- Add a short report command that prints the score breakdown for a single scenario.
- Add one more observability fixture that focuses on a malformed or borderline input.

## Try It

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File scripts/verify.ps1
```

This runs the language-level build or test path against the compact fixture set.
