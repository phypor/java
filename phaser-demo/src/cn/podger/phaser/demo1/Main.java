package cn.podger.phaser.demo1;

import java.util.concurrent.Phaser;

/**
 * 
 * 模拟现实： 等到所有同学都到了集中地方，开始上车.
 *
 */
public class Main {

	public static void main(String args[]) {
		int count = 4;
		Phaser phaser = new Phaser(count);
		for (int i = 0; i < count; i++) {
			Thread thread = new Thread(new Task(phaser));
			thread.start();
			System.out.println(thread.getId() + "同学已经到了...");
		}
	}

	public static class Task implements Runnable {
		private Phaser phaser;

		public Task(Phaser phaser) {

			this.phaser = phaser;
		}

		@Override
		public void run() {
			phaser.arriveAndAwaitAdvance();
			System.out.println("已经等齐人了 我上车了...");
		}
	}
}