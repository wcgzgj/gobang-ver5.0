package top.faroz.ai;

import top.faroz.data.ChessMap;
import top.faroz.domain.ChessColor;

/**
 * @ClassName AI
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/12/31 下午5:01
 * @Version 1.0
 **/
public class AI {
    public static ChessColor[][] aiPlay(ChessColor[][] map) {
        try {
            ChessMap.setMap(map);
        } catch (Exception e) {
            //如果输入的棋盘
            //和上一次的棋盘不是同一个格式
            //会报错
            e.printStackTrace();
            return null;
        }



        return null;
    }
}
