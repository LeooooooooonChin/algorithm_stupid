// 解法一 29ms
public boolean isAnagram(String s, String t) {
    // 1 字符串排序，比较字符串  效率n(logn)
    // 2 map计数
    char[] ss = s.toCharArray();
    char[] tt = t.toCharArray();
    Arrays.sort(ss);
    Arrays.sort(tt);
    s = Arrays.toString(ss);
    t = Arrays.toString(tt);
    return s.equals(t);
}
// 解法二 63ms
public boolean isAnagram(String s, String t) {
    // 1 字符串排序，比较字符串  效率n(logn)
    // 2 map计数
    Map<Character, Integer> map = new HashMap<>();
    for(char a : s.toCharArray()){
        if(map.containsKey(a)){
            map.put(a, map.get(a) + 1);
        }else{
            map.put(a, 1);
        }
    }
    for(char a: t.toCharArray()){
        if(map.containsKey(a)){
            map.put(a, map.get(a) - 1);
            if(map.get(a) <= 0){
               map.remove(a); 
            }
        }else{
            return false;
        }
    }
    
    return map.isEmpty();
}
// 解法三 5ms
public boolean isAnagram(String s, String t) {
    if(s == null || t == null){
        return false;
    }
    // 1 字符串排序，比较字符串  效率n(logn)
    // 2 map计数
    // 3 使用比较字符ascii
    int[] a = new int[256];
    int[] b = new int[256];
    for(char ss : s.toCharArray()){
        a[ss]++;
    }
    for(char ss : t.toCharArray()){
        b[ss]++;
    }
    
    for(int i = 0; i < 256; i++){
        if(a[i] != b[i]){
            return false;
        }
    }
    return true;
}

// 更简单的写法
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] table = new int[26];
    for (char c : s.toCharArray()) {
        table[c - 'a']++;
    }
    for (char c : t.toCharArray()) {
        table[c - 'a']--;
    }
    for (int cnt : table) {
        if (cnt != 0) return false;
    }
    return true;
}