package com.hulikui.fivechess;

public enum Chessman {
	BLACK("●  "), WHITE("○  ");
	//public static final Chessman  BLACK  = Chessman("●");
	//public static final Chessman  WHITE = Chessman("○");
	private String chessman;
	
	/**
	 * 私有构造器
	 */
	private Chessman(String chessman) {
		this.chessman = chessman;
	}

	/**
	 * @return String 黑棋或者白棋
	 */
	public String getChessman() {
		return this.chessman;
	}
}