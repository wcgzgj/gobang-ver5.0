package top.faroz.utils;

import java.util.HashMap;

/**
 * @ClassName ChessValueUtil
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/12/31 下午6:16
 * @Version 1.0
 **/
public class ChessValueUtil {
    public static HashMap<String,Long> map=new HashMap<>();
    //五子棋棋形，最长为7，最短为4（有些棋形必须将空位包含进去）

    /**
     *   *:表示黑子
     *   -:表示空位
     *   o:表示白子
     */
    static {
        //还要重新设计赋分策略，才能保证五子棋机器人的准确判断
        //因为已经固定了 *为黑子，且默认将机器人设为黑方，所以机器人只能是黑方

        //还要设置防守方的数值，防止被gank掉
        //右边put的map值，是防守分数，这样Ai就不会一味的猛冲

        //左边：黑方Ai的棋子判断                      右边：Ai结束后，玩家可能的棋子判断
        map.put("*****", (long) 100000);//连五
        /*                                 */map.put("ooooo", (long) 30000);
        map.put("-****-", (long) 5000);//活四
        /*                                 */map.put("-oooo-", (long) 3000);
        map.put("*-***", (long) 700);//冲四  1
        /*                                 */map.put("o-ooo", (long) 150);
        map.put("***-*", (long) 700);//冲四  1  反向
        /*                                 */map.put("ooo-o", (long) 150);
        map.put("-****o", (long) 1000);//冲四  2
        /*                                 */map.put("-oooo*", (long) 200);
        map.put("o****-", (long) 1000);//冲四  2  反向
        /*                                 */map.put("*oooo-", (long) 200);
        map.put("**-**", (long) 700);//冲四   3
        /*                                 */map.put("oo-oo", (long) 200);
        map.put("-***-", (long) 500);//活三   1
        /*                                 */map.put("-ooo-", (long) 100);
        map.put("*-**", (long) 150);//活三  2
        /*                                 */map.put("o-oo", (long) 50);
        map.put("**-*", (long) 150);//活三  2   反向
        /*                                 */map.put("oo-o", (long) 50);
        map.put("--***o", (long) 100);//眠三  1
        /*                                 */map.put("--ooo*", (long) 20);
        map.put("o***--", (long) 100);//眠三  1  反向
        /*                                 */map.put("*ooo--", (long) 20);
        map.put("-*-**o", (long) 80);//眠三   2
        /*                                 */map.put("-o-oo*", (long) 15);
        map.put("o**-*-", (long) 80);//眠三   2  反向
        /*                                 */map.put("*oo-o-", (long) 15);
        map.put("-**-*o", (long) 60);//眠三   3
        /*                                 */map.put("-oo-o*", (long) 10);
        map.put("o*-**-", (long) 60);//眠三   3   反向
        /*                                 */map.put("*o-oo-", (long) 10);
        map.put("*--**", (long) 60);//眠三   4
        /*                                 */map.put("o--oo", (long) 10);
        map.put("**--*", (long) 60);//眠三   4   反向
        /*                                 */map.put("oo--o", (long) 10);
        map.put("*-*-*", (long) 60);//眠三   5
        /*                                 */map.put("o-o-o", (long) 10);
        map.put("o-***-o", (long) 60);//眠三   6
        /*                                 */map.put("*-ooo-*", (long) 2);
        map.put("--**--", (long) 50);//活二  1
        /*                                 */map.put("--oo--", (long) 2);
        map.put("-*-*-", (long) 20);//活二   2
        /*                                 */map.put("-o-o-", (long) 2);
        map.put("*--*", (long) 20);//活二   3
        /*                                 */map.put("o--o", (long) 2);
        map.put("---**o", (long) 10);//眠二  1
        /*                                 */map.put("---oo*", (long) 1);
        map.put("o**---", (long) 10);//眠二  1   反向
        /*                                 */map.put("*oo---", (long) 1);
        map.put("--*-*o", (long) 10);//眠二  2
        /*                                 */map.put("--o-o*", (long) 1 );
        map.put("o*-*--", (long) 10);//眠二  2   反向
        /*                                 */map.put("*o-o--", (long) 1);
        map.put("-*--*o", (long) 10);//眠二  3
        /*                                 */map.put("-o--o*", (long) 1);
        map.put("o*--*-", (long) 10);//眠二  3   反向
        /*                                 */map.put("*o--o-", (long) 1);
        map.put("*---*", (long) 10);//眠二  4
        /*                                 */map.put("o---o", (long) 1);
        //上面之所以int类型不能自动向上转换为long类型
        //是因为hashMap中的value使用的是包装类Long
        //包装类虽然能自动装箱，但是不能将基础类型转换，再装箱
        //所以需要手动转换为long类型
    }
}
