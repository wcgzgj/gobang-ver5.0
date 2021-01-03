package top.faroz.start;

import top.faroz.domain.ChessColor;

/**
 * @ClassName Start
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/12/31 下午4:52
 * @Version 1.0
 **/
public class Start {
    // private Data data;  存放全局数据
    // private GUI gui;  绘制棋盘
    public static void main(String[] args) {
        //具体的运行流程，是在一个循环里面
        //每次玩家下一个子（GUI界面中进行点击）
        //然后返回一个棋盘
        //然后AI通过这个棋盘，判断自己的走法
        //最后再将这个棋盘返回给GUI，重绘棋盘，循环进行
        ChessColor[][] map = new ChessColor[15][15];

        //map = AI.play(colors);  AI落子，返回一个新的棋盘

        //GUI进行重绘
    }
}
