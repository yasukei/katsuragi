TARGET=st

# binary
ANTLR=java -jar /usr/local/lib/antlr-4.7-complete.jar
JAVAC=javac
GRUN=java org.antlr.v4.gui.TestRig

# directory
PARSER_DIR=parser
TEST_DIR=test

# target
all: compile_antlr compile_java run

show: compile_antlr
	cd $(PARSER_DIR)
	dot -Tpng *.dot -O
	ristretto *.png

compile_antlr:
	$(ANTLR) $(PARSER_DIR)/$(TARGET).g4

compile_java:
	$(JAVAC) $(PARSER_DIR)/$(TARGET)*.java

run:
	CLASSPATH="$(PARSER_DIR):$(CLASSPATH)" $(GRUN) $(TARGET) prog -gui -trace -input-filename $(TEST_DIR)/empty_program_with_comment.st

test:
	# TODO

clean:
	cd $(PARSER_DIR)
	rm -f *.java *.class *.tokens *.dot *.png
