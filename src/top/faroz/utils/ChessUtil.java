package top.faroz.utils;

import top.faroz.data.ChessMap;
import top.faroz.domain.ChessColor;
import top.faroz.domain.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ChessUtil
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/12/31 下午5:27
 * @Version 1.0
 **/
public class ChessUtil {

    /**
     * 获取当前位置
     * 长度为length
     * 在棋链位置为loc
     * 的棋链
     * 这里的custom，指的是位置,length,loc都是自定义的
     * @param p 当前位置
     * @param length 棋链长度
     * @param loc 在棋链的位置
     * @param supposeColor 假设该位置是什么颜色的棋子
     * @return
     */
    public static List<List<ChessColor>> getCustomLocationList(Position p, int length, int loc,ChessColor supposeColor) {
        //使用全局数据区的棋盘信息
        ChessColor[][] pad = ChessMap.map;
        int size = ChessMap.size;

        int row=p.row;
        int col=p.col;

        //如果当前位置不在棋盘范围内，就没有判断的必要
        if (!ChessMap.inBoundary(p)) return null;
        //如果当前位置的棋子颜色不是 blank，就没有判断的必要
        if (ChessMap.getPositionColor(p)==null || ChessMap.getPositionColor(p)!=ChessColor.Blank)
            return null;

        //存储所有棋链的容器
        List<List<ChessColor>> list = new ArrayList<>();

        /**
         * Lay方向取棋子
         */
        //棋链的起始位置
        Position layStart = new Position(row, col - loc + 1);
        //棋链的终止位置
        Position layEnd = new Position(row, col + length - loc);
        //保证棋链的头尾都要在范围内
        if (ChessMap.inBoundary(layStart) && ChessMap.inBoundary(layEnd)) {
            //存储横向的棋链的容器
            List<ChessColor> layList = new ArrayList<>();
            for (int i = layStart.col; i <= layEnd.col; i++) {
                if (i==col) {
                    layList.add(supposeColor);
                } else {
                    layList.add(pad[p.row][i]);
                }
            }
            list.add(layList);
        }

        /**
         * Stand方向取棋子
         */
        Position standStart = new Position(row - loc + 1, col);
        Position standEnd = new Position(row + length - loc, col);
        if (ChessMap.inBoundary(standStart) && ChessMap.inBoundary(standEnd)) {
            List<ChessColor> standList = new ArrayList<>();
            for (int i = standStart.row; i <= standEnd.row; i++) {
                if (i==row) {
                    standList.add(supposeColor);
                } else {
                    standList.add(pad[i][p.col]);
                }
            }
            list.add(standList);
        }


        /**
         * Main 方向取棋子
         */
        Position MainStart = new Position(row - loc + 1, col-loc+1);
        Position MainEnd = new Position(row + length - loc, col + length - loc);

        if (ChessMap.inBoundary(MainEnd) && ChessMap.inBoundary(MainStart)) {
            List<ChessColor> mainList = new ArrayList<>();
            for (int rowi = MainStart.row, coli = MainStart.col; rowi <= MainEnd.row; rowi++,coli++) {
                if (rowi==row && coli==col) {
                    mainList.add(supposeColor);
                } else {
                    mainList.add(pad[rowi][coli]);
                }
            }
            list.add(mainList);
        }

        /**
         * Vice 方向取棋子
         */
        Position ViceStart = new Position(row+loc-1,col-loc+1);
        Position ViceEnd = new Position(row-length+loc,col+length-loc);
        if (ChessMap.inBoundary(ViceStart) && ChessMap.inBoundary(ViceEnd)) {
            List<ChessColor> viceList = new ArrayList<>();
            //vice方向，row递减，col递增
            for (int rowi=ViceStart.row,coli=ViceStart.col;rowi>=ViceEnd.row;rowi--,coli++) {
                if (rowi==row && coli==col) {
                    viceList.add(supposeColor);
                } else {
                    viceList.add(pad[rowi][coli]);
                }
            }
            list.add(viceList);
        }

        return list;
    }

    /**
     * 获取当前空位的棋链
     * 当前空位会被替换为supposeColor
     * @param p 当前空位
     * @param supposeColor 替换当前空位的颜色
     * @return 返回获取的所有棋链
     */
    public static List<List<ChessColor>> getAllList(Position p,ChessColor supposeColor) {
        List<List<ChessColor>> list = new ArrayList<>();
        //将所有可能的棋子形状放入list中
        for (int i = 4; i <=7 ; i++) {
            for (int j = 1; j <=i ; j++) {
                List<List<ChessColor>> tmp = getCustomLocationList(p, i, j,ChessColor.Black);
                if (tmp!=null) list.addAll(tmp);
            }
        }
        return list;
    }


    /**
     * 封装获取棋链的操作，最后获取的是棋链的字符串表现形式
     * @param p 空位
     * @param supposeColor 替换当前空位的颜色
     * @return
     */
    public static List<String> getAllStringList(Position p,ChessColor supposeColor) {

        List<String> StringList = new ArrayList<>();
        List<List<ChessColor>> allList = getAllList(p,supposeColor);

        for (List<ChessColor> chessColors : allList) {
            StringList.add(ChessChainToString(chessColors));
        }
        return StringList;
    }

    /**
     * 将棋子的颜色序列转换为字符序列
     * 这样才能放入hashMap中进行比较
     * @param list
     * @return
     */
    public static String ChessChainToString(List<ChessColor> list) {
        String pool="";
        for (ChessColor chessColor : list) {
            if (chessColor==ChessColor.Blank) {
                pool+="-";
            } else if (chessColor==ChessColor.Black) {
                pool+="*";
            } else if(chessColor==ChessColor.White){
                pool+="o";
            } else {
                //放入一个hash表中不存在的字符
                //这样后面算权值的时候就不会把它加进去了
                pool+="#";
            }
        }
        return pool;
    }


}
