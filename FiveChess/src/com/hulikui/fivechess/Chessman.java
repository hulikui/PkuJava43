package com.hulikui.fivechess;

public enum Chessman {
	BLACK("��  "), WHITE("��  ");
	//public static final Chessman  BLACK  = Chessman("��");
	//public static final Chessman  WHITE = Chessman("��");
	private String chessman;
	
	/**
	 * ˽�й�����
	 */
	private Chessman(String chessman) {
		this.chessman = chessman;
	}

	/**
	 * @return String ������߰���
	 */
	public String getChessman() {
		return this.chessman;
	}
}