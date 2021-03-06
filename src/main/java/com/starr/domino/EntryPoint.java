package com.starr.domino;


import com.starr.domino.reader.CountReader;
import com.starr.domino.reader.ICountReader;
import com.starr.domino.resolver.BruteForceResolver;
import com.starr.domino.util.DominoConfig;

public class EntryPoint {

    public static void main(String[] args) {
        ICountReader countReader = new CountReader(args);
        DominoApplication app = new DominoApplication(new BruteForceResolver());
        app.run((countReader).readCount(DominoConfig.calculateDominoesCount()));
    }

}
