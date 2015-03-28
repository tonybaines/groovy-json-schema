package com.github.tonybaines

import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.ImportCustomizer
import spock.lang.Specification

class JsonSchemaScriptSpec extends Specification {
  def "A simple schema"() {
    when: "the DSL is evaluated"
    def config = new CompilerConfiguration()
    config.scriptBaseClass = JsonSchemaScript.name
    def generatedSchema = new GroovyShell(config).evaluate(schemaDsl)

    then: "the JSON schema looks like"
    generatedSchema == expectedSchema

    where:
    schemaDsl= '''
schema('Example Schema') {
}
'''
    expectedSchema = '''{
    "$schema": "http://json-schema.org/draft-04/schema#",
    "description": "Example Schema"
}'''
  }
}
