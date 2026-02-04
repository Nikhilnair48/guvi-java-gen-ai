# Lecture 15 - Mini Projects Using Collections, Lambdas, and Files
Roadmap Day: TBD

Goal: Apply collections and lambdas in small real-world style mini programs with sample datasets.

## Materials
- Live coding project: [lecture-15](./live-coding/lecture-15/)
- Reference project (same structure): [lecture/lecture-15](./lecture/lecture-15/)

## What we covered
- Building a map from alias to SKU and using sets for unique aggregation
- Comparing two sets to find new and discontinued items
- Detecting data quality issues (unknown aliases and alias conflicts)
- Writing sorting policies using a lambda Comparator
- Writing custom functional interfaces and passing behavior as lambdas

## Live coding
Location: [live-coding/lecture-15](./live-coding/lecture-15/)

Start here
- Catalog aggregation mini project: [CatalogAggregator.java](./live-coding/lecture-15/src/main/java/com/guvi/collections/CatalogAggregator.java)
- Comparator policy sorting: [FileNameSorter.java](./live-coding/lecture-15/src/main/java/com/guvi/lambda/FileNameSorter.java)
- Custom functional interface: [ScoreCombiner.java](./live-coding/lecture-15/src/main/java/com/guvi/lambda/ScoreCombiner.java)

What to notice
- Sample data used by the catalog program:
  - [catalog_sample](./live-coding/lecture-15/src/main/resources/catalog_sample/)
- Extra datasets in resources (for later use):
  - [ticket-triage/tickets.csv](./live-coding/lecture-15/src/main/resources/ticket-triage/tickets.csv)
  - [warehouse](./live-coding/lecture-15/src/main/resources/warehouse/)
- Localization bundles used by examples:
  - [Messages.properties](./live-coding/lecture-15/src/main/resources/Messages.properties)
  - [StatusTexts.properties](./live-coding/lecture-15/src/main/resources/StatusTexts.properties)
