package com.hb.study.udemylpajavamasterclass.section3_firststeps.demostubs;

import com.hb.study.udemylpajavamasterclass.section3_firststeps.demostubs.HelloWorld;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HelloWorldTest {

    @Test
    void testMainWithArgs() {
        String[] args = {"Jane", "Doe"};
        assertDoesNotThrow(() -> HelloWorld.main(args));
    }
}