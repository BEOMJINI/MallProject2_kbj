package _mall;

import controller.MallController;
import util.Util;

public class _Main {
public static void main(String[] args) {
	MallController.getInstance().init();
	Util.sc.close();
}
}
