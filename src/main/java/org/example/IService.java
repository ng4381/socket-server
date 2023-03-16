package org.example;

import java.io.*;

public interface IService {
    //    void start(BufferedReader in, BufferedWriter out) throws IOException;
    void init(BufferedReader in, BufferedWriter out);
    void start() throws IOException;
}
