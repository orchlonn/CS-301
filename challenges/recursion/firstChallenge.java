class firstChallenge {
    public static char findUpperCase(String word){
        char c = word.charAt(0);
        
        if (Character.isUpperCase(c)) {
            return c;
        }
        word = word.substring(1);
        if (word.length() == 1) {
            return '-1';
        }
        return findUpperCase(word);
    };
    
    public static void findUpperCase(String[] args) {
        System.out.println(findUpperCase("cs301atatructures"));
    }
}