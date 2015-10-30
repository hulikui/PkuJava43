import java.io.BufferedReader;
import java.io.InputStreamReader;

 
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
		
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字,数字)的格式输入：");
			return false;
		}
	
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE
					+ ",请重新输入：");
			return false;
		}
	
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
		
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				
				continue;
			}
			
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			
			if (isWon(posX, posY, chessman)) {
				isOver = true;
			}
			else {
				
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			
			if (isOver) {
				
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				
				break;
			}
			chessboard.printBoard();
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
		boolean result=false;
		int count=0;
	
		for (int i=0;i<4;i++)
		{
			count=getWIN_COUNT(posX,posY,ico,i);
			if(count>=5){
				result=true;
				break;
			}
		}
		return result;
	}

	int getWIN_COUNT(int posX,int posY,String ico,int direction){
		String[][] board = chessboard.getBoard();
		int[] upright={posX,posY};
		int[] leftdown={posX,posY};
		int count=1;	switch (direction){
			case 0:
				while (upright[1]+1<Chessboard.BOARD_SIZE && board[upright[0]][upright[1]+1]==ico)
					upright[1]+=1;				
				while (leftdown[1]-1>=0 && board[leftdown[0]][leftdown[1]-1]==ico)
					leftdown[1]-=1;			
				count= upright[1]-leftdown[1]+1;
				System.out.println("count0="+count);
				break;
			case 1:
				while (upright[0]-1>=0 && upright[1]+1<Chessboard.BOARD_SIZE && board[upright[0]-1][upright[1]+1]==ico){
					upright[0]-=1;
					upright[1]+=1;
				}				
				while (leftdown[0]+1<Chessboard.BOARD_SIZE && leftdown[1]-1>=0 &&board[leftdown[0]+1][leftdown[1]-1]==ico){
					leftdown[0]+=1;
					leftdown[1]-=1;
				}
				count=upright[1]-leftdown[1]+1;
				System.out.println("count1="+count);
				break;
			case 2:				
				while (upright[0]-1>=0 && board[upright[0]-1][upright[1]]==ico){
					upright[0]-=1;
				}
				while (leftdown[0]+1<Chessboard.BOARD_SIZE && board[leftdown[0]+1][leftdown[1]]==ico){
					leftdown[0]+=1;
				}
				count=leftdown[0]-upright[0]+1;
				System.out.println("count2="+count);
				break;

			case 3:				
				while (upright[0]-1>=0 && upright[1]-1>=0 && board[upright[0]-1][upright[1]-1]==ico){
					upright[0]-=1;
					upright[1]-=1;
				}				
				while (leftdown[0]+1<Chessboard.BOARD_SIZE && leftdown[1]+1<Chessboard.BOARD_SIZE && board[leftdown[0]+1][leftdown[1]+1]==ico){
					leftdown[0]+=1;
					leftdown[1]+=1;
				}				
				count=leftdown[0]-upright[0]+1;
				System.out.println("count3="+count);
				break;
			default:
				break;
		}
		return count;
	}

	public static void main(String[] args) throws Exception {
		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
