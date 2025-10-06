# Scrabble Word Merger

A tiny Java 25 single-file script that merges the **CSW** (British) and **NSW** (North American) Scrabble word lists into one unified text file: clean uppercase words only, no definitions, no duplicates.

## Features

- Uses the new `void main()` simplified Java syntax.
- Extracts only the headword from each line (`^[A-Z]+`).
- Removes duplicates automatically.
- Ignores comment and definition lines.

## Usage

```bash
java MergeLists.java
```
