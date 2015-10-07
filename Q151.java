package leetcode;

public class Q151 {
//    public String reverseWords(String s) {
//    	String watcher = " *1s ";
//    	String temp = (watcher + s.trim());
//    	int spaceNum = 1;
//    	while(true){
//	    	int s_end = temp.lastIndexOf(" ");
//	    	int s_start = temp.substring(0, s_end).trim().length()+spaceNum;
//	    	String word_start = temp.substring(s_start);
//	    	String word_end = temp.substring(0, s_start);
//	    	temp = word_start+word_end;
//	    	spaceNum = s_end - s_start;
//	    	if(word_start.equals(watcher)){
//	    		break;
//	    	}
//    	}
//        return temp.trim();
//    }
	
	public String reverseWords(String s) {
	       String[] words = s.split(" ");
	    	
	    	String temp = "";
	    	for(int i = words.length-1;i>=0;i--){
	    		if("".equals(words[i]))
	    			continue;
	    		temp += words[i]+" ";
	    	}
	        return temp.trim(); 
	    }
    
    public static void main(String[] args) {
		Q151 test = new Q151();
		String s = "    a    b  ";
		System.out.println(test.reverseWords(s));
	}
}
