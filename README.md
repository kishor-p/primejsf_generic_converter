# primejsf_generic_converter
This generic POJO converter populates any selection component[`h:selectOneMenu`, `p:selectOneMenu`, `h:selectOneListbox` ...] with POJOs.

Usually it is required to write a individual converter for each component whenever there is a intension using Complex Java POJOs for selection components using `f:selectItems`. Which leads to littring the application with buch of converters attached to many components.

So this converter is written to remove that overhead. Using this technique we can write one Generic Converter for one type of POJO which can be used for all the Selection Components which makes use of same POJO, rathere than writing same POJO converter each component.

###Building from sources
```
git clone https://github.com/kishor-p/primejsf_generic_converter.git
cd primejsf_helloworld
mvn clean                  -- clean temp files from target folder
mvn package                -- create war file (under target directory)
mvn jetty:run              -- run showcase project locally
```

###Live Demo
You can see the Live Demo of this application at following link:          

http://jumpintojsf-thegrid.rhcloud.com/
