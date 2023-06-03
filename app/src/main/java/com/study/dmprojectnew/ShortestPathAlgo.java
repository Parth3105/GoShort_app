package com.study.dmprojectnew;


import java.util.ArrayList;
import java.util.Iterator;

public class ShortestPathAlgo {
    static final int inf = 100000000;

    ArrayList<Integer> journey;

    int source[][] = {
            {0, 100, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf},    //0
            {100, 0, 50, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 180, inf, 180, 300, inf, inf, inf},     //1
            {inf, 50, 0, 35, 25, inf, inf, inf, inf, inf, inf, inf, inf, 35, inf, inf, inf, inf, inf, inf, inf},         //2
            {inf, inf, 35, 0, 25, inf, 65, inf, inf, inf, inf, inf, inf, 30, inf, inf, inf, inf, inf, inf, inf},        //3
            {inf, inf, 25, 25, 0, 75, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf},       //4
            {inf, inf, inf, inf, 75, 0, 145, inf, inf, inf, inf, inf, 130, inf, inf, inf, inf, 15, 150, inf, inf},      //5
            {inf, inf, inf, 65, inf, 145, 0, 50, inf, inf, inf, inf, 10, 65, inf, inf, inf, inf, inf, inf, inf},        //6
            {inf, inf, inf, inf, inf, inf, 50, 0, inf, inf, inf, inf, inf, 60, inf, inf, inf, inf, inf, 130, 40},       //7
            {inf, inf, inf, inf, inf, inf, inf, inf, 0, inf, inf, inf, inf, inf, 20, 35, 13, inf, inf, 35, inf},        //8
            {inf, inf, inf, inf, inf, inf, inf, inf, inf, 0, inf, inf, 10, inf, inf, inf, inf, inf, 15, inf, inf},      //9
            {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 0, inf, inf, inf, inf, inf, inf, inf, 130, inf, inf},    //10
            {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 0, inf, inf, inf, inf, inf, inf, 5, inf, inf},      //11
            {inf, inf, inf, inf, inf, 130, 10, inf, inf, 10, inf, inf, 0, inf, inf, inf, inf, inf, inf, inf, inf},      //12
            {inf, inf, 35, 30, inf, inf, 65, 60, inf, inf, inf, inf, inf, 0, 112, 105, inf, inf, inf, inf, 35},         //13
            {inf, 180, inf, inf, inf, inf, inf, inf, 20, inf, inf, inf, inf, 112, 0, 20, inf, inf, inf, inf, inf},       //14
            {inf, inf, inf, inf, inf, inf, inf, inf, 35, inf, inf, inf, inf, 105, 20, 0, inf, inf, inf, 28, 72},        //15
            {inf, 180, inf, inf, inf, inf, inf, inf, 13, inf, inf, inf, inf, inf, inf, inf, 0, inf, inf, inf, inf},      //16
            {inf, 300, inf, inf, inf, 15, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 0, inf, inf, inf},     //17
            {inf, inf, inf, inf, inf, 150, inf, inf, inf, 15, 130, 5, inf, inf, inf, inf, inf, inf, 0, inf, inf},       //18
            {inf, inf, inf, inf, inf, inf, inf, 170, 35, inf, inf, inf, inf, inf, inf, 28, inf, inf, inf, 0, 140},      //19
            {inf, inf, inf, inf, inf, inf, inf, 40, inf, inf, inf, inf, inf, 35, inf, 72, inf, inf, inf, 140, 0}        //20
    };

    int node;
    int dist[][] = source;
    int path[][];
    int start;
    int destination[];
    int total;


    ShortestPathAlgo(int start, int destination[], int node, int total) {
        this.start = start;
        this.destination = destination;
        this.node = node;
        this.total = total;

        journey = new ArrayList<>();
        path = new int[node][node];

        for (int i = 0; i < node; i++) {
            for (int j = 0; j < node; j++) {
                if (dist[i][j] == inf) {
                    path[i][j] = -1;
                } else {
                    path[i][j] = j;
                }
            }
        }
    }

    void initialProcess() {
        for (int k = 0; k < node; k++) {
            for (int i = 0; i < node; i++) {
                for (int j = 0; j < node; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = path[i][k];
                    }
                }
            }
        }
    }

    ArrayList<Integer> createPath() {
        initialProcess();
        for (int i = 0; i < total; i++) {
            while (start != destination[i]) {
                journey.add(start);
                start = path[start][destination[i]];
            }
        }
        journey.add(destination[total - 1]);
        return journey;
    }
}
