# Prism Trace Span Yard Walkthrough

The fixture is intentionally compact, so the review starts with the cases that pull farthest apart.

| Case | Focus | Score | Lane |
| --- | --- | ---: | --- |
| baseline | span volume | 184 | ship |
| stress | latency skew | 121 | watch |
| edge | signal loss | 165 | ship |
| recovery | incident shape | 149 | ship |
| stale | span volume | 218 | ship |

Start with `stale` and `stress`. They create the widest contrast in this repository's fixture set, which makes them better review anchors than the middle cases.

If `stress` becomes less cautious without a clear reason, I would inspect the drag input first.
