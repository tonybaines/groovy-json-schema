package com.github.tonybaines

import groovy.json.JsonBuilder

abstract class JsonSchemaScript extends Script {

  String schema(String name, c) {
    def builder = new JsonBuilder()
    builder (
      '$schema': "http://json-schema.org/draft-04/schema#",
      'description': name
    )

    builder.toPrettyString()
  }

}
