import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������X����
	private int posY = 0;
	// ��������
	private Chessboard chessboard;

	/**
	 * �չ�����
	 */
	public GobangGame() {
	}

	/**
	 * ����������ʼ�����̺���������
	 * 
	 * @param chessboard
	 *            ������
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * ��������Ƿ�Ϸ���
	 * 
	 * @param inputStr
	 *            �ɿ���̨������ַ�����
	 * @return �ַ����Ϸ�����true,���򷵻�false��
	 */
	public boolean isValid(String inputStr) {
		
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
	
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
			return false;
		}
	
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "ʮ") {
			chessboard.printBoard();
			System.out.println("��λ���Ѿ������ӣ����������룺");
			return false;
		}
		return true;
	}

	/**
	 * ��ʼ����
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
	 * �Ƿ����¿�ʼ���塣
	 * 
	 * @param chessman
	 *            "��"Ϊ�û���"��"Ϊ�������
	 * @return ��ʼ����true�����򷵻�false��
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�"
				: "���ź��������ˣ�";
		System.out.println(message + "����һ�֣�(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			return true;
		}
		return false;

	}

	/**
	 * ������������
	 */
	public int[] computerDo() {
		
		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "ʮ") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		int[] result = { posX, posY };
		return result;
	}

	/**
	 * �ж���Ӯ
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            ��������
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��
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
