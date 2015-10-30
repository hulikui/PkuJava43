package com.leetcode.homework.wuziqi;
import java.io.BufferedReader;
import java.io.InputStreamReader;

 //α-β剪枝博弈树
public class GobangGame {
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
	 * 3.暂时没有写出博弈树，之后将进行改进
	 * **/
	public  int computerDoWithAI(int depth,String chessman,int posX,int posY) {
		int curValue;
		//下了该子就赢了的情况下，应当赋予更多的值
		if(depth == 0){
			return inLineNums(Chessman.WHITE.getChessman()) - inLineNums(Chessman.BLACK.getChessman());
		} 
		
		//进行各个分支的递归计算
		for(int i = 0;i<Chessboard.BOARD_SIZE - 1;i++){
			for(int j = 0;j<Chessboard.BOARD_SIZE - 1;j++){
	             if(chessboard.getBoard()[i][j] == "十"){
	            	 chessboard.setBoard(i,j,chessman);
	             }	
	             String opsChessman = chessman == Chessman.WHITE.getChessman()?Chessman.BLACK.getChessman():Chessman.WHITE.getChessman();
	             curValue = computerDoWithAI(depth--,opsChessman,i,j);
	             chessboard.setBoard(posX,posY,"十");
				 return inLineNums(Chessman.WHITE.getChessman()) - inLineNums(Chessman.BLACK.getChessman())+curValue;
			}
		}
		return 0;
	}
	
	private int inLineNums(String ico) {
	  //遍历整个棋盘找出成5子的个数
	  //每次遍历时不能经过已经遍历的位置
		//每次遍历均找到以该点为起点的成5子的个数
		String[][] board = chessboard.getBoard();
		int nums = 0;
		for(int i = 0;i<Chessboard.BOARD_SIZE - 1;i++){
			for(int j = 0;j<Chessboard.BOARD_SIZE - 1;j++){
				if(board[i][j].equalsIgnoreCase("十")||board[i][j].equalsIgnoreCase(ico)){
					nums+=numsEqualFiveWithAI(i,j,ico,1,0);
					nums+=numsEqualFiveWithAI(i,j,ico,1,1);
					nums+=numsEqualFiveWithAI(i,j,ico,0,1);
					nums+=numsEqualFiveWithAI(i,j,ico,-1,1);
				}
			}
		}
		return nums;
	}
	
	private int numsEqualFiveWithAI(int posX,int posY,String icon,int Xplus,int Yplus){
		int nums = 0;
		int i_p = posX+Xplus;
		int j_p = posY+Yplus;
		while(i_p<Chessboard.BOARD_SIZE&&j_p<Chessboard.BOARD_SIZE&&(chessboard.getBoard()[i_p][j_p].equals(icon)||chessboard.getBoard()[i_p][j_p].equals("十"))){
			nums++;
			i_p+=Xplus;
			j_p+=Yplus;
		}
		
		return nums;
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
		return (numsEqualFive(posX,posY,ico,0,1)||numsEqualFive(posX,posY,ico,1,1)||numsEqualFive(posX,posY,ico,1,0)||numsEqualFive(posX,posY,ico,1,-1));
	}
	
	private boolean numsEqualFive(int posX,int posY,String icon,int Xplus,int Yplus){
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
		
		return positiveNums+negativeNums>WIN_COUNT-2;
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
