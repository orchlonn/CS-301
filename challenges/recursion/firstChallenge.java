class firstChallenge {
    public static char firstChallenge(String word){
        char c = word.charAt(0);
        
        if (Character.isUpperCase(c)) {
            return c;
        }
        word = word.substring(1);
        if (word.length() == 1) {
            return '-1';
        }
        return firstChallenge(word);
    };
    
    public static void firstChallenge(String[] args) {
        System.out.println(firstChallenge("cs301atatructures"));
    }
}