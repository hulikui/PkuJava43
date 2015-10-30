package com.leetcode.homework.wuziqi;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

 //��-�¼�֦������
public class GobangGame_simple {
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
	public GobangGame_simple() {
	}

	/**
	 * ����������ʼ�����̺���������
	 * 
	 * @param chessboard
	 *            ������
	 */
	public GobangGame_simple(Chessboard chessboard) {
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
				//int[] computerPosArr = computerDo();
				
				chessman = Chessman.WHITE.getChessman();
				int[] computerPosArr = computerDoWithAI(chessman);
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
	 * 3.��ʱû��д����������֮�󽫽��иĽ���ĿǰΪһ������Ľ�
	 * **/
	public  int[] computerDoWithAI(String chessman) {
		int[] result = new int[2];
		int curValue = 0;
		//���˸��Ӿ�Ӯ�˵�����£�Ӧ����������ֵ:4��
		
		//�Է����˸��Ӻ�ȿ���Ӯ���߳�4���޷���ס������������֮��ֵ3��
		
		//���˸��Ӻ���һ������Ӯ����4�ӳ�������ͷ���˶£��������ٴ�֮��ֵ2��
		
		//Ѱ��������������ܳ����ӵ������1��
		
		for(int i = 0;i<Chessboard.BOARD_SIZE - 1;i++){
			for(int j=0;j<Chessboard.BOARD_SIZE - 1;j++){
	             if(chessboard.getBoard()[i][j] != "ʮ")
	            	 break;
	            
	             String opsChessman = chessman == Chessman.WHITE.getChessman()?Chessman.BLACK.getChessman():Chessman.WHITE.getChessman();
	             
	             //��������õ������ɵ������
	             int[] array = findMostLength(i,j,chessman);
	            	
	             //�����������ĵ÷�
	             if(array[3]==5){
	            	 result[0]=array[0];
	            	 result[1]=array[1];
	            	 curValue = 7;
	            	 break;
	             }else if(array[3]==4&&array[3]<Chessboard.BOARD_SIZE&&array[4]<Chessboard.BOARD_SIZE&&chessboard.getBoard()[array[3]][array[4]].equals("ʮ")&&array[5]<Chessboard.BOARD_SIZE&&array[6]<Chessboard.BOARD_SIZE&&chessboard.getBoard()[array[5]][array[6]].equals("ʮ")){
	            	 if(5>curValue){
	            		 result[0]=array[0];
		            	 result[1]=array[1];
		            	 curValue = 5;
	            	 }
	             }else if(array[3]==3&&array[3]<Chessboard.BOARD_SIZE&&array[4]<Chessboard.BOARD_SIZE&&chessboard.getBoard()[array[3]][array[4]].equals("ʮ")&&array[5]<Chessboard.BOARD_SIZE&&array[6]<Chessboard.BOARD_SIZE&&chessboard.getBoard()[array[5]][array[6]].equals("ʮ")){
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
		//�����������������
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
		int[] result = findMostLength(posX,posY,ico);
		return result[2]==5;
	}

	public static void main(String[] args) throws Exception {
		GobangGame_simple gb = new GobangGame_simple(new Chessboard());
		gb.start();
	}
}
