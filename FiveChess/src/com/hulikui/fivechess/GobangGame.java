package com.hulikui.fivechess;

import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// ����ﵽӮ������������Ŀ
	//private final int WIN_COUNT = 5;
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
		if (board[posX][posY] != "ʮ      ") {
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
	 * ˵��������ٷ��ж�ÿһ���������ĸ�����ĵ����������
	 * ���ó����������ֵ�����꣬����
	 */
	// ���������

	public int[] computerDo() {
		String[][] board = chessboard.getBoard();
		
		int max_black,max_white,max_temp,max=0;
		int width=Chessboard.BOARD_SIZE-1;
		int height=Chessboard.BOARD_SIZE-1;
		System.out.println("��������� ...");
	   for(int i = 0; i <= width; i++){
		for(int j = 0; j <= height; j++){
		 if(board[i][j] == "ʮ      "){//�㷨�ж��Ƿ�����
		  max_white=checkMax(i,j,Chessman.WHITE.getChessman());//�жϰ��ӵ����ֵ
		  max_black=checkMax(i,j,Chessman.BLACK.getChessman());//�жϺ��ӵ����ֵ
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



	//����������ĳһ�����ϰ˸��������ӵ����ֵ��
	//��˸�����ֱ��ǣ����ҡ��ϡ��¡����ϡ����¡����ϡ�����
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
		int num=1;
	  	int x_temp=posX,y_temp=posY;
	   	int x_temp1=x_temp,y_temp1=y_temp;
	   	String[][] board = chessboard.getBoard();
	   //�ж��ұ�
	   for(int i=1;i<6;i++){
		x_temp1+=1;
		if(x_temp1>Chessboard.BOARD_SIZE-1)
		 break;
		if(board[x_temp1][y_temp1]==ico)
		 num++;
		else
		 break;
	   }
	   //�ж����
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

	   //�ж��Ϸ�
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
	   //�ж��·�
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

	   //�ж�����
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
	   //�ж�����
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

	   //�ж�����
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
	   //�ж�����
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
