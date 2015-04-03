# for xml process

TARGET = log.html
XSL_FILE = log.xsl

XSLT_JAR = xslt.jar
SAXON_JAR = "E:/Program Files/saxon/jar/saxon9he.jar"
JAVA_CMD = java -jar $(SAXON_JAR)
DEL = rm
MAKE = make

%.html : %.xml $(XSL_FILE)
	@echo building $@ by $?...
	$(JAVA_CMD)  -s:$< -xsl:$(XSL_FILE) -o:$@

.PHONY : rm html

html:
	for t in $(TARGET); do \
	$(MAKE) $$t; \
	done

rm:
	$(DEL) $(TARGET)
