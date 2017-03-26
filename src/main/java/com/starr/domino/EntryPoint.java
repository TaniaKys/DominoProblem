package com.starr.domino;


public class EntryPoint {

    public static void main(String[] args) {
        DominoApplication app = new DominoApplication();
        String[] strings = {"5",""};
        app.run((new CountReader(0, 6)).readCount(strings));
    }

}
