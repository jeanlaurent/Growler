package net.morlhon.growl;

import org.junit.Test;

public class GrowlerTest
{

    @Test
    public void testGrowl()
    {
        new Growler().growl("foo", "bar", "Eclipse");
        new Growler().growl("qiz", "baz", "iTunes");
    }

}
