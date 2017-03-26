package com.starr.domino;


public class EntryPoint {

    public static void main(String[] args) {
        DominoApplication app = new DominoApplication();
        app.run((new CountReader()).readCount(args));
    }

}
