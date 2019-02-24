public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    generateHelp(n, n, "", res);
    return res;
}

private void generateHelp(int left, int right, String subList, List<String> res){
    if(left == 0 && right == 0){
        res.add(subList);
        return;
    }
    
    if(left > 0){
        generateHelp(left - 1, right, subList + "(", res);
    }
    if(right > left){
        generateHelp(left, right - 1, subList + ")", res);
    }
}