TARGETS = \
	Puzzle.class \

all: ${TARGETS}

clean:
	touch ${TARGETS}
	rm    ${TARGETS}

mrproper: clean
	touch d~
	rm    *~
	touch sudoku
	rm -R sudoku


Puzzle.class: Puzzle.java
	javac -d . Puzzle.java

Puzzle: Puzzle.class
	java sudoku/Puzzle

