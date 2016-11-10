package Itello;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cof on 2016-11-07.
 */
public class MainTest {
    @Test
    public void crunchy() {
        String a = "crunchy";
        String atbashEncryption = Main.getAtbashEncryption(a);
        assertEquals("ålipåve", atbashEncryption);
    }
    @Test
    public void  PeanutButter() {
        String a = "Peanut Butter Jordnötssmör";
        String atbashEncryption = Main.getAtbashEncryption(a);
        assertEquals("Nyöpij Äijjyl Tolzpajkkqal", atbashEncryption);
    }
    @Test
    public void Glass() {
        String a = "Glass";
        String atbashEncryption = Main.getAtbashEncryption(a);
        assertEquals("Wrökk", atbashEncryption);
    }
    @Test
    public void mening() {
        String a = "This is a sentence!";
        String atbashEncryption = Main.getAtbashEncryption(a);
        assertEquals("Jvuk uk ö kypjypåy!", atbashEncryption);
    }
    @Test
    public void cat() {
        String a = "I am a cat! Meow? Meow!";
        String atbashEncryption = Main.getAtbashEncryption(a);
        assertEquals("U öq ö åöj! Qyog? Qyog!", atbashEncryption);
    }
    @Test
    public void c() {
        String a = "c";
        String atbashEncryption = Main.getAtbashEncryption(a);
        assertEquals("å", atbashEncryption);
    }
    @Test
    public void  num() {
        String a = "0123456789";
        String atbashEncryption = Main.getAtbashEncryption(a);
        assertEquals("9876543210", atbashEncryption);
    }
    @Test
    public void  weirdsymbols() {
        String a = "ÅÄÖ[\\]åäö{|}";
        String atbashEncryption = Main.getAtbashEncryption(a);
        assertEquals("CBA[\\]cba{|}", atbashEncryption);
    }
}