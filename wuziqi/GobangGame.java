package com.leetcode.homework.wuziqi;
import java.io.BufferedReader;
import java.io.InputStreamReader;

 //��-�¼�֦������
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
		// ���û�������ַ����Զ���(,)��Ϊ�ָ����ָ��������ַ���
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
		// ���������ֵ�Ƿ��ڷ�Χ֮��
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
			return false;
		}
		// ��������λ���Ƿ��Ѿ�������
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
		// trueΪ��Ϸ����
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// ��ȡ���̵�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:ÿ����������һ�����ݰ��س���������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// ������Ϸ���Ҫ���������룬�ټ���
				continue;
			}
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// ��������ѡ��λ������
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// �жϼ�����Ƿ�Ӯ��
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// �������ʤ�ߣ�ѯ���û��Ƿ������Ϸ
			if (isOver) {
				// ������������³�ʼ�����̣�������Ϸ
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// ������������˳�����
				break;
			}
			chessboard.printBoard();
			System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
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
			// ��ʼ��һ��
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
	 * �����AI����
	 * 
	 * 1.�Ȳ��������˸��Ӿ�Ӯ�˵����
	 * 2.�Ȳ����Ǽ�֦�����
	 * 3.��ʱû��д����������֮�󽫽��иĽ�
	 * **/
	public  int computerDoWithAI(int depth,String chessman,int posX,int posY) {
		int curValue;
		//���˸��Ӿ�Ӯ�˵�����£�Ӧ����������ֵ
		if(depth == 0){
			return inLineNums(Chessman.WHITE.getChessman()) - inLineNums(Chessman.BLACK.getChessman());
		} 
		
		//���и�����֧�ĵݹ����
		for(int i = 0;i<Chessboard.BOARD_SIZE - 1;i++){
			for(int j = 0;j<Chessboard.BOARD_SIZE - 1;j++){
	             if(chessboard.getBoard()[i][j] == "ʮ"){
	            	 chessboard.setBoard(i,j,chessman);
	             }	
	             String opsChessman = chessman == Chessman.WHITE.getChessman()?Chessman.BLACK.getChessman():Chessman.WHITE.getChessman();
	             curValue = computerDoWithAI(depth--,opsChessman,i,j);
	             chessboard.setBoard(posX,posY,"ʮ");
				 return inLineNums(Chessman.WHITE.getChessman()) - inLineNums(Chessman.BLACK.getChessman())+curValue;
			}
		}
		return 0;
	}
	
	private int inLineNums(String ico) {
	  //�������������ҳ���5�ӵĸ���
	  //ÿ�α���ʱ���ܾ����Ѿ�������λ��
		//ÿ�α������ҵ��Ըõ�Ϊ���ĳ�5�ӵĸ���
		String[][] board = chessboard.getBoard();
		int nums = 0;
		for(int i = 0;i<Chessboard.BOARD_SIZE - 1;i++){
			for(int j = 0;j<Chessboard.BOARD_SIZE - 1;j++){
				if(board[i][j].equalsIgnoreCase("ʮ")||board[i][j].equalsIgnoreCase(ico)){
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
		while(i_p<Chessboard.BOARD_SIZE&&j_p<Chessboard.BOARD_SIZE&&(chessboard.getBoard()[i_p][j_p].equals(icon)||chessboard.getBoard()[i_p][j_p].equals("ʮ"))){
			nums++;
			i_p+=Xplus;
			j_p+=Yplus;
		}
		
		return nums;
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
		//�ܹ����������򣺺���/����/б��(���ӵ�һ���޵ĽǶ�����)
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
