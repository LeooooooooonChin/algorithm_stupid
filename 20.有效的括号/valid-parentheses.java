// 解法一 12ms
public boolean isValid(String s) {
    if(s == null || "".equals(s)){
        return true;
    }
    Map<Character,Character> map = new HashMap<>();
    map.put(')','(');
    map.put('}','{');
    map.put(']','[');
    Stack<Character> stack = new Stack<Character>();
    for(int i = 0; i < s.length(); i++){
        char loopEl = s.charAt(i);
        if(map.containsKey(loopEl)){
            char topElement = stack.empty() ? '-' : stack.pop();
            if(topElement != map.get(loopEl)){
                return false;
            }
        }else{
            stack.push(loopEl);
        }
    }
    return stack.isEmpty();
}