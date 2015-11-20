package com.leetcode.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContrastWord {

	public static void main(String[] args) throws URISyntaxException {
		String a = System.getProperty("user.dir")+"\\a.txt";
		String b = System.getProperty("user.dir")+"\\b.txt";
		doWork(a,b);
	}
	
	private static void doWork(String fileAPath,String fileBPath){
		List<String> totalWs = new ArrayList<String>();
		List<String> notRepeatList = new ArrayList<String>();
		List<String> repeatList = new ArrayList<String>();
		List<String> listA = readFile(fileAPath);
		List<String> listB = readFile(fileBPath);
		fillWords(totalWs, listA);
		fillWords(totalWs, listB);
		
		//求解元素的并集：
		notRepeatList =getNotRepeatWordList(totalWs);
		
		//求解元素的交集
		repeatList = getRepeatWordList(listA, listB);
		
		System.out.print("所有的词汇为：");
		for( String w : notRepeatList ){
			System.out.print(w+" ");
		}
		System.out.println();
		System.out.print("重复的词汇为：");
		for( String w : repeatList ){
			System.out.print(w+" ");
		}
		//求解元素属于A却不属于B占A的百分比，利用公式（A-(A交B)）/A的总数
		System.out.println();
		DecimalFormat df1 = new DecimalFormat("0.00%"); 
		if(listA.size()>0)
		    System.out.println("属于文本a却不属于文本b的词汇数占文本a总数的百分比为："+df1.format(new Double(listA.size()-repeatList.size())/new Double(listA.size())));
		else
			System.out.println("属于文本a却不属于文本b的词汇数占文本a总数的百分比为：text a do not have any word");
		if(listB.size()>0)
		    System.out.println("属于文本b却不属于文本a的词汇数占文本b总数的百分比为："+df1.format(new Double(listB.size()-repeatList.size())/new Double(listB.size())));
		else
			System.out.println("属于文本b却不属于文本a的词汇数占文本b总数的百分比为：text b do not have any word");
	}
	
	/**
	 * 遍历其中一个集合，将其值与另一个集合中进行比较
	 * 若匹配到，则放入集合，即为两个不同集合所共有单词的集合
	 * @param listA
	 * @param listB
	 * @return
	 */
	private static List<String> getRepeatWordList(List<String> listA,List<String> listB){
		List<String> repeatList = new ArrayList<String>();
		for( String w : listA ){
			if( listB.contains(w) ){
				repeatList.add(w);
			}
		}
		return repeatList;
	}
	
	/**
	 * 从总容器中去除重复的单词
	 * 得到总的单词量（没有重复的）
	 * @param allWs
	 * @return
	 */
	private static List<String> getNotRepeatWordList(List<String> allWs){
		Set<String> set = new HashSet<String>();
		for( String w : allWs ){
			set.add(w);
		}
		List<String> ws = new ArrayList<String>();
		ws.addAll(set);
		return ws;
	}
	/**
	 * 将读出的文本单词放到总容器中
	 * 此时总容器中可能有重复的单词
	 * @param list
	 * @param ws
	 * @return
	 */
	private static void fillWords(List<String> list , List<String>ws){
		for( String w : ws ){
			list.add(w);
		}
	}
	
	/**
	 * 去除从单文本中读出来的重复单词
	 * 即得到该文本中所有单词
	 * @param ws
	 * @return
	 */
	private static List<String> removeRepeatWord(String [] ws){
		Set<String> set = new HashSet<String>();
		for( String w : ws ){
			if( null!= w && !"".equals(w) ){
				set.add(w);
			}
		}
		List<String> list = new ArrayList<String>();
		list.addAll(set);
		return list;
	}

	private static List<String> readFile(String filePath){
		List<String> ws = new ArrayList<String>();
		File file = new File(filePath);
		String encoding = "GBK";
		FileInputStream inputStream = null;
		InputStreamReader read = null;
		BufferedReader bufferedReader = null;
		if( file.isFile() && file.exists() ){
			try{
				inputStream = new FileInputStream(file);
				read = new InputStreamReader(inputStream ,encoding);
				bufferedReader = new BufferedReader(read);
			    String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
//                    System.out.println(lineTxt);
                	ws.addAll(getSplitWordsByContent(lineTxt));
                }
			} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					try {
						bufferedReader.close();
						read.close();
						inputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}else{
				System.out.println("找不到路径为"+filePath+"的文件！！");
			}
		return ws;
	}
	
	private static List<String> getSplitWordsByContent(String con){
		List<String> list = new ArrayList<String>();
		if( null == con || "".equals(con) ){
			return list;
		}
		for( String w : con.split(" ") ){
			list.add(w);
		}
		return list;
	}
}
