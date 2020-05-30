import java.util.*;

class Sudoku {
    int[][] data;
    Stack<int[][]> stack;
    
    Sudoku (String definition) throws Exception {
        // guard definition length
        if (definition.length() != 9*9) throw new Exception("Invalid definition length");
        
        stack = new Stack<int[][]>();
        data = new int[9][9];
        
        for (int i=0 ; i<9*9 ; i++) {
            char c = definition.charAt(i);
            
            // guard: character check
            if (c!='.' && !(c>'0' && c<='9')) throw new Exception("Invalid character '"+c+"' at position "+i+" of definition");
            
            data[i/9][i%9] = c=='.' ? 0 : c-'0';
        }
    }
    
    public int get (int x, int y) {
        return data[x][y];
    }
    
    public void set (int x, int y, int value) {
        data[x][y] = value;
    }
    
    public void push () {
        int[][] n = new int[9][9];
        
        for (int x=0; x<9 ; x++) {
            for (int y=0; y<9 ; y++) {
                n[y][x] = data[y][x];
            }
        }
        
        stack.push(n);
    }
    
    public boolean pop () {
        int[][] popped = stack.pop();
        
        if (popped == null) return false;
        
        data = popped;
        return true;
    }
    
    public boolean check () {
        // check zeros
        for (int y=0; y<9 ; y++) {
            for (int x=0; x<9 ; x++) {
                if (data[y][x]==0) return false;
            }
        }
        
        // check rows
        for (int y=0; y<9 ; y++) {
            for (int x=0; x<9 ; x++) {
                for (int x2=x+1 ; x2<9 ; x2++) {
                    if (data[y][x]==data[y][x2]) return false;
                }
            }
        }
        
        // check columns
        for (int x=0; x<9 ; x++) {
            for (int y=0; y<9 ; y++) {
                for (int y2=y+1 ; y2<9 ; y2++) {
                    if (data[y][x]==data[y2][x]) return false;
                }
            }
        }
        
        // check groups
        for (int x=0; x<3 ; x++) {
            for (int y=0; y<3 ; y++) {
                for (int i=0 ; i<9 ; i++) {
                    int ix = i%3;
                    int iy = i/3;
                    for (int i2=i+1 ; i2<9 ; i2++) {
                        int i2x = i2%3;
                        int i2y = i2/3;
                        if (data[y*3+iy][x*3+ix]==data[y*3+i2y][x*3+i2x]) {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
    
    public void print () {
        for (int row=0; row<9 ; row++) {
            if (row%3==0) {
                System.out.println("+-----+-----+-----+");
            }
            
            for (int col=0; col<9 ; col++) {
                System.out.print((col%3==0 ? "|" : " ")+(data[row][col]==0 ? " " : data[row][col]));
            }
            
            System.out.println("|");
        }
        
        System.out.println("+-----+-----+-----+");
    }
    
    public static void main (String[] args) throws Exception {
        String[] puzzledefs = {
            "4...3.......6..8..........1....5..9..8....6...7.2........1.27..5.3....4.9........",
            "7.8...3.....2.1...5.........4.....263...8.......1...9..9.6....4....7.5...........",
            "7.8...3.....6.1...5.........4.....263...8.......1...9..9.2....4....7.5...........",
            "3.7.4...........918........4.....7.....16.......25..........38..9....5...2.6.....",
            "5..7..6....38...........2..62.4............917............35.8.4.....1......9....",
        };
        
        for (String puzzledef : puzzledefs) {
            Sudoku s = new Sudoku(puzzledef);
            s.print();
            System.out.println(s.check());
            System.out.println("");
        }
    }
}
