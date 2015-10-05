public class Solution {
     public int lengthOfLastWord(String s) {
        if(s==null||s.length()==0) return 0;
      
		char[] src = s.toCharArray(); // 字符串转换为字符数组
		int i=0;//遍历节点，最后个word的长度
		int j=src.length-1;
		//while(j>=0&&src[j]==' '){//检测末尾有没有空格直到不为空
	//		j--;	
	//	}
	//	while(j>=0&&src[j]!=' '){//遍历节点，遇到空格结束
	//		i++;
			
	//	}
	    if(src[j]==' '){
	       while(j>=0&&src[j]==' '){
	           j--;
	       }
	       for(;j>=0;j--){
	            if(src[j]==' '){break;}
	            
	            i++;
	        }
	       
	    }else{
	        for(;j>=0;j--){
	            if(src[j]==' '){break;}
	            
	            i++;
	        }
	    }
        return i;
      
    }
}