// 解法一 13ms
public int numJewelsInStones(String J, String S) {
    Set set = new HashSet();
    int count = 0;
    for(char c : J.toCharArray()){
        set.add(c);
    }
    for(char b : S.toCharArray()){
        if(set.contains(b)){
            count++;
        }
    }
    return count;
}