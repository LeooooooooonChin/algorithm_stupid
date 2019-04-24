public static List<List<String>> solveNQueens(int n) {
    List<List<String>> list = new ArrayList<>();

    helper(0, new boolean[n], new boolean[2*n], new boolean[2*n], new String[n], list);
    return list;
}

private static void helper(int deep, boolean[] cols, boolean[] d1, boolean[] d2, String[] board, List<List<String>> res){
    if(deep == board.length){
        res.add(Arrays.asList(board.clone()));
    }else{
        for(int c = 0; c < board.length; c++){
            int id1 = deep - c + board.length;
            int id2 = 2*board.length - deep - c - 1;
            if(!cols[c] && !d1[id1] && !d2[id2]){
                char[] row = new char[board.length];
                Arrays.fill(row, '.');
                row[c] = 'Q';
                board[deep] = new String(row);
                cols[c] = true; d1[id1] = true; d2[id2] = true;
                helper(deep + 1, cols, d1, d2, board, res);
                cols[c] = false; d1[id1] = false; d2[id2] = false;
            }
        }
    }
}