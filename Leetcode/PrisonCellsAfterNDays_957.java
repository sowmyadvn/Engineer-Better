class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
		if(cells==null || cells.length==0 || N<=0) return cells;
        boolean hasCycle = false;
        int cycle = 0;
        HashSet<String> set = new HashSet<>(); 
        for(int i=0;i<N;i++){
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);
            if(!set.contains(key)){ //store cell state
                set.add(key);
                cycle++;
            }
            else{ //hit a cycle
                hasCycle = true;
                break;
            }
            cells = next;
        }
        if(hasCycle){
            N%=cycle;
            for(int i=0;i<N;i++){
                cells = nextDay(cells);
            }   
        }
        return cells;
    }
    
    private int[] nextDay(int[] cells){
        int[] tmp = new int[cells.length];
        for(int i=1;i<cells.length-1;i++){
            tmp[i]=cells[i-1]==cells[i+1]?1:0;
        }
        return tmp;
    }
}

/*
Eight houses, represented as cells, are arranged in a straight line. Each day every cell competes with its adjacent cells (neighbors). An integer value 1 represents an active cell and a value of 0 represents an inactive cell. If the neighbors on both the sides of a cell are either active or inactive, the cell becomes inactive on the next day; otherwise the cell becomes active. The two cells on each end have a single adjacent cell, so assume that the unoccupied space on the opposite side is an inactive cell. Even after updating the cell state, consider its previous state when updating the state of other cells. The state information of all cells should be updated simultaneously.
Write an algorithm to output the state of the cells after the given number of days.

Input
The input to the function/method consists of two arguments:
states, a list of integers representing the current state of cells;
days, an integer representing the number of days.

Output
Return a list of integers representing the state of the cells after the given number of days.

Examples 1
Input:
[1, 0, 0, 0, 0, 1, 0, 0], 1

Output:
0 1 0 0 1 0 1 0

Examples 2
Input:
[1, 1, 1, 0, 1, 1, 1, 1], 2

Output:
0 0 0 0 0 1 1 0

*/