//给你一个类： 
//
// 
//public class Foo {
//  public void first() { print("first"); }
//  public void second() { print("second"); }
//  public void third() { print("third"); }
//} 
//
// 三个不同的线程 A、B、C 将会共用一个 Foo 实例。 
//
// 
// 线程 A 将会调用 first() 方法 
// 线程 B 将会调用 second() 方法 
// 线程 C 将会调用 third() 方法 
// 
//
// 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。 
//
// 提示： 
//
// 
// 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。 
// 你看到的输入格式主要是为了确保测试的全面性。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出："firstsecondthird"
//解释：
//有三个线程会被异步启动。输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 
//third() 方法。正确的输出是 "firstsecondthird"。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3,2]
//输出："firstsecondthird"
//解释：
//输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。正
//确的输出是 "firstsecondthird"。 
//
// 
//
// 
// 
//提示：
//
// 
// nums 是 [1, 2, 3] 的一组排列 
// 
//
// Related Topics 多线程 👍 516 👎 0


package com.solve.leetcode.editor.cn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 按序打印
 * @author wuou
 * @date 2024-07-21 10:35:18
 */
class P1114_PrintInOrder{
    private static int idx = 0;
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition first = lock.newCondition();
    private static Condition second = lock.newCondition();
    private static boolean flag = true;
    public static void main(String[] args) {
        Runnable runnable1 = () -> {
            while (idx <= 100){
                lock.lock();
                try {
                    while (!flag) {
                        first.await();
                    }
                    if (idx <= 100) {
                        System.out.println(Thread.currentThread().getName()+":"+idx++);
                    }
                    flag = false;
                    second.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        };
        Runnable runnable2 = () -> {
            while (idx <= 100){
                lock.lock();
                try {
                    while (flag) {
                        second.await();
                    }
                    if (idx <= 100) {
                        System.out.println(Thread.currentThread().getName()+":"+idx++);
                    }
                    flag = true;
                    first.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        };

        new Thread(runnable1, "thread 1").start();
        new Thread(runnable2, "thread 2").start();
    }


//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Foo {
    private boolean oneDone = false;
    private boolean secondDone = false;
    private ReentrantLock lock = new ReentrantLock();
    private Condition second = lock.newCondition();
    private Condition third = lock.newCondition();

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            printFirst.run();
            oneDone = true;
            second.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (!oneDone) {
                second.await();
            }
            printSecond.run();
            secondDone = true;
            third.signal();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (!secondDone) {
                third.await();
            }
            printThird.run();
            secondDone = true;
        } finally {
            lock.unlock();
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}