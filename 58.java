public class Solution {
     public int lengthOfLastWord(String s) {
        if(s==null||s.length()==0) return 0;
      
		char[] src = s.toCharArray(); // �ַ���ת��Ϊ�ַ�����
		int i=0;//�����ڵ㣬����word�ĳ���
		int j=src.length-1;
		//while(j>=0&&src[j]==' '){//���ĩβ��û�пո�ֱ����Ϊ��
	//		j--;	
	//	}
	//	while(j>=0&&src[j]!=' '){//�����ڵ㣬�����ո����
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