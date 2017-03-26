package com.starr.domino;


import com.starr.domino.reader.CountReader;
import com.starr.domino.resolver.BruteForceResolver;

public class EntryPoint {

    public static void main(String[] args) {
        CountReader countReader = new CountReader(args);
        DominoApplication app = new DominoApplication(new BruteForceResolver());
        app.run((countReader).readCount());
    }

}
