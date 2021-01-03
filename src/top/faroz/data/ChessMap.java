package top.faroz.data;

import top.faroz.domain.ChessColor;
import top.faroz.domain.Position;

import java.util.Stack;

/**
 * @ClassName Map
 * @Description 全局数据区，每次都会从这里取数据
 * @Author FARO_Z
 * @Date 2020/12/31 下午4:59
 * @Version 1.0
 **/
public class ChessMap {
    public static ChessColor[][] map;//当前棋盘
    public static ChessColor[][] preMap;//前一个棋盘
    public static int[][] value;//棋盘权值
    public static int size;//棋盘大小
    public static Stack<Position> blackPositions= new Stack<Position>();//存储黑子的位置
    public static Stack<Position> whitePositions= new Stack<Position>();//存储白子的位置

    /**
     * 存入新的map值
     * @param map 每次重新存入的map
     */
    public static void setMap(ChessColor[][] map) throws Exception {
        //新旧更替
        ChessMap.preMap= ChessMap.map;
        ChessMap.map = map;
        //这里，是默认棋盘都是正方形的
        int preSize = ChessMap.size;
        if (preSize>0) {
            if (preSize!=map[0].length)
                throw new Exception("输入错误，不是同一个棋盘");
        }
        ChessMap.size=map[0].length;
        ChessMap.value=new int[ChessMap.size][ChessMap.size];
    }

    public static boolean inBoundary(Position p) {
        if (map==null) return false;//判断范围，一定要建立在棋盘存在的前提下
        if (p.row<0 || p.row>=size || p.col<0 || p.col>=size) return false;
        return true;
    }

    /**
     * 获取p位置，棋子的颜色
     * @param p
     * @return 获取的颜色
     */
    public static ChessColor getPositionColor(Position p) {
        if (!inBoundary(p) || map==null) return null;
        return map[p.row][p.col];
    }
}
