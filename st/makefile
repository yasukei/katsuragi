TARGET=st

# binary
JAVA=java
ANTLR=$(JAVA) -jar /usr/local/lib/antlr-4.7-complete.jar
JAVAC=javac
GRUN=$(JAVA) org.antlr.v4.gui.TestRig

# directory
PARSER_DIR=parser
TEST_DIR=test

# target
all: run

show: compile_grammar
	cd $(PARSER_DIR)
	dot -Tpng *.dot -O
	ristretto *.png

compile_grammar:
	$(ANTLR) $(PARSER_DIR)/$(TARGET).g4

compile_parser: compile_grammar
	$(JAVAC) $(PARSER_DIR)/$(TARGET)*.java

run: compile_parser
	CLASSPATH="$(PARSER_DIR):$(CLASSPATH)" $(GRUN) $(TARGET) prog -gui -trace -input-filename $(TEST_DIR)/empty_program_with_comment.st

test: compile_parser
	CLASSPATH="$(PARSER_DIR):$(CLASSPATH)" $(JAVAC) $(TEST_DIR)/*.java
	CLASSPATH="$(PARSER_DIR):$(TEST_DIR):$(CLASSPATH)" $(JAVA) Test < $(TEST_DIR)/empty_program_with_comment.st

clean:
	cd $(PARSER_DIR)
	rm -f *.java *.class *.tokens *.dot *.png
