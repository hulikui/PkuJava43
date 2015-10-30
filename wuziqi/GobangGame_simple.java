package com.leetcode.homework.wuziqi;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

 //α-β剪枝博弈树
public class GobangGame_simple {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的X坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;

	/**
	 * 空构造器
	 */
	public GobangGame_simple() {
	}

	/**
	 * 构造器，初始化棋盘和棋子属性
	 * 
	 * @param chessboard
	 *            棋盘类
	 */
	public GobangGame_simple(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * 检查输入是否合法。
	 * 
	 * @param inputStr
	 *            由控制台输入的字符串。
	 * @return 字符串合法返回true,反则返回false。
	 */
	public boolean isValid(String inputStr) {
		// 将用户输入的字符串以逗号(,)作为分隔，分隔成两个字符串
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字,数字)的格式输入：");
			return false;
		}
		// 检查输入数值是否在范围之内
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE
					+ ",请重新输入：");
			return false;
		}
		// 检查输入的位置是否已经有棋子
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "十") {
			chessboard.printBoard();
			System.out.println("此位置已经有棋子，请重新输入：");
			return false;
		}
		return true;
	}

	/**
	 * 开始下棋
	 */
	public void start() throws Exception {
		// true为游戏结束
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// 获取键盘的输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取到
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// 如果不合法，要求重新输入，再继续
				continue;
			}
			// 把对应的数组元素赋为"●"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// 判断用户是否赢了
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// 计算机随机选择位置坐标
				//int[] computerPosArr = computerDo();
				
				chessman = Chessman.WHITE.getChessman();
				int[] computerPosArr = computerDoWithAI(chessman);
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// 判断计算机是否赢了
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// 如果产生胜者，询问用户是否继续游戏
			if (isOver) {
				// 如果继续，重新初始化棋盘，继续游戏
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// 如果不继续，退出程序
				break;
			}
			chessboard.printBoard();
			System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
		}
	}

	/**
	 * 是否重新开始下棋。
	 * 
	 * @param chessman
	 *            "●"为用户，"○"为计算机。
	 * @return 开始返回true，反则返回false。
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了，"
				: "很遗憾，您输了，";
		System.out.println(message + "再下一局？(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// 开始新一局
			return true;
		}
		return false;

	}

	/**
	 * 计算机随机下棋
	 */
	public int[] computerDo() {
		
		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "十") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		int[] result = { posX, posY };
		return result;
	}
	
	/**
	 * 计算机AI下棋
	 * 
	 * 1.先不考虑下了该子就赢了的情况
	 * 2.先不考虑剪枝的情况
	 * 3.暂时没有写出博弈树，之后将进行改进，目前为一层遍历改进
	 * **/
	public  int[] computerDoWithAI(String chessman) {
		int[] result = new int[2];
		int curValue = 0;
		//下了该子就赢了的情况下，应当赋予更多的值:4分
		
		//对方下了该子后既可以赢或者成4子无法堵住的情况，赋予次之的值3分
		
		//下了该子后下一步将会赢（即4子成组且两头无人堵），赋予再次之的值2分
		
		//寻找最有力的最可能成五子的下棋点1分
		
		for(int i = 0;i<Chessboard.BOARD_SIZE - 1;i++){
			for(int j=0;j<Chessboard.BOARD_SIZE - 1;j++){
	             if(chessboard.getBoard()[i][j] != "十")
	            	 break;
	            
	             String opsChessman = chessman == Chessman.WHITE.getChessman()?Chessman.BLACK.getChessman():Chessman.WHITE.getChessman();
	             
	             //计算下完该点后的连成的最长长度
	             int[] array = findMostLength(i,j,chessman);
	            	
	             //计算各种情况的得分
	             if(array[3]==5){
	            	 result[0]=array[0];
	            	 result[1]=array[1];
	            	 curValue = 7;
	            	 break;
	             }else if(array[3]==4&&array[3]<Chessboard.BOARD_SIZE&&array[4]<Chessboard.BOARD_SIZE&&chessboard.getBoard()[array[3]][array[4]].equals("十")&&array[5]<Chessboard.BOARD_SIZE&&array[6]<Chessboard.BOARD_SIZE&&chessboard.getBoard()[array[5]][array[6]].equals("十")){
	            	 if(5>curValue){
	            		 result[0]=array[0];
		            	 result[1]=array[1];
		            	 curValue = 5;
	            	 }
	             }else if(array[3]==3&&array[3]<Chessboard.BOARD_SIZE&&array[4]<Chessboard.BOARD_SIZE&&chessboard.getBoard()[array[3]][array[4]].equals("十")&&array[5]<Chessboard.BOARD_SIZE&&array[6]<Chessboard.BOARD_SIZE&&chessboard.getBoard()[array[5]][array[6]].equals("十")){
	            	 if(4>curValue){
	            		 result[0]=array[0];
		            	 result[1]=array[1];
		            	 curValue = 4;
	            	 }
	             }else {
	            	 if(array[3]>curValue){
	            		 result[0]=array[0];
		            	 result[1]=array[1];
		            	 curValue = array[3];
	            	 }
	             }
			}
			
			if(curValue==7)
				break;
		}
		//无最利条件随机下棋
		if(curValue==0){
			result =computerDo();
		}
		return result;
	}
	
	private int[] findMostLength(int posX,int posY,String icon){
		ArrayList<String> array = new ArrayList<String>();
		array.add("1_0");
		array.add("0_1");
		array.add("1_1");
		array.add("1_-1");
		int curValue = 0;
		int[] result = new int[3];
		for(String nums:array){
			String[] temp = nums.split("_");
			int Xplus = new Integer(temp[0]);
			int Yplus = new Integer(temp[1]);
			int positiveNums = 0;
			int negativeNums = 0;
			int i_p = posX+Xplus;
			int j_p = posY+Yplus;
			while(i_p<Chessboard.BOARD_SIZE&&j_p<Chessboard.BOARD_SIZE&&chessboard.getBoard()[i_p][j_p].equals(icon)){
				positiveNums++;
				i_p+=Xplus;
				j_p+=Yplus;
			}
			
			int i_n = posX-Xplus;
			int j_n = posX-Yplus;
			while(i_n<Chessboard.BOARD_SIZE&&j_n<Chessboard.BOARD_SIZE&&chessboard.getBoard()[i_n][j_n].equals(icon)){
				negativeNums++;
				i_n-=Xplus;
				j_n-=Yplus;
			}
			
			int sum = positiveNums+negativeNums;
			if(sum>curValue){
				curValue = sum;
				result[0]=Xplus;
				result[1]=Yplus;
				result[2]=sum;
				result[3]=i_p;
				result[4]=j_p;
				result[5]=i_n;
				result[6]=j_n;
			}
		}
		return result;
	}

	/**
	 * 判断输赢
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
	 */
	public boolean isWon(int posX, int posY, String ico) {
		//总共有三个方向：横着/竖着/斜着(均从第一象限的角度来看)
		int[] result = findMostLength(posX,posY,ico);
		return result[2]==5;
	}

	public static void main(String[] args) throws Exception {
		GobangGame_simple gb = new GobangGame_simple(new Chessboard());
		gb.start();
	}
}
