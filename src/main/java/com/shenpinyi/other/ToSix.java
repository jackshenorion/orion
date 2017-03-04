package com.shenpinyi.other;

/*
* maxOpCounts = 10
* targetResult = 6
* List<Integer> inNums: numbers input
* Integer opCounts = 0;
*
* List<Integer> pNums: numbers in process

* pNums = inNums


*
* Function: do(pNums, opCounts)
*
* opResult
*
* If opCounts greater then maxOpCounts Then
 *   return false
*
* If count of pNums equals to 1 Then
*    currentNum = pNums[0]
*    if currentNum equals to targetResult then
 *       return true
 *   else
 *       for each singleOp in singleOps
 *           currentNum = singleOp(currentNum)
 *           if currentNum equals to targetResult then
 *               return true
 *           else
 *               opResult = do(pNums, opCounts + 1)
 *           if opResult equals to true then
 *               return true
 *           else
 *               continue
*
* For each currentNum in pNums
*     If next number nextNum exists
*         for each binaryOp in binaryOps
*             resultNum = binaryOp(currentNum + nextNum)
*             Replace currentNum and nextNum in pNums
*             opResult = do(pNums, opCounts + 1)
*             if opResult equals to true then
*                 return true
*             else
*                 continue
*         for each singleOp in singleOps
 *           resultNum = singleOp(currentNum)
 *           replace currentNum with resultNum in pNums
 *           opResult = do(pNums, opCounts + 1)
 *           if opResult equals to true then
 *               return true
 *           else
 *               continue
*     else
*         for each singleOp in singleOps
 *           resultNum = singleOp(currentNum)
 *           replace currentNum with resultNum in pNums
 *           opResult = do(pNums, opCounts + 1)
 *           if opResult equals to true then
 *               return true
 *           else
 *               continue
*
*
*
*
*
*
* */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToSix {

    final static int maxOpCount = 8;
    final static int targetResult = 6;
    static int maxSinglOpCount = 0;

    final static List<MySingleOperator> singleOps = Arrays.asList(MySingleOperator.values());
    final static List<MyBinaryOperator> binaryOps = Arrays.asList(MyBinaryOperator.values());

    static class Item {
        private double num;
        private String expression;
        private int singleOpCount = 0;

        public double getNum() {
            return num;
        }

        public Item setNum(double num) {
            this.num = num;
            return this;
        }

        public String getExpression() {
            return expression;
        }

        public Item setExpression(String expression) {
            this.expression = expression;
            return this;
        }

        public int getSingleOpCount() {
            return singleOpCount;
        }

        public Item setSingleOpCount(int singleOpCount) {
            this.singleOpCount = singleOpCount;
            return this;
        }
    }

    public static void start() {
        Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15).forEach(num -> start(num));
    }

    public static void start(double num) {
        List<Item> inNums = Arrays.asList(
            new Item().setNum(num).setExpression(String.valueOf((int) num)),
            new Item().setNum(num).setExpression(String.valueOf((int) num)),
            new Item().setNum(num).setExpression(String.valueOf((int) num))
        );

        for (int i = 0; i < 3; i++) {
            maxSinglOpCount = i;
            List<Item> opNums = new ArrayList<>(inNums);
            if (doIt(opNums, 0)) {
                return;
            }
        }
        System.out.println("Sorry for " + num);
    }

    private static List<Item> getCopy(List<Item> items) {
        List<Item> newItems = new ArrayList<>();
        for (Item item : items) {
            newItems.add(new Item()
                .setNum(item.getNum())
                .setExpression(item.getExpression())
                .setSingleOpCount(item.getSingleOpCount())
            );
        }
        return newItems;
    }

    private static boolean doIt(List<Item> opNums, int opCount) {
        if (opCount > maxOpCount) {
            return false;
        }

        if (opNums.size() == 1) {
            Item currentItem = opNums.get(0);
            double currentNum = currentItem.getNum();
            if (currentNum == targetResult) {
                System.out.println(opNums.get(0).getExpression());
                return true;
            } else {
                if (currentItem.getSingleOpCount() > maxSinglOpCount) {
                    return false;
                }
                for (MySingleOperator singleOp : singleOps) {
                    if (singleOp.isValid(currentNum)) {
                        double opResult = singleOp.run(currentNum);
                        List<Item> newOpNums = getCopy(opNums);
                        newOpNums.get(0)
                            .setExpression(singleOp.description(opNums.get(0).getExpression()))
                            .setNum(opResult)
                            .setSingleOpCount(currentItem.getSingleOpCount() + 1);
                        boolean doResult = doIt(newOpNums, opCount + 1);
                        if (doResult) {
                            return true;
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < opNums.size(); i ++) {
                Item currentItem = opNums.get(i);
                double currentNum = currentItem.getNum();
                if (i < opNums.size() - 1) {
                    Item nextItem = opNums.get(i + 1);
                    double nextNum = nextItem.getNum();
                    for (MyBinaryOperator binaryOp : binaryOps) {
                        if (binaryOp.isValid(currentNum, nextNum)) {
                            double opResult = binaryOp.run(currentNum, nextNum);
                            List<Item> newOpNums = getCopy(opNums);
                            newOpNums.remove(i + 1);
                            newOpNums.set(i, new Item()
                                .setNum(opResult)
                                .setExpression(binaryOp.description(currentItem.getExpression(), nextItem.getExpression()))
                                .setSingleOpCount(0));
                            boolean doResult = doIt(newOpNums, opCount + 1);
                            if (doResult) {
                                return true;
                            }
                        }
                    }

                }

                for (MySingleOperator singleOp : singleOps) {
                    if (currentItem.getSingleOpCount() > maxSinglOpCount) {
                        return false;
                    }
                    if (singleOp.isValid(currentNum)) {
                        double opResult = singleOp.run(currentNum);
                        List<Item> newOpNums = getCopy(opNums);
                        newOpNums.get(i)
                            .setExpression(singleOp.description(currentItem.getExpression()))
                            .setNum(opResult)
                            .setSingleOpCount(currentItem.getSingleOpCount() + 1);
                        boolean doResult = doIt(newOpNums, opCount + 1);
                        if (doResult) {
                            return true;
                        }
                    }
                }
            }

        }

        return false;
    }



    enum MySingleOperator {
        Factorial {
            @Override
            double run(double a) {
                return factorial( (int) a);
            }

            @Override
            String description(String inner) {
                return "factorial(" + inner + ")";
            }

            @Override
            boolean isValid(double a) {
                return a >= 0 && isInteger(a) && a <= 6;
            }

        }, SquareRoot {
            @Override
            double run(double a) {
                return Math.sqrt(a);
            }

            @Override
            String description(String inner) {
                return "squareRoot(" + inner + ")";
            }

            @Override
            boolean isValid(double a) {
                return true;
            }
        }, Negative {
            @Override
            double run(double a) {
                return -a;
            }

            @Override
            String description(String inner) {
                return "negative(" + inner + ")";
            }

            @Override
            boolean isValid(double a) {
                return true;
            }
        };

        abstract double run(double a);
        abstract String description(String inner);
        abstract boolean isValid(double a);
    }

    enum  MyBinaryOperator {
        add {
            @Override
            double run(double a, double b) {
                return a + b;
            }

            @Override
            String description(String innerA, String innerB) {
                return "add(" + innerA + ", " + innerB + ")";
            }

            @Override
            boolean isValid(double a, double b) {
                return true;
            }
        },
        minus {
            @Override
            double run(double a, double b) {
                return a - b;
            }

            @Override
            String description(String innerA, String innerB) {
                return "minus(" + innerA + ", " + innerB + ")";
            }

            @Override
            boolean isValid(double a, double b) {
                return true;
            }
        },
        multiple {
            @Override
            double run(double a, double b) {
                return a * b;
            }

            @Override
            String description(String innerA, String innerB) {
                return "multiple(" + innerA + ", " + innerB + ")";
            }

            @Override
            boolean isValid(double a, double b) {
                return true;
            }
        },
        divide {
            @Override
            double run(double a, double b) {
                return a / b;
            }

            @Override
            String description(String innerA, String innerB) {
                return "divide(" + innerA + ", " + innerB + ")";
            }

            @Override
            boolean isValid(double a, double b) {
                return true;
            }
        };

        abstract double run(double a, double b);
        abstract String description(String innerA, String innerB);
        abstract boolean isValid(double a, double b);
    }

    private static boolean isInteger(double  a) {
        return (a == Math.floor(a)) && !Double.isInfinite(a);
    }

    public static int factorial(int n) {
        int fact = 1; // this  will be the result
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}


