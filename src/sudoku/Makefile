TARGETS = \
	Puzzle.class \

all: ${TARGETS}

clean:
	touch ${TARGETS}
	rm    ${TARGETS}

mrproper: clean
	touch d~
	rm    *~


Puzzle.class: Puzzle.java
	javac Puzzle.java
	javac -d . Puzzle.java

Puzzle: Puzzle.class
	java sudoku/Puzzle

