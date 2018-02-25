package by.work.jefu.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import by.work.jefu.Main;

public class MainTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    
    @Test
    public void testMain() {
        Main.main(new String[] {});
        String first = ".secneuqes rahc fo sdnik tnereffid ynam ot "
                + "ssecca ylno-daer ,mrofinu sedivorp ecafretni sihT "
                + ".seulav rahc fo ecneuqes elbadaer a si ecneuqeSrahC A";
        Assert.assertEquals("test", first,this.log.getLog());
    }

}
