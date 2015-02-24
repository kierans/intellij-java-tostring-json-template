# IntelliJ toString() generator with JSON output

The template is to be used with IntelliJ's toString() functionality to output an object graph in JSON.

This can help with analysing an object graph from logs in the spirit of [structured logging](http://blog.nodejs.org/2012/03/28/service-logging-in-json-with-bunyan/)

## Limitations

Currently multi-dimensional arrays of User Defined Types (eg: SimpleObject\[\]\[\]) aren't converted to JSON.