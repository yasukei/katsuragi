TARGET=st

ANTLR=java -jar /usr/local/lib/antlr-4.7-complete.jar
JAVAC=javac
GRUN=java org.antlr.v4.gui.TestRig

all: compile_antlr compile_java run

compile_antlr:
	$(ANTLR) $(TARGET).g4

compile_java:
	$(JAVAC) $(TARGET)*.java

run:
	$(GRUN) st prog -gui -trace -input-filename empty_program_with_comment.st

test:
	# TODO

clean:
	rm -f *.java *.class *.tokens
