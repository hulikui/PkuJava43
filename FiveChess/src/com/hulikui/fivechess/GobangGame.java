package com.hulikui.fivechess;

import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// 定义达到赢条件的棋子数目
	//private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的X坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;
	
	
	/**
	 * 空构造器
	 */
	public GobangGame() {
	}

	/**
	 * 构造器，初始化棋盘和棋子属性
	 * 
	 * @param chessboard
	 *            棋盘类
	 */
	public GobangGame(Chessboard chessboard) {
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
		if (board[posX][posY] != "十      ") {
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
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
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
	 * 说明：用穷举法判断每一个坐标点的四个方向的的最大棋子数
	 * 最后得出棋子数最大值的坐标，下子
	 */
	// 计算机走棋

	public int[] computerDo() {
		String[][] board = chessboard.getBoard();
		
		int max_black,max_white,max_temp,max=0;
		int width=Chessboard.BOARD_SIZE-1;
		int height=Chessboard.BOARD_SIZE-1;
		System.out.println("计算机走棋 ...");
	   for(int i = 0; i <= width; i++){
		for(int j = 0; j <= height; j++){
		 if(board[i][j] == "十      "){//算法判断是否下子
		  max_white=checkMax(i,j,Chessman.WHITE.getChessman());//判断白子的最大值
		  max_black=checkMax(i,j,Chessman.BLACK.getChessman());//判断黑子的最大值
		  max_temp=Math.max(max_white,max_black);
		  if(max_temp>max){
		   max=max_temp;
		  this.posX=i;
		  this.posY=j;
		  }
		 }
		}
	   }
		int[] result = {this.posX,this.posY};
		return result;
	}



	//计算棋盘上某一方格上八个方向棋子的最大值，
	//这八个方向分别是：左、右、上、下、左上、左下、右上、右下
	public int checkMax(int x, int y,String black_or_white){
		String[][] board = chessboard.getBoard();
	   int num=0,max_num,max_temp=0;
	   int x_temp=x,y_temp=y;
	   int x_temp1=x_temp,y_temp1=y_temp;
	   //judge right
	   for(int i=1;i<5;i++){
		x_temp1+=1;
		if(x_temp1>Chessboard.BOARD_SIZE-1)
		 break;
		if(board[x_temp1][y_temp1]==black_or_white)
		 num++;
		
		else
		 break;
	   }
	   //judge left
	   x_temp1=x_temp;
	   for(int i=1;i<5;i++){
		x_temp1-=1;
		if(x_temp1<0)
		 break;
		if(board[x_temp1][y_temp1]==black_or_white)
		 num++;
		else
		 break;
	   }
	   if(num<5)
		max_temp=num;

	   //judge up
	   x_temp1=x_temp;
	   y_temp1=y_temp;
	   num=0;
	   for(int i=1;i<5;i++){
		y_temp1-=1;
		if(y_temp1<0)
		 break;
		if(board[x_temp1][y_temp1]==black_or_white)
		 num++;
		else
		 break;
	   }
	   //judge down
	   y_temp1=y_temp;
	   for(int i=1;i<5;i++){
		y_temp1+=1;
		if(y_temp1>Chessboard.BOARD_SIZE-1)
		 break;
		if(board[x_temp1][y_temp1]==black_or_white)
		 num++;
		else
		 break;
	   }
	   if(num>max_temp&&num<5)
		max_temp=num;

	   //judge left_up
	   x_temp1=x_temp;
	   y_temp1=y_temp;
	   num=0;
	   for(int i=1;i<5;i++){
		x_temp1-=1;
		y_temp1-=1;
		if(y_temp1<0 || x_temp1<0)
		 break;
		if(board[x_temp1][y_temp1]==black_or_white)
		 num++;
		else
		 break;
	   }
	   //judge right_down
	   x_temp1=x_temp;
	   y_temp1=y_temp;
	   for(int i=1;i<5;i++){
		x_temp1+=1;
		y_temp1+=1;
		if(y_temp1>Chessboard.BOARD_SIZE-1 || x_temp1>Chessboard.BOARD_SIZE-1)
		 break;
		if(board[x_temp1][y_temp1]==black_or_white)
		 num++;
		else
		 break;
	   }
	   if(num>max_temp&&num<5)
		max_temp=num;

	   //judge right_up
	   x_temp1=x_temp;
	   y_temp1=y_temp;
	   num=0;
	   for(int i=1;i<5;i++){
		x_temp1+=1;
		y_temp1-=1;
		if(y_temp1<0 || x_temp1>Chessboard.BOARD_SIZE-1)
		 break;
		if(board[x_temp1][y_temp1]==black_or_white)
		 num++;
		else
		 break;
	   }
	   //judge left_down
	   x_temp1=x_temp;
	   y_temp1=y_temp;
	   for(int i=1;i<5;i++){
		x_temp1-=1;
		y_temp1+=1;
		if(y_temp1>Chessboard.BOARD_SIZE-1 || x_temp1<0)
		 break;
		if(board[x_temp1][y_temp1]==black_or_white)
		 num++;
		else
		 break;
	   }
	   if(num>max_temp&&num<5)
		max_temp=num;
	   max_num=max_temp;
	   return max_num;
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
		int num=1;
	  	int x_temp=posX,y_temp=posY;
	   	int x_temp1=x_temp,y_temp1=y_temp;
	   	String[][] board = chessboard.getBoard();
	   //判断右边
	   for(int i=1;i<6;i++){
		x_temp1+=1;
		if(x_temp1>Chessboard.BOARD_SIZE-1)
		 break;
		if(board[x_temp1][y_temp1]==ico)
		 num++;
		else
		 break;
	   }
	   //判断左边
	   x_temp1=x_temp;
	   for(int i=1;i<6;i++){
		x_temp1-=1;
		if(x_temp1<0)
		 break;
		if(board[x_temp1][y_temp1]==ico)
		 num++;
		else
		 break;
	   }
	   if(num==5)
		return true;

	   //判断上方
	   x_temp1=x_temp;
	   y_temp1=y_temp;
	   num=1;
	   for(int i=1;i<6;i++){
		y_temp1-=1;
		if(y_temp1<0)
		 break;
		if(board[x_temp1][y_temp1]==ico)
		 num++;
		else
		 break;
	   }
	   //判断下方
	   y_temp1=y_temp;
	   for(int i=1;i<6;i++){
		y_temp1+=1;
		if(y_temp1>Chessboard.BOARD_SIZE-1)
		 break;
		if(board[x_temp1][y_temp1]==ico)
		 num++;
		else
		 break;
	   }
	   if(num==5)
		return true;

	   //判断左上
	   x_temp1=x_temp;
	   y_temp1=y_temp;
	   num=1;
	   for(int i=1;i<6;i++){
		x_temp1-=1;
		y_temp1-=1;
		if(y_temp1<0 || x_temp1<0)
		 break;
		if(board[x_temp1][y_temp1]==ico)
		 num++;
		else
		 break;
	   }
	   //判断右下
	   x_temp1=x_temp;
	   y_temp1=y_temp;
	   for(int i=1;i<6;i++){
	   x_temp1+=1;
	   y_temp1+=1;
	   if(y_temp1>Chessboard.BOARD_SIZE-1 || x_temp1>Chessboard.BOARD_SIZE-1)
		break;
		if(board[x_temp1][y_temp1]==ico)
		 num++;
		else
		 break;
	   }
	   if(num==5)
		return true;

	   //判断右上
	   x_temp1=x_temp;
	   y_temp1=y_temp;
	   num=1;
	   for(int i=1;i<6;i++){
		x_temp1+=1;
		y_temp1-=1;
		if(y_temp1<0 || x_temp1>Chessboard.BOARD_SIZE-1)
		 break;
		if(board[x_temp1][y_temp1]==ico)
		 num++;
		else
		 break;
	   }
	   //判断左下
	   x_temp1=x_temp;
	   y_temp1=y_temp;
	   for(int i=1;i<6;i++){
		x_temp1-=1;
		y_temp1+=1;
		if(y_temp1>Chessboard.BOARD_SIZE-1 || x_temp1<0)
		 break;
		if(board[x_temp1][y_temp1]==ico)
		 num++;
		else
		 break;
	   }
	   if(num==5)
		return true;
	   return false;
	}


	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
