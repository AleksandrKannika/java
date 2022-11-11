package homework.hw3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class MapBuilder {
    int[][] map;

    public MapBuilder() {
        int[][] map = {
                { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, 00, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, 00, -1, -1, 00, -1, -1, 00, 00, -1, -1, -1, -1, 00, -1, -1, -1, -1, 00, -1 },
                { -1, 00, 00, 00, 00, -1, 00, 00, -1, 00, -1, 00, -1, 00, 00, -1, 00, -1, 00, -1 },
                { -1, 00, -1, 00, -1, 00, -1, 00, -1, 00, -1, 00, -1, 00, -1, -1, 00, -1, 00, -1 },
                { -1, 00, 00, -1, 00, 00, -1, -1, 00, 00, 00, 00, 00, -1, 00, -1, 00, -1, 00, -1 },
                { -1, 00, 00, 00, 00, 00, -1, 00, -1, -1, -1, -1, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, 00, 00, -1, -1, -1, 00, 00, 00, 00, 00, 00, -1, -1, -1, -1, 00, -1, 00, -1 },
                { -1, 00, 00, 00, 00, 00, 00, 00, -1, 00, 00, -1, 00, 00, 00, 00, 00, -1, 00, -1 },
                { -1, 00, -1, -1, 00, -1, -1, 00, -1, -1, 00, -1, -1, -1, 00, -1, -1, -1, 00, -1 },
                { -1, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, -1, 00, 00, -1, -1, -1, -1, 00, -1 },
                { -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1, 00, -1 },
                { -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
        };
        this.map = map;
    }

    public void setStart(Point pos) {
        map[pos.x][pos.y] = -2;
    }

    public void setExit(Point pos) {
        map[pos.x][pos.y] = -3;
    }

    public int[][] getMap() {
        return map;
    }
}

class MapPrint {
    public String printM(int[][] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                sb.append(String.format("%4d", a[i][j]));
            }
            sb.append("\n");

        }
        return sb.toString();
    }

}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("x = %d; y = %d", x, y);
    }
}

class WaveAlgoritm {
    int[][] map;

    public WaveAlgoritm(int[][] map) {
        this.map = map;
    }

    public void FillMap(Point startPoint) {
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(startPoint);
        map[startPoint.x][startPoint.y] = 1;
        while (queue.size() != 0) {
            Point p = queue.remove();
            if (map[p.x - 1][p.y] == 0) {
                queue.add(new Point(p.x - 1, p.y));
                map[p.x - 1][p.y] = map[p.x][p.y] + 1;
            }
            if (map[p.x][p.y + 1] == 0) {
                queue.add(new Point(p.x, p.y + 1));
                map[p.x][p.y + 1] = map[p.x][p.y] + 1;
            }
            if (map[p.x + 1][p.y] == 0) {
                queue.add(new Point(p.x + 1, p.y));
                map[p.x + 1][p.y] = map[p.x][p.y] + 1;
            }
            if (map[p.x][p.y - 1] == 0) {
                queue.add(new Point(p.x, p.y - 1));
                map[p.x][p.y - 1] = map[p.x][p.y] + 1;
            }
        }
    }

    public ArrayList<Point> GetFindPath(Point exitPoint) {
        ArrayList<Point> findPath = new ArrayList<>();
        var ex = exitPoint;
        findPath.add(exitPoint);
        while (map[ex.x][ex.y] != 1) {
            if (map[ex.x - 1][ex.y] < map[ex.x][ex.y] && map[ex.x - 1][ex.y] > -1) {
                findPath.add(new Point(ex.x - 1, ex.y));
                ex = (new Point(ex.x - 1, ex.y));
            } else if (map[ex.x][ex.y + 1] < map[ex.x][ex.y] && map[ex.x][ex.y + 1] > -1) {
                findPath.add(new Point(ex.x, ex.y + 1));
                ex = (new Point(ex.x, ex.y + 1));
            } else if (map[ex.x + 1][ex.y] < map[ex.x][ex.y] && map[ex.x + 1][ex.y] > -1) {
                findPath.add(new Point(ex.x + 1, ex.y));
                ex = (new Point(ex.x + 1, ex.y));
            } else if (map[ex.x][ex.y - 1] < map[ex.x][ex.y] && map[ex.x][ex.y - 1] > -1) {
                findPath.add(new Point(ex.x, ex.y - 1));
                ex = (new Point(ex.x, ex.y - 1));
            }

        }

        return findPath;
    }

}

public class homework3 {

    public static void main(String[] arg) {
        var map = new MapBuilder();
        System.out.println(new MapPrint().printM(map.getMap()));
        var lee = new WaveAlgoritm(map.getMap());
        lee.FillMap(new Point(2, 2));
        System.out.println(lee.GetFindPath(new Point(3, 6)) + "\n");
        System.out.println(new MapPrint().printM(map.getMap()));

    }
}
