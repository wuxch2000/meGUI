# for xml process

TARGET = ipod.nano.profile iphone.profile
XSL_FILE = profile.xsl

XSLT_JAR = xslt.jar
SAXON_JAR = "E:/Program Files/saxon/jar/saxon9he.jar"
JAVA_CMD = java -jar $(SAXON_JAR)
DEL = rm
MAKE = make

%.profile : %.xml $(XSL_FILE)
	@echo building $@ by $?...
	$(JAVA_CMD)  -s:$< -xsl:$(XSL_FILE) -o:$@

%.html : %.xml $(XSL_FILE)
	@echo building $@ by $?...
	$(JAVA_CMD)  -s:$< -xsl:$(XSL_FILE) -o:$@

.PHONY : rm profile

profile:
	for t in $(TARGET); do \
	$(MAKE) $$t; \
	done

rm:
	$(DEL) $(TARGET)
