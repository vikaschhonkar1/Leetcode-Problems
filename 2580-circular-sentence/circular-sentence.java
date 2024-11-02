class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] sentenceArray = sentence.split(" ");
        for(int i = 0; i < sentenceArray.length - 1; i++) {
            String first = sentenceArray[i];
            String second = sentenceArray[i + 1];

            if(first.charAt(first.length() - 1) != second.charAt(0)) {
                return false;
            }
        }
       
        String firstWord = sentenceArray[0];
        String lastWord = sentenceArray[sentenceArray.length - 1];

        if(firstWord.charAt(0) != lastWord.charAt(lastWord.length() - 1)) return false;

        return true;
    }
}