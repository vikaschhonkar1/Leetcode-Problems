class Solution {
    public String reverseVowels(String s) {
        int n = s.length();

        int vowelCount = 0;
        ArrayList<Character> vowels = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || 
                    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                vowelCount++;
                vowels.add(ch);
            }
        }

        for(int i = 0; i < vowelCount / 2; i++) {
            char temp = vowels.get(i);
            vowels.set(i, vowels.get(vowelCount - i - 1));
            vowels.set(vowelCount - i - 1, temp);
        }

        String ans = "";

        int idx = 0;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || 
                    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                ans += vowels.get(0);
                vowels.remove(0);
            } else {
                ans += ch;
            }
        }

        return ans;
    }
}