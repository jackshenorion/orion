package com.shenpinyi.common.dp.RobotInAGrid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jack on 7/05/2017.
 */
public class Solution {

    /**
     * 这道题是一个矩阵,其中每个节点用boolean类型表示可不可以通过
     * 一个机器人在矩阵的左上角,智能往右或者往下走,找到一条可以走的路。
     *
     * 其实这类问题第一感觉就是可以用图遍历实现
     * 其实也可以使用DP来实现
     *
     * 我们下面来看看这两个方法是否都可以解决问题
     */

    public static ArrayList<Point> getPath(boolean[][] maze) {
        ArrayList<Point> path = new ArrayList<>();

        if (maze.length == 0) {
            return path;
        }

        int totalRow = maze.length;
        int totalCol = maze[0].length;

        boolean[][] hasPath = new boolean[totalRow][totalCol];

        for (int row = totalRow - 1; row >= 0; row --) {
            for (int col = totalCol - 1; col >= 0; col --) {
                hasPath[row][col] = maze[row][col];
                if (row == totalRow - 1) { // last row
                    if (col != totalCol - 1) {
                        hasPath[row][col] = hasPath[row][col] && hasPath[row][col + 1];
                    }
                } else {
                    if (col != totalCol - 1) {
                        hasPath[row][col] = hasPath[row][col] && (hasPath[row][col + 1] || hasPath[row + 1][col]);
                    } else {
                        hasPath[row][col] = hasPath[row][col] && hasPath[row + 1][col];
                    }
                }
            }
        }

        if (!hasPath[0][0]) {
            return path; // empty path
        }

        int row = 0;
        int col = 0;
        while (row <= totalRow - 1 && col <= totalCol - 1) {
            Point currentPoint = new Point(row, col);
            path.add(currentPoint);
            if (col == totalCol - 1) {
                row ++;
            } else if (row == totalRow - 1) {
                col ++;
            } else {
                if (hasPath[row][col + 1]) {
                    col ++;
                } else {
                    row ++;
                }
            }
        }
        return path;
    }

    /**
     * 以下使用图遍历实现 BFS 先用单向遍历来实现
     *
     * 如果BFS遍历只是print,代码会比较简单。如果需要打印出path,那么就会比较tricky,
     * 因为每次遍历都是顶点,没有path信息。那么怎么携带path信息呢。
     * 一个方法是遍历的每个顶点包装在wrapper对象里面,这个对象包含一个完整的path。这个方法的缺点是path在每个新的顶点都要copy一份,效率极低。
     * 另一个方法是在wrapper对象中仅保存path的前一个顶点,这样需要保存的信息量就大大减少。为什么这样就可以呢,这个和DFS和BFS遍历的性质有关系,
     * 因为每个节点只遍历一遍,这样它的parent就只有一个。
     *
     */

    public static ArrayList<Point> getPathBFS(boolean[][] maze) {
        Queue<PathNode> queue = new LinkedList<>();

        if (maze[0][0]) {
            queue.add(new PathNode(null, new Point(0, 0)));
        }

        int totalRow = maze.length;
        int totalCol = maze[0].length;
        int lastRow = totalRow - 1;
        int lastCol = totalCol - 1;

        boolean[][] isVisited = new boolean[totalRow][totalCol];

        PathNode finalPath = null;

        while(queue.size() != 0) {
            PathNode path = queue.poll();
            Point currentPoint = path.currentPoint;
            int col = currentPoint.col;
            int row = currentPoint.row;

            if (col == lastCol && row == lastRow) {
                finalPath = path;
                break;
            }

            if (col != lastCol) {
                if (!isVisited[row][col + 1] && maze[row][col + 1]) {
                    queue.offer(new PathNode(path, new Point(row, col + 1)));
                }
                isVisited[row][col + 1] = true;
            }

            if (row != lastRow) {
                if (!isVisited[row + 1][col] && maze[row + 1][col]) {
                    queue.offer(new PathNode(path, new Point(row + 1, col)));
                }
                isVisited[row + 1][col] = true;
            }
        }

        return buildPath(finalPath);
    }


    private static ArrayList<Point> buildPath(PathNode pathNode) {
        LinkedList<Point> path = new LinkedList<>();
        while (pathNode != null) {
            path.addFirst(pathNode.currentPoint);
            pathNode = pathNode.parent;
        }

        return new ArrayList<>(path);
    }

    /**
     * 下面用DFS遍历一遍。
     *
     * 理论上,这个问题使用DFS更合适,因为原点和目标点距离很远,而且矩阵又有一个boundary,不会绕到太远
     * DFS因为使用迭代,所以里面如果携带path,那么就涉及到回溯,把不同的path回溯回去,再去找下一个相邻顶点做DFS
     */

    public static ArrayList<Point> getPathDFS(boolean[][] maze) {
        ArrayList<Point> path = new ArrayList<>();
        getPathDfsHelper(maze, path, new Point(0, 0), new boolean[maze.length][maze[0].length]);
        return path;
    }

    private static boolean getPathDfsHelper(boolean[][] maze, ArrayList<Point> path, Point currentPoint, boolean[][] isVisited) {
        int col = currentPoint.col;
        int row = currentPoint.row;
        int lastRow = maze.length - 1;
        int lastCol = maze[0].length - 1;

        if (!maze[row][col]) {
            return false;
        }

        path.add(currentPoint);

        if (col == lastCol && row == lastRow) {
            return true;
        }

        boolean hasPath = false;

        if (col != lastCol && !isVisited[row][col + 1] && maze[row][col + 1]) {
            isVisited[row][col + 1] = true;
            hasPath = getPathDfsHelper(maze, path, new Point(row, col + 1), isVisited);
            if (hasPath) {
                return true;
            }
        }

        if (row != lastRow && !isVisited[row + 1][col] && maze[row + 1][col]) {
            isVisited[row + 1][col] = true;
            hasPath = getPathDfsHelper(maze, path, new Point(row + 1, col), isVisited);
            if (hasPath) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        boolean a[][] = new boolean[][] {
            {true, true, true},
            {false, true, false},
            {true, true, true}
        };

        boolean b[][] = new boolean[][] {
            {true, true, false},
            {true, false, true},
            {false, true, true}
        };

        System.out.println(getPath(a));
        System.out.println(getPath(b));
        System.out.println(getPathBFS(a));
        System.out.println(getPathBFS(b));
        System.out.println(getPathDFS(a));
        System.out.println(getPathDFS(b));
    }
}

class PathNode {
    PathNode parent;
    Point currentPoint;
    public PathNode(PathNode parent, Point currentPoint) {
        this.parent = parent;
        this.currentPoint = currentPoint;
    }
}

class Point {
    int row;
    int col;
    Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "Point{" +
            "row=" + row +
            ", col=" + col +
            '}';
    }
}
