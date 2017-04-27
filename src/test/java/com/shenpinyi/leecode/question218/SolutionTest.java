package com.shenpinyi.leecode.question218;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jack on 17/04/2017.
 */
public class SolutionTest {

    @Test
    public void testGetSkyline() throws Exception {
        List<int[]> a = new Solution().getSkyline(
            new int[][]{
                {2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}
            }
        );
        List<int[]> b = new Solution().getSkyline(new int[][]
            {{2190,661048,758784},{9349,881233,563276},{12407,630134,38165},{22681,726659,565517},{31035,590482,658874},{41079,901797,183267},{41966,103105,797412},{55007,801603,612368},{58392,212820,555654},{72911,127030,629492},{73343,141788,686181},{83528,142436,240383},{84774,599155,787928},{106461,451255,856478},{108312,994654,727797},{126206,273044,692346},{134022,376405,472351},{151396,993568,856873},{171466,493683,664744},{173068,901140,333376},{179498,667787,518146},{182589,973265,394689},{201756,900649,31050},{215635,818704,576840},{223320,282070,850252},{252616,974496,951489},{255654,640881,682979},{287063,366075,76163},{291126,900088,410078},{296928,373424,41902},{297159,357827,174187},{306338,779164,565403},{317547,979039,172892},{323095,698297,566611},{323195,622777,514005},{333003,335175,868871},{334996,734946,720348},{344417,952196,903592},{348009,977242,277615},{351747,930487,256666},{363240,475567,699704},{365620,755687,901569},{369650,650840,983693},{370927,621325,640913},{371945,419564,330008},{415109,890558,606676},{427304,782478,822160},{439482,509273,627966},{443909,914404,117924},{446741,853899,285878},{480389,658623,986748},{545123,873277,431801},{552469,730722,574235},{556895,568292,527243},{568368,728429,197654},{593412,760850,165709},{598238,706529,500991},{604335,921904,990205},{627682,871424,393992},{630315,802375,714014},{657552,782736,175905},{701356,827700,70697},{712097,737087,157624},{716678,889964,161559},{724790,945554,283638},{761604,840538,536707},{776181,932102,773239},{855055,983324,880344}}
        );

        a.forEach(e -> System.out.print("[" + e[0] + "," + e[1] + "]"));
        b.forEach(e -> System.out.print("[" + e[0] + "," + e[1] + "]"));
    }

    @Test
    public void testDiscrete() throws Exception {
        List<Integer> a = new Solution().discrete(new int[][]{
            {2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}
        });
        System.out.println(a);
    }
}