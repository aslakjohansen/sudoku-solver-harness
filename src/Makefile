TARGETS = \
	Sudoku.class \

all: ${TARGETS}

clean:
	touch ${TARGETS}
	rm    ${TARGETS}

mrproper: clean
	touch d~
	rm    *~


Sudoku.class: Sudoku.java
	javac Sudoku.java

Sudoku: Sudoku.class
	java Sudoku

