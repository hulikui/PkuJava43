package com.leetcode.homework;

import java.util.ArrayList;
import java.util.List;

public class Q15_final {
	//采用十字链表的数据结构，以个位数作为数组的编号和值
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		Node[] array = new Node[20];//存在正零和负零
		manageDataConstruct(nums, array,result);//去除重复，完成数据结构的构造
		for(int i=0;i<10;i++){//在对比的过程中尽量剪枝
			if(array[i]==null)
				continue;
		    Node head = array[i];
		    Node nextNode = head.next;
		    while(nextNode!=null){
		    	int firstElement = nextNode.value;
		    	
		    	for(int j = i;j<array.length;j++){
		    		if(array[j]==null){
		    			continue;
		    		}
		    		Node nextEle = null;
		    		if(j==i){
		    			nextEle = nextNode.next;
		    		}else{
		    			nextEle = array[j].next;
		    		}
		    		
		    		while(nextEle!=null){
		    			int index =( -(firstElement+nextEle.value))%10+10;
		    			Node lastEleValue = array[index];
		    			if(lastEleValue==null){
		    				break;
		    	        }else{
		    	        	Node lastElement = lastEleValue.next;
		    				while(lastElement!=null){
		    					if(lastElement.value<0)
		    						break;
		    					if(lastElement.value>=nextEle.value&&firstElement+nextEle.value + lastElement.value == 0&&lastElement!=nextEle){
		    						ArrayList<Integer> list = new ArrayList<Integer>();
		    						if(firstElement>nextEle.value){
		    							list.add(nextEle.value);
		    							list.add(firstElement);
		    							list.add(lastElement.value);
		    						}else{
		    							list.add(firstElement);
		    							list.add(nextEle.value);
		    							list.add(lastElement.value);
		    						}
		    						
		    						
		    						
		    						result.add(list);
		    						break;
		    					}
		    					lastElement = lastElement.next;	
		    				}
		    			}
		    			if(nextEle.next!=null&&nextEle.value!=nextEle.next.value){
		    			   nextEle = nextEle.next;
		    			}else if(nextEle.next == null){
		    				nextEle = nextEle.next;
		    			}else {
		    				nextEle = nextEle.next.next;
		    			}
		    		}
		    	}
		    	if(nextNode.next!=null&&nextNode.value!=nextNode.next.value){
		    	   nextNode = nextNode.next;
		    	}else if(nextNode.next==null){
		    		nextNode = nextNode.next;
		    	}else{
		    		nextNode = nextNode.next.next;
		    	}
		    }
		}
		
		return result;
	}

	private void manageDataConstruct(int[] nums, Node[] array,List<List<Integer>> result) {
		int zeroNum = 0;
		for(int num:nums){
			Node head =null;
			int index = (num+9<0&&num%10==0)?0:num%10+10;
			if(array[index]==null){
				Node nod = new Node();
				array[index]=nod;
				head = nod;
			}else{
				head = array[index];
			}
			Node preNode = head;
			Node comNode = head.next;
			
			boolean isConcat = true;
			boolean isExist = false;
			
			while(comNode!=null){
				if(comNode.value>num){
					Node node = new Node(comNode,num);
					preNode.next = node;
					node.next = comNode;
					isConcat = false;
					break;
				}
				
				if(comNode.value==num&&isExist){
					if(num==0)
					    zeroNum=3;
					isConcat = false;
					break;
				}else if(comNode.value==num){
					isExist = true;
				}
				preNode = comNode;
				comNode = comNode.next;
			}
			if(isConcat)  
				preNode.next = new Node(null,num);
		}
		
		if(zeroNum==3){
			List<Integer> list = new ArrayList<Integer>();
			list.add(0);
			list.add(0);
			list.add(0);
			result.add(list);
		}
	}
	
	
	public static void main(String[] args) {
		Q15_final q = new Q15_final();
		int[] nums = {-13,5,13,12,-2,-11,-1,12,-3,0,-3,-7,-7,-5,-3,-15,-2,14,14,13,6,-11,-11,5,-15,-14,5,-5,-2,0,3,-8,-10,-7,11,-5,-10,-5,-7,-6,2,5,3,2,7,7,3,-10,-2,2,-12,-11,-1,14,10,-9,-15,-8,-7,-9,7,3,-2,5,11,-13,-15,8,-3,-7,-12,7,5,-2,-6,-3,-10,4,2,-5,14,-3,-1,-10,-3,-14,-4,-3,-7,-4,3,8,14,9,-2,10,11,-10,-4,-15,-9,-1,-1,3,4,1,8,1};
		List<List<Integer>> result = q.threeSum(nums);
		for(List<Integer> list:result){
			System.out.print("{");
			for(int inte:list){
				System.out.print(inte+",");
			}
			System.out.println("}");
		}
	}
}

class Node{
	Node next;
	int value;
	public Node(Node next,int value){
		this.next = next;
		this.value = value;
	}
	 
	public Node(){}
}
