# prism-trace-span-yard

`prism-trace-span-yard` explores observability with a small Scala codebase and local fixtures. The technical goal is to package a Scala local lab for span analysis with windowed input fixtures, late-data behavior checks, and documented operating limits.

## Problem It Tries To Make Smaller

I want this repository to be useful as a quick reading exercise: fixtures first, implementation second, verifier last.

## Prism Trace Span Yard Review Notes

Start with `span volume` and `latency skew`. Those cases create the widest score spread in this repo, so they are the best quick check when the model changes.

## Working Pieces

- `fixtures/domain_review.csv` adds cases for span volume and latency skew.
- `metadata/domain-review.json` records the same cases in structured form.
- `config/review-profile.json` captures the read order and the two review questions.
- `examples/prism-trace-span-walkthrough.md` walks through the case spread.
- The Scala code includes a review path for `span volume` and `latency skew`.
- `docs/field-notes.md` explains the strongest and weakest cases.

## Design Notes

The fixture data drives the tests. The code stays thin, while `metadata/domain-review.json` and `config/review-profile.json` explain what each case is meant to protect.

The Scala implementation avoids hidden state so fixture changes are easy to reason about.

## Example Run

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File scripts/verify.ps1
```

## Tests

The same command runs the local verification path. The highest-scoring domain case is `stale` at 218, which lands in `ship`. The most cautious case is `stress` at 121, which lands in `watch`.

## Known Limits

This remains a local project with deterministic fixtures. It does not depend on credentials, hosted services, or live data. Future work should add richer malformed inputs before widening the public API.
