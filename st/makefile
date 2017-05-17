TARGET=st

ANTLR=java -jar /usr/local/lib/antlr-4.7-complete.jar
JAVAC=javac
GRUN=java org.antlr.v4.gui.TestRig

all:
	$(ANTLR) $(TARGET).g4
	$(JAVAC) $(TARGET)*.java
	$(GRUN) $(TARGET) prog -gui

	#$(GRUN) st prog -gui -trace -diagnostics -input-filename empty_program.st

clean:
	rm -f *.java *.class *.tokens
