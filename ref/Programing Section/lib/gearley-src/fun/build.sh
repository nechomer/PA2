( cd .. ;
  groovyc `find fun -name '*.groovy'` &&
  jar cf fun/gearley.jar `find fun -name '*.class'` `find fun -name '*.groovy'` )
find . -name "*.class" -exec rm {} \;
