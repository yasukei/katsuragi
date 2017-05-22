TARGET=st

# path
JAVA=java
ANTLR=$(JAVA) -jar /usr/local/lib/antlr-4.7-complete.jar
JAVAC=javac
GRUN=$(JAVA) org.antlr.v4.gui.TestRig

JUNIT=/usr/local/lib/junit/junit-4.12.jar:/usr/local/lib/junit/java-hamcrest-2.0.0.0.jar

# directory
PARSER_DIR=parser
MODEL_DIR=model
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

compile_model: compile_parser
	CLASSPATH="$(PARSER_DIR):$(CLASSPATH)" $(JAVAC) $(MODEL_DIR)/*.java

compile_test: compile_model
	CLASSPATH="$(JUNIT):$(MODEL_DIR):$(PARSER_DIR):$(CLASSPATH)" $(JAVAC) $(TEST_DIR)/*.java

run: compile_parser
	CLASSPATH="$(PARSER_DIR):$(CLASSPATH)" $(GRUN) $(TARGET) prog -gui -trace -input-filename $(TEST_DIR)/empty_program_with_comment.st

test: compile_test
	CLASSPATH="$(JUNIT):$(TEST_DIR):$(MODEL_DIR):$(PARSER_DIR):$(CLASSPATH)" $(JAVA) org.junit.runner.JUnitCore MyTest < $(TEST_DIR)/empty_program_with_comment.st

clean:
	rm -f \
		$(PARSER_DIR)/*.java \
		$(PARSER_DIR)/*.class \
		$(PARSER_DIR)/*.tokens \
		$(PARSER_DIR)/*.dot \
		$(PARSER_DIR)/*.png \
		$(MODEL_DIR)/*.class \
		$(TEST_DIR)/*.class

