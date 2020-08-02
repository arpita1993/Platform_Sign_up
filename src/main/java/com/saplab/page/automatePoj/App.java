package com.saplab.page.automatePoj;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws AWTException
    {
        System.out.println( "Hello World!" );
        
        Robot rt=new Robot();
        
        rt.keyPress(KeyEvent.VK_DOWN);
        rt.keyPress(KeyEvent.VK_TAB);
    }
}
